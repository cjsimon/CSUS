public class GetGrade {
   public static void main(String[] args) {
      //Get the user's grade
      try {
         System.out.println(getGrade(84));
         System.out.println(getGrade(14));
         System.out.println(getGrade(44));
         //System.out.println(getGrade(984));
         System.out.println(getGrade(89));
         System.out.println(getGrade(100));
      } catch(Exception e) {
         //Print the error stack trace
         e.printStackTrace();
      }
   }
   
   public static double getGrade(int s) throws IllegalArgumentException {
       if(s < 0 || s > 100) {
           //That grade doesn't exist! Throw an argument exception
           throw new IllegalArgumentException("That grade doesn't exist! Please enter a number from 0 to 100.");   
       }
       
       //The grade
       double g = 0;
       
       if(s < 60) {
         g = 0.0;
       } else if(s > 60 && s <= 62) {
         g = 0.7;
       } else if(g >= 95) {
         g = 4.0;
       } else {
         g = 0.1 * (s - 55);
       }
              
       //Return the grade
       return g;
   }
}