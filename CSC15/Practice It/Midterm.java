import java.util.Scanner;
public class Midterm {
   public static void main(String[] args) {            
      System.out.println(numbers(365));
   }
   
   public static String space(String s) {
      //The resultant string
      String sSpace = "";
      
      for(int i = 0; i < s.length(); i++) {
         sSpace += s.charAt(i) + " ";
      }
      //Return the string with spaces
      return sSpace;
   }
   
   public static String numbers(int n) {
      //The string of numbers
      String numString = "";
      while(n > 0) {
         //Store the remainder (The last digit)
         numString += (n % 10);
         //Reduce and truncate the number
         n = n / 10;
      }
      
      //Reverse the order of the string as it is backwards
      return reverse(numString);
   }
   
   public static String reverse(String s) {
      //THe reversed string
      String reverse = "";
      //The length of the string
      int length = s.length();
      for(int i = length-1; i > 0; i--) {
         //Append to the reverse string
         reverse += s.charAt(i);
      }
      return s;
   }
}