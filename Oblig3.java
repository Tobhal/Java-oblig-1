import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Oblig3 {

  public static Scanner sc;

  public static ArrayList<Planet> planetList = new ArrayList<Planet>();   // Array list, arrayList is better because i can add new elements to the list, it is not fixed
  public static boolean running = true;   // Just here to end the while loop
  public static String planetCSVFile = "Planets.csv";   // The path to the save file

  public static void addPlanet() {    // function for adding a planet

    Planet planet = new Planet();

    System.out.println("Name of the planet: ");
    planet.setName(new UserInput(sc.next()).getString()); // Uses my UserInput class that parses the user input form a string to what i want to use
    System.out.println("The radous of the planet: ");
    planet.setGravity(new UserInput(sc.next()).getDouble()); // Uses my UserInput class that parses the user input form a string to what i want to use
    System.out.println("The gravity for the planet: ");
    planet.setRadous(new UserInput(sc.next()).getDouble()); // Uses my UserInput class that parses the user input form a string to what i want to use

    planetList.add(planet);   // Adds the planet to the arrayList
  }

  public static void editPlanet() {   // Function to edit a planet
    clearConsoll();
    listPlanets();
    System.out.println("Select planet to edit:");
    UserInput index = new UserInput(sc.next());
    
    if (doesPlanetExist(index.getInt() - 1)) {
      System.out.println("Edit(1) or delete(2) the planet. Press 3 to cansle");
      UserInput editing = new UserInput(sc.next());

      switch (editing.getString()) {    // A simple switch to handle difrent input. The input is the String editing
        case "1":
        case "edit":
        case "Edit":
          updatePlanet(index.getInt() - 1);
          break;

        case "2":
        case "delete":
        case "Delete":
          deletePlanet(index.getInt() - 1);
          break;
      
        case "3":
          editPlanet();
          break;

        case "exit":
          exitProgram();
          break;

        default:
          System.out.println(editing + " is not a valid command!");
          editPlanet();
          break;
      }
    } else {
      System.out.println("That planet does not exist.");
    }
  }

  public static void updatePlanet(int index) {    // Updates the planets. Changes the name, radius and gravity
    System.out.println("Enter a new name: ");
    // String newName = sc.next();   // Expects a String
    planetList.get(index).setName(new UserInput(sc.next()).getString());

    System.out.println("Enter a new radius: ");
    // Double newRadius = sc.nextDouble();   // Expects a double
    planetList.get(index).setRadous(new UserInput(sc.next()).getDouble());

    System.out.println("Enter a new gravity: ");
    // Double newGravity = sc.nextDouble();    // Expects a Double
    planetList.get(index).setGravity(new UserInput(sc.next()).getDouble());

    System.out.println("Done editing!");
  }

  public static void deletePlanet(int index) {    // Deletes the planet form the arrayList
    planetList.remove(index);   // Removes the planet (index) from the index
    System.out.println("Planet removed");
  }

  public static void listPlanets() {    // Lists all of the planets
    for (int i = 0; i < planetList.size(); i++) {   // For loop that loops thue the arrayList and prints all of the elements
      System.out.println((i + 1) + " - " + planetList.get(i).getName());    //Gets the planet element from the arrayList then use the getName function in the planets class to get the name
    }
  }

  public static void showPlanet() {   // Shows a lingle planet, for more detail
    listPlanets();
    System.out.println("Choose planet: ");
    UserInput index = new UserInput(sc.next());

    if (doesPlanetExist(index.getInt() - 1)) {
      clearConsoll();
      System.out.println("Name: " + planetList.get(index.getInt() - 1).getName() + "\nRadius: " + planetList.get(index.getInt() - 1).getRadius() + "\nGravity: " + planetList.get(index.getInt() - 1).getGravity());
    } else {
      System.out.println("That planet does not exist.");
    }
  }

  public static void clearPlanets() {   // Clears all of the planets from the arrayList and from the file
    planetList.clear();   // Clears the arrayList
    writeFile();    // Write the emty arrayList to the file to emty it
    System.out.println("Cleared all planets");
  }

  public static void readFile() {   // Import the files objects to the arrayList
    try {
      File file = new File(planetCSVFile);    // Finds the file path
      Scanner fileScanner = new Scanner(file);    // Scanns thrue the file that is spesefied in File and finds the content
  
      fileScanner.nextLine(); // Skips the first line

      while (fileScanner.hasNextLine()) {   // Loops thue the scaned file and does something fir each line in the file, the line gets stored in a array
        String[] splitFileString = fileScanner.nextLine().split(",");   // Splits the line with all commas (,), so all of the elements is a single element in the array

        Planet planet = new Planet(splitFileString[0], Double.parseDouble(splitFileString[1]), Double.parseDouble(splitFileString[2]));   // Creats the new planet
        planetList.add(planet);   // Adds the planet to the listArray
      }
      fileScanner.close();    // Close the file scanner, because is it not used anymore

      System.out.println("Planets Added:");
      listPlanets();    // Lists all of the planets. There is not a filter to not print planets that is not added in this function
    } catch (Exception e) {
      System.out.println("Eksisterer " + planetCSVFile + " ?");   // If the file does not exist this will be printet
      System.out.println(e.toString());   // -------------------------------------
    }
  }

  public static void writeFile() {    // Write the arrayList to the file. file writer needs to be in a "try catch"
    try {
      File file = new File(planetCSVFile);    // Creates the file
      FileWriter fileWriter = new FileWriter(file);   // Starts a new file Writer on the file
      
      fileWriter.write("Name, Radius, Gravitasjon");  // Adds the headers

      for (int i = 0; i < planetList.size(); i++) {   // Loops thue the array list and writes all the elements to the file
        fileWriter.write("\n");
        fileWriter.write(planetList.get(i).getName() + "," + planetList.get(i).getRadius() + "," + planetList.get(i).getGravity());
      }
      
      fileWriter.flush();   // Remoes the buffer of characters
      fileWriter.close();   // Close the fileWriter afther the it is flushed

    } catch (Exception e) {
      //TODO: handle exception
    }
  }

  public static void listCommands() {   // Just prints a statis set list of all commands
    System.out.println("0 - List commands");
    System.out.println("1 - Add Planet");
    System.out.println("2 - List Planets");
    System.out.println("3 - Show Planet");
    System.out.println("4 - Edit Planets");
    System.out.println("5 - Save Planets");
    System.out.println("6 - Load Planets File");
    System.out.println("7 - Clear all (restart)");
    System.out.println("9 - Exit");
  }

  public static void chooseCommand() {    // Choose the command
    
    System.out.println("Type a command: (0 for all commands)");
    
    switch (new UserInput(sc.next()).getString()) {    // Switch case for the difrent input that is expected
      case "0":
      case "help":
      case "Help":
        clearConsoll();
        listCommands();
        break;
      case "1":
        clearConsoll();
        addPlanet();
        break;
      case "2":
        clearConsoll();
        listPlanets();
        break;
      case "3":
        clearConsoll();
        showPlanet();
        break;
      case "4":
        clearConsoll();
        editPlanet();
        break;
      case "5":
        clearConsoll();
        writeFile();
        System.out.println("Planets saved to file");
        break;
      case "6":
        clearConsoll();
        readFile();
        break;
      case "7":
        clearConsoll();
        clearPlanets();
        break;
      case "loaf turtle":
      case "loaf":
      case "turtle":
        clearConsoll();
        printLoafTurtle();
        break;
      case "9":
      case "exit":
      case "Exit":
        clearConsoll();
        exitProgram();
        break;

      default:
        clearConsoll();
        System.out.println("That is not a valid command. \n type 0 to list all commands");
        break;
    }
  }

  public static void clearConsoll() {   // Clears the console
    try {
      if (System.getProperty("os.name").contains("Windows"))    // Test if the system is windows or not
          new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();   // Runs cmd, then the command (/c) cls
      else {
          System.out.print("\033[H\033[2J");    // If it is not windows then this. find the height of the consol window (\033[H) then puts that many new lines (\033[2J) 
          // System.out.flush();    // Not needed, but i have it her if i finde errors
      }
    } catch (IOException | InterruptedException ex) {}
  }

  public static void exitProgram() {    // To exit the program
    clearConsoll();   // First clear the console
    running = false;    // Then set running to false so the while loop exits
  }

  public static boolean doesPlanetExist(int index) {    // Return if a planet exitst in the planets arrayList, if it exits then return true, else return false
    if (index < planetList.size() && index >= 0) {  // If the planet index is above 0 and inside the size of planetList then return true
      return true;
    } else {
      return false;
    }
  }

  public static void mainLoop() {   // The main loop
    chooseCommand();
  }
  
  public static void main(String args[]) {

    sc = new Scanner(System.in);    // Start a "scanner" that can read the input form the command line
    
    while (running) mainLoop();   // While loop so that the program can be exited
    
    sc.close();
    
  }

  public static void printLoafTurtle() {
    String loafTurtle = "*****************************,***//(((/**,............................,,,,,,,,,\n" + 
    "***************,,,,,,,,,*/(%%%%%%%%###/#%#%#%%%%#*,.....,,,,,,,,,,,,,,,,,,,,***\n" +
    "***********,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,\n" +
    "*********,,,,,,,,,,*#%%%%%%%%%#(*#%%%#%%%%%%%###(////**,,,,,,,,,,,,,,,,,,,,,,,,\n" +
    "****************/%&%%%%%%%%%#/(%%%%%##(#%#%#((//*%%%#(((((,..................,,\n" +
    "*************/%%%%%%%%%%%%#(/#%####((######(/**##(##(//////*,...........,,,,,,,\n" +
    "************%%%#%%%%##((((//#%%%##/%##(///(/*/(/(#///((/**//**,,,,,,,,,,,,,,,,,\n" +
    "*****,,,,*####(((#%%%%%#//%%%%#%#%%###(#/**%#((((***(((/(//**,**,,,,,,,,,,,,,,,\n" +
    "******,,*##((%%%%%%###(*(%#######((((/(/*(##/(/////((*******,/(/*..............\n" +
    "********((#(#########(*%%###########((/*##/(#/(///**/((*****///**,.............\n" +
    "*******/##((#(##(#(((*####(#(((#(((((/*##((//////*(//*(***(//*****,.....,,,,,,,\n" +
    "****(#####((#(#(#(/(*(((((((((((((((//#((((*//**/(////**,/********,,,,,,,,,,,,,\n" +
    "***#%#(##((#((((((///////////*/***/**///((((/*//*////(**//////****,,,,,,,,,,,,,\n" +
    "**((#(#((((((((/*****//(((##(#(//**##(/(////***///(((((############(#%%/.......\n" +
    "*/%#((##((((((/(//*//(((/(*///(/**((/(////*//((((/(((#################(#(......\n" +
    "****(%&&%(((((((/**(/(//////*/***(/////*/////(((/(((####################(*.....\n" +
    "*****/#%%%(((/(//*/(////*/******//////////((/(//(((((##########((((((((((/,,,,,\n" +
    "*******/(#%#((((//((///////****/////*/////((///(((((##(##(((((/,*/((((((((/,,,,\n" +
    "****,,,,*##%%#(((((((((((((((/////****/*//////((((((((((((((((////((///(///,,,,\n" +
    "*****,,,,,*(#%%#((((#(((///(###((((//////(/(/(/(((((((((((((((((//////////(*,,,\n" +
    "****,,,,,,,,*/##%%(#%%%####/**((((((((/////(/((((((((((((((((/////////*/*/&*...\n" +
    "***********,,,,**/#%%##((/(((**///////////(#(/(((/////////(////((//********,...\n" +
    "**************,,,,#####(((////**////////((###/////////////////&@&(*********....\n" +
    "***********,*,,*,*####(((//**//(*,,,,***/%%&&&///////////////////*********.....\n" +
    "***************,,,(%%#((////(*.........,,(##%%%////////////////////#&&&/*......\n" +
    "*******,,*,,,,,,,,,,,,*//*,,............,*(####%%///////////////////////,,,,,,,\n" +
    "*********,,,,,,,,,,,,,,,,,.................*(###%%%//////////////#%#/,,,,,,,,\n" +
    "*********,*,,,,,,,,,,,,*,,.,.....,........,,,*/(####%%%%%&&&&&%%%%##/,,,,,,,,,,\n" +
    "*********,*,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,*/((#########(/*,,,,,,,,,,,,*\n" +
    "***********,,,,*,**,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,*,,    \n" + 
    "Loaf Turtle!!!!!\n";
    
    
    System.out.println(loafTurtle);
  }
}

/*  TODO
- Test userInput class

*/