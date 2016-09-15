import java.util.Scanner;

public class GPA {
   public static void main(String[] args) {
      printGPA();
   }
   
   public static void printGPA() {
       //Construct the scanner
       Scanner input = new Scanner(System.in);
       
       //Prompt for the student name and socres
       System.out.print("Enter a student record: ");
       String name = input.next();
       
       //Get the number of records
       int numbScores = input.nextInt();
       
       //The scores array
       int[] scores = new int[numbScores];
       
       //For each upcomming score
       for(int s = 0; s < numbScores; s++) {
           //Prompt for the current score and store it in a score list
           scores[s] = input.nextInt();
       }
       
       //The sum of the scores
       float sum = 0;
       
       //For each score in the list excluding the name and total
       for(int i = 0; i < numbScores; i++) {
           //Get the sum of the scores
           sum += scores[i];
       }
       
       //The avg of the scores
       float avg = sum/(numbScores);
       
       //Print the scores
       System.out.println(name + "'s grade is " + avg);
   }
}