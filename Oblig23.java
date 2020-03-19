class Oblig23 {
  public static void main(String args[]) {
    Planet planet1 = new Planet("Mars", 3389.5, 3.711);

    System.out.println("The planet " + planet1.getName() + " has a radus of: " + planet1.getRadius() + " km and the gravity is: " + planet1.getGravity() + "m/(s^2)");
  }
}