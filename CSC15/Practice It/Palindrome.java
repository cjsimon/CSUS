public class Palindrome
{
   public static void main(String[] args) {
      //Scanner
      Scanner input = new Scanner(System.in);
      //Palindrome
      printPalindrome(input);
      betterPal(input);
   }
   
   public static betterPal(Scanner input) {
      Scanner s = new Scanner(System.in);
      System.out.print("Type in words! ");
      String word = s.nextLine();
      String reverse = "";
      for(int i = word.length()-1; i >= 0; i--) {
         reverse += word.charAt(i);
      }
      
      if(word.equalsIgnoreCase(reverse)) {
         System.out.println("This is reversed!");
      } else {
         System.out.println("Not a reversed word!");
      }
   }
   
   public static void printPalindrome(Scanner input) {    
       //Prompt for words
       System.out.println("Type one or more words: ");
       //The desired word to be tested
       String originalWord = input.next();
       
       //The word to be manipulated
       String word = originalWord.toLowerCase();
       //Get the character count of the word in order to determine how to split it
       int characterCount = word.length();
       
       //The midCount is now equal to half the count, and represents the splitting mark
       int bMidCount = count/2;
       int aMidCount = midCount + 1;
       
       //Is the characterCount odd?
       if(characterCount % 2 != 0) {
           //Remove the middle character as it equals itself in the comparision
           word = word.substring(0, bMidCount) + word.substring(0, aMidCount);
           //Subtract one from the count as the character has been removed
           count -= 1;
       }
       
       //Now that the word is even, split it in half, reverse the outter end and compare values
       //The beginning of the word
       String front = word.substring(0, bMidCount);
       //The end of the word
       String end = word.substring(aMidCount);
       String newEnd = "";
       //Flip the end string
       for(int i = count-1; i > 0; i--) {
           newEnd += end.substring(i-1,1);
       }
       
       //Finally, is this word a palindrone?
       isPalindrome = (front == end) ? true : false;
       
       //Print the output
       System.out.println(originalWord + " is" + isPalindrome + "a Palindrome.");  
   }
}