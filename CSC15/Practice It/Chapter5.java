import java.util.*;

public class Chapter5 {
   public static void main(String[] args) {
      //randomLines();
      //makeGuesses();
      //threeHeads();
      //System.out.println(consecutiveRight(3,5,4,8,6,7));
      //randomWalk();
      //System.out.println(mode(new int[] {4,5,2,7,3,7}));
      System.out.println(monthApart(1, 8));
   }
   
   public static void randomLines() {
       //Get a random number between 5 and 10
       //that represents the number of rows
       int rTotal = (int)(10 - Math.random() * 5);
       //For each row
       for(int r = 0; r < rTotal; r++) {
           //Generate a random number from 0 to 80
           //representing the number of characters in the columb
           int cTotal = (int)(Math.random() * 80);
           //For each character in the current line
           //Otherwise known as the columb
           for(int c = 0; c < cTotal; c++) {
               //Each character in a string is represented by an int
               //Generate a random char with a value from 0 to 26
               //which represents the characters a-z in java
               //In java, an int literal can be stored into a char
               char character = (char)((int)(Math.random() * 26));
               //Print the random character
               System.out.print(character);
           }
           //Next Line
           System.out.println();
       }
   }
   
   /* Working */
   public static void randomWalk() {
       //Start the displacement at 0
       int d = 0;
       //The range of values
       int min = 0;
       int max = 1;
       //The largest position
       //Make fun of the badly worded question: dMax
       int dMax = 0;
       
       //Print the initial position
       System.out.println("position = " + 0);
       //While d is in between -3 and 3
       while(d < 3 && d > -3) {
           //The change of movement
           //This is just inversion at this point as random is from 0 to 1
           //but it's good practice of expression writting
           double m = (max - Math.random() * (max-min));
           if(m < 0.5) {
               d -= 1;
           } else {
               d += 1;
           }
           //Update the dMax if the current displacement is greater
           if(d > dMax) {
               dMax = d;
           }
           //Print the position
           System.out.println("position = " + d);
       }
       //Badly worded question but print the largest position, not the "maximum"
       System.out.println("max position " + dMax);
   }
   
   public static void makeGuesses() {
    //The number to guess
    int guess = 48;
    //The range of number to guess from
    int min = 1; 
    int max = 50;
    //The totalNumber of entries is defined as the max-min
    int totalNumbers = max-min;
    //Create an array of totalNumbers elemnts
    int[] numbers = new int[totalNumbers];
    //Populate the number array from min to max digits
    for(int i = min; i < max; i++) {
        //The index of an element of numbers[] is defined as the (current element i - min)
        //This is an offset that accounts for range
        int index = (i - min);
        //Store the current number into the array
        numbers[index] = i;
    }
    //The number of guesses
    int guessCount = 0;
    //The guess element index in the numbers[]
    int guessIndex = (guess - min);
    //Check whether the guess in numbers[] has been eliminated yet
    while(numbers[guessIndex] == guess) {
        //The randNumber and it's index in the numbers[]
        int randNumber, index;
        //Check if this number was already guessed
        //If it has make another guess
        do {
            //Pick another random number from min to max
            randNumber = (int)(max - (Math.random() * (max-min)));
            //And reevaluate the index for the new number
            index = (randNumber - min);
        } while(numbers[index] != randNumber);
        //Eliminate it from the numbers[]
        //set the current element value to a number that is not used in numbers[]
        //min-1 is never used in numbers[]
        numbers[index] = (min-1);
        //Print the randNumber
        System.out.println("guess = " + randNumber);
        //Incrament the guessCount
        guessCount++;
    }
    //Print the number of guesses
    System.out.print("total guesses = " + guessCount);
   }
   
   public static void threeHeads() {
       //Create a random object
       Random r = new Random();
       //The headCount
       int headCount = 0;
       while(headCount < 3) {
           boolean heads = ((2 % (r.nextInt(3)+1)) == 0);
           if(heads) {
            headCount++;
            System.out.println("Heads");
           } else {
            headCount = 0;
            System.out.println("Tails");
           }
       }
       System.out.println("Three heads in a row!");
   }

   public static boolean consecutive(int n1, int n2, int n3) {
         int[] numbers = new int[3];
         //Populate and sort the input numbers
         numbers[0] = n1;
         numbers[1] = n2;
         numbers[2] = n3;
         Arrays.sort(numbers);
       
         for(int n = 0; n < 2; n++) {
            if(!(Math.abs(numbers[n+1] - numbers[n]) == 1)) {
               return false;
            }
         }
         return true;
   }


   //This is the ideal and correct way
   public static boolean consecutiveRight(Integer... numbers) {
      //Sort the array
      Arrays.sort(numbers);
      //Check if the current value is one less than the next value
      for(int n = 0; n < numbers.length-1; n++) {
         if(!(Math.abs(numbers[n+1] - numbers[n]) == 1)) {
            return false;
         }
      }
      return true;
   }

   public static int mode(int[] num) {
      //The range of outcomes starting from 0
      int size = 10;
      int[] count = new int[size + 1];
      for(int n : num) {
          //Incrament the count of the key which represents the number
          count[n]++;
          System.out.print(n + " ");
      }
      Arrays.sort(count);
      //reverse(count);
      System.out.println(Arrays.toString(count));
      return Arrays.asList(count).indexOf(1);
   }
   
   public static boolean monthApart(int m1, int d1, int m2, int d2) {
       if(m1 == m2) {
           return false;
       }
       if(Math.abs(m1 - m2) > 1) {
           return true;
       }
       if(m1 > m2) {
         return d1 - d2 >= 0;
       }
       return d2 - d1 >= 0;
   }
}