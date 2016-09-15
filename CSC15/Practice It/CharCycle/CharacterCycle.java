//Import libraries
import java.util.*;
import java.lang.*;
import java.io.*;

public class CharacterCycle {
   public static void main(String[] args) {
      //The letter to append
      String l = "";
      //The number to append
      int number = 0;
      //Incrament boolean
      boolean inc = true;
      //The row and columb counts
      int rTotal = 40;
      int cTotal = 4;
      //The character cycle
      int character = 0;
      
      //For each columb
      for(int c = 0; c < cTotal; c++) {
          //For each row position
          for(int r = 0; r < rTotal; r++) {
             //Determine the row character
             switch(c) {
                 case 0:
                     l = "-"; 
                     break;
                 case 1:
                     //I'd gladly write a function here, but the compiler won't let me
                     //Cycle between different characters in the same row
                     switch(character) {
                         case 0: l = "_"; break;
                         case 1: l = "-"; break;
                         case 2: l = "^"; break;
                         case 3: l = "-"; break;
                     }
                     character++;
                     if(character > 3) {
                         character = 0;
                     }
                     break;
                 case 2:
                     //Same issue...
                     if(inc) {
                        number++;
                        inc = false;
                     } else {
                        inc = true;
                     }
                     //Cycle between different numbers in the same row
                     if(number > 9) {
                         number = 0;
                     }
                     //Assign the number as the letter
                     //Don't forget to convert with ""
                     l = number + "";
                     break;
                 case 3:
                     l = "-";
                     break;
              }
              //Print the character
              System.out.print(l);
          }
          //Row has ended
          System.out.println("");
      }
   }
}