import java.util.Scanner;

public class smallestLargest {
   public static void main(String[] args) {
      better();
   }
   
   public static void value() {
      //Create a scanner
      Scanner s = new Scanner(System.in);
      
      //Prompt for the size of the array
      System.out.print("How many numbers do you want to enter? ");
      int size = s.nextInt();
      
      //The largest and smallest values
      //Since the first inputted number
      //is always supposed to be the
      //largest/smallest, set the limits
      //to the min and max values respectivly
      int largest = Integer.MAX_VALUE;
      int smallest = Integer.MAX_VALUE;
      
      //For each number to be inputted
      for(int i = 0; i < size; i++) {
         System.out.println("Number" + (i+1) + ": ");
         int currentNumber = s.nextInt();
         //Initialize the numbers on the first iteration
         if(i == 0) {
            //THe first inputted number is automatically the greatest
            largest = currentNumber;
            smallest = currentNumber;
         }
         if(currentNumber > largest) {
            //This is now the largest unmber
            largest = currentNumber;
         }
         if(currentNumber < smallest) {
            //This is now the smallest number
            smallest = currentNumber;
         }
      }
      //Print the largest ansd smallest numbers
      System.out.println("Largest: " + largest);
      System.out.println("Smallest: " + smallest);
   }
   
   public static void better() {
      Scanner s = new Scanner(System.in);
      //The number of times to enter
      int count = 0;
      //The currentNumber
      int current = 0;
      //Largest Smallest
      int largest;
      int smallest;
      System.out.println("How many numbers do you want to enter? ");
      count = s.nextInt();
      
      //Promt for the first number
      System.out.println("Number 1: ");
      current = s.nextInt();
      //This is the first number
      largest = smallest = current;
      
      //For each of the other numbers
      for(int i = 2; i <= count; i++) {
         System.out.println("Number" + i + ": ");
         current = s.nextInt();
         if(current > largest) {
            largest = current;
         }
         if(current < smallest) {
            smallest = current;
         }
      }
      System.out.println("Largest: " + largest);
      System.out.println("Smallest: " + smallest);
   }
}