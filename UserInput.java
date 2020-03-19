public class UserInput {
  private String userInput;

  // Declaration
  UserInput() {
  }

  UserInput(String input) {
    userCommand(input);
    this.userInput = input;
  }

  // Functions
  public void printInput() {
    System.out.println(userInput);
  }

  // Set
  public void setInput(String input) {
    userCommand(input);
    this.userInput = input;
  }  

  // Get
  public String getString() {
    return userInput;
  }

  public int getInt() {
    if (canParseInt(this.userInput)) {
      return Integer.parseInt(userInput);
    } else {
      return 0;
    }
  }

  public long getLong() {
    if (canParseLong(this.userInput)) {
      return Long.parseLong(userInput);
    } else {
      return 0;
    }
  }

  public float getFloat() {
    if (canParseFloat(this.userInput)) {
      return Float.parseFloat(userInput);
    } else {
      return 0;
    }
  }

  public double getDouble() {
    if (canParseDouble(userInput)) {
      return Double.parseDouble(userInput);
    } else {
      return 0.0;
    }
  }

  public boolean getBoolean() {
    if (canParseBoolean(userInput)) {
      return Boolean.parseBoolean(userInput);
    } else {
      return false;
    }
  }

  private void userCommand(String input) {
    switch (input) {
      case "/exit":
        System.exit(0);
        break;
    
      default:
        break;
    }
  }

  private static boolean canParseInt(String value) {
    try {
      Integer.parseInt(value);
      return true;
    } catch(Exception e) {
      return false;
    }
  }

  private static boolean canParseLong(String value) {
    try {
      Long.parseLong(value);
      return true;
    } catch(Exception e) {
      return false;
    }
  }

  private static boolean canParseFloat(String value) {
    try {
      Float.parseFloat(value);
      return true;
    } catch(Exception e) {
      return false;
    }
  }

  private static boolean canParseDouble(String value) {
    try {
      Double.parseDouble(value); 
      return true; 
    }catch(Exception e) {
      return false; 
    }
  }

  private static boolean canParseBoolean(String value) {
    try {
      Boolean.parseBoolean(value); 
      return true; 
    }catch(Exception e) {
      return false; 
    }
  }
  /*
  private static boolean canParseChar(String value) {
    try {
       
      return true; 
    }catch(Exception e) {
      return false; 
    }
  }
  */
}