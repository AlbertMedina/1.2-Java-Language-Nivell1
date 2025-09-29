package Level2;

public class Main {
    public static void main(String[] args) {

        String name = Input.readString("Enter your name");
        byte age = Input.readByte("Enter your age");
        float height = Input.readFloat("Enter your height");
        double weight = Input.readDouble("Enter your weight");
        int favouriteNumber = Input.readInt("Enter your favourite number");
        char myChar = Input.readChar("Enter any character you like");
        boolean isMusicLover = Input.readYesOrNot("Do you like music? Enter Y/y or N/n");

        System.out.println();

        System.out.println("About you:");
        System.out.println("Your name is " + name + ".");
        System.out.println("You are " + age + ".");
        System.out.println("Your height is " + height + ".");
        System.out.println("Your weight is " + weight + ".");
        System.out.println("You favourite number is " + favouriteNumber + ".");
        System.out.println("The character you entered is " + myChar + ".");
        System.out.println("You " + (isMusicLover ? "are" : "aren't") + " a music lover.");

        Input.closeScanner();
    }
}
