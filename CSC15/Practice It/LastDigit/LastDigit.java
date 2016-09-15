public class LastDigit
{
   public static void main(String[] args) {
      System.out.println(last(3572));
      System.out.println(last(-947));
      System.out.println(last(6));
   }

   public static int last(int n) {
       //Get the abs value of the number
       //so that the algorithm works with neg numbers too
       n = Math.abs(n);
       //Upcast our input int into a float value
       //And divide by 10
       float num = (float)(n) / 10;
       //This algorithm will get the last digit of n
       int lastDigit = (int) Math.round(((num - Math.floor(num)) * 10));
       //Return the digit
       return lastDigit;
   }
}