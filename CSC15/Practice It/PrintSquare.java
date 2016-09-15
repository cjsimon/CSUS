public class PrintSquare
{  
   public static void main(String[] args) {
      printSquare(1, 5);
   }
   
   public static void printSquare(int min, int max) {
      //The pattern of the square
      String pattern = "";
      //Construct the string
      for(int i = min; i <= max; i++) {
         //Apend the character to the pattern
         pattern += i;
      }
      
      //Print out the original pattern
      System.out.println(pattern);
      
      //For each line
      for(int i = 1; i < max; i++) {
         //Get the first character
         String firstChar = pattern.substring(0, 1);
         //Truncate the firstChar off the pattern string
         pattern = pattern.replace(firstChar, "");
         //Append the firstChar to the end of the pattern string
         pattern += firstChar;
         //Now print the new pattern string
         System.out.println(pattern);
      }
   }
}