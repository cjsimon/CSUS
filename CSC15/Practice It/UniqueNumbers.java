import java.util.ArrayList;
import java.util.List;

class UniqueNumbers
{
   public static void main(String[] args) {
      System.out.println(
         differentNumbers(new int[] { 1, 5, 2, 98, 3, 6, 2, 2, 3, 7, 5, 7, 85, 98 })
      );
   }

   public static int differentNumbers(int[] numbers) {
       /*****************************************
        * Now, I'd really like to create an engine
        * so that any amount of inputted numbers
        * can work for this function as a result
        * we pass the parameters into an array
        *****************************************/
       
       //The list holding one of each different number
       List<Integer> differenceList = new ArrayList<Integer>();
       
       //The number of differences
       int count = 0;
       
       //For each element in the numbers array
       for(int n : numbers) {
           //Compare the current number to the difference array
           //If the number already exists in the differenceList, do not add it
           //Otherwise add the number to the list
           if(!differenceList.contains(n)) {
               differenceList.add(n);
               //In this case, we only need to count the number of differences
               count++;
           }
       }
       
       //Return the number of different numbers
       return count;
   }
}