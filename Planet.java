public class Planet {
  private String name;     // The name of the planet
  private double radius;   // The radius of the planet
  private double gravity;  // The gravoty of the planet

  Planet() {
    
  }

  Planet(String name, double radius, double gravity) {  // Makes it posible to use constroctors with the class, so i can add parameters to the new Planet insted of setting that later
    this.name = name;
    this.radius = radius;
    this.gravity = gravity;
  }

  public void setName(String name) {   // Sett method for the name
    this.name = name;
  }
  public String getName(){    // Get method for the name
    return name;
  }

  public void setRadous(double radius) {   // Sett method for the name
    this.radius = radius;
  }
  public double getRadius() {   // Get method for the name
    return radius;
  }

  public void setGravity(double gravity) {   // Sett method for the Gravity
    this.gravity = gravity;
  }
  public double getGravity() {    // Get method for the Gravity
    return gravity;
  }

  public void printPlanet() {   // Prints all of the plannets that is stored
    System.out.println("The planet " + name + " has a radus of: " + radius + " km and the gravity is: " + gravity + "m/(s^2)");
  }
}