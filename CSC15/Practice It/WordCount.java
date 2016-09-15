import java.util.regex.*;

public class WordCount {
   public static void main(String[] args) {
      System.out.println(""
         + "\n" + betterCount("hello world!") 
         + "\n" + betterCount(" YES!  ")
         + "\n" + betterCount("    THANK GOD!     THIS WORKS!   ")
      );
   }
   
   public static int oldCount(String s) {
       //Return 0 if the string is only one or fewer characters long
       if(s.length() <= 1) return 0;
       //As long as whitespace exists before the first character
       while(s.substring(0, 1).equals(" ")) {
           //Remove the whitespace by disincluding it
           s = s.substring(1);
       }
       //The pattern to use for removing whitespace
       String pattern = "[\\s]+";
       //Replace multiple whitespaces with one whitespace per word
       s = s.replaceAll(pattern, " ");
       //Create an array listing each word in an element
       String[] words = s.split(" ");
       //Count the number of elements
       int count = words.length;
       //Return the count
       return count;
   }
   
   
   public static int betterCount(String s) {
       //The word count
       int count = 0;
       //The regex pattern that gets each word
       Pattern p = Pattern.compile("[^\\s]+");
       //Construct the wordMatcher from the Pattern.matcher for the specified string
       Matcher wordMatcher = p.matcher(s);
       //While a word match is found add it to the word count
       while(wordMatcher.find()) count++;
       //Return the count
       return count;
   }
}