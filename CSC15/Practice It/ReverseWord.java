import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class ReverseWord
{  
   public static void main(String[] args) {
       //Generate a string array
       //populating each element with one letter
       /*
       Before jdk8 split("") will produce the following:
       new String[] { "", "t", "e", "s", "t"} 
       */
       String w = "Hello World!";
       String[] letters = w.split("");
       //Convert the array to an List
       //as it has a reverse property
       List<String> letterList = Arrays.asList(letters);
       //Reverse the letters in the list
       Collections.reverse(letterList);
       //For each letter in the letterList
       for(String letter : letterList) {
           System.out.print(letter);
       }
   }
}