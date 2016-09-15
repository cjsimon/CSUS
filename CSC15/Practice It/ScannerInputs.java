import java.util.Scanner;

public class ScannerInputs {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      //input.useDelimiter("");
      
      System.out.println("What is your name?");
      //Get the first token
      String name = input.next();
      //The carriage return is still present, so skip over it
      input.nextLine();
      System.out.println("Hello " + name + "!");
      
      System.out.println("What is your full name?");
      //Get the full string
      String fullName = input.nextLine();
      System.out.println("Hello " + fullName + "!");
      
      System.out.println("How old are you?");
      int age = input.nextInt();
      System.out.println("In ten yrs you will be " + (age+10) + " years old!");
      input.nextLine();
      
      System.out.println("What is your favorite food?");
      //Get the first token
      String food = input.nextLine();
      System.out.println("This is your food: " + food);
      //BASICALLY ANYTHING EXCEPT NEXTLINE() NEEDS A NEXTLINE
   }
}