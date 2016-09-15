import java.util.Arrays;

public class Binary
{
	public static void main(String[] args) {
	  System.out.println(toBinary(42));
	}
   
   public static String binaryString(int b) {
      //Parse the int into binary
      String s = Integer.toBinaryString(b);
      return s;
   }
   
   public static String toBinary(int b) {
       //Hardcode the zero value
       if(b <= 0) return "0";
       
       //The binary as a string
       String s = "";
       
       //The current power placement
       int p = 0;
       //The current powerValue starting at 2^p
       int powerValue = 1;
       
       //Start with the first power greater than two
       while(powerValue <= b) {
           //Get the first power of two that is greater than b
           powerValue *= 2;
           p++;
       }
       
       //Keep reducing the input integer until all powers have been checked
       while(p > 0) {
           //Deincrament the powerValue by each power until a power less than b is found
           powerValue /= 2;
           //Get the rest of the binary numbers
           if(powerValue > b) {
               //A deincrament tells us that the current power is greater than b
               //This means that it is not present (0) in b
               s += 0;
           } else {
               //Current powerValue is less than b
               //Subtract it
               b = b - powerValue;
               //The current power is less than zero, and is therefore included in b
               //which means that the current power placement is present (1) within b
               s += 1;
           }
           //Deincrament to the next power
           p--;
       }
       //Return the binary string :D
       return s;
   }
}