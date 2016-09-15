public class GreatestAbs
{
   public static void main(String[] args) {
      System.out.print (
         largestAbsVal(new int[] {10, -100, 50, 4 -1, -333, 12, -184, 8, 4})
      );
   }
   
   //Return the int with the largest abs value of a list of ints
   public static int largestAbsVal(int[] n) {
      //The greatest abs number first defined as the first number
      int greatest = Math.abs(n[0]);
      
      //Chech for the greatest number of the array
      //starting with the second element
      //as the first element is always the greatest of no other elements 
      for(int i = 1; i < n.length; i++) {
          //The current element's abs value
          int currentElement = Math.abs(n[i]);
          //Check if the currentElement is greater than the current greatest int
          if(greatest < currentElement) {
              //The currentElement int is greater
              //Assign it as the new greatest int
              greatest = currentElement;
          }
      }
      //Return the greatest value
      return greatest;
   }
}