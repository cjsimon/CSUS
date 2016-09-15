import java.util.Arrays;

public class SwapArrays {
   public static void main(String[] args) {
      //Int arrays
      int[] n1 = new int[] { 1, 2, 3 };
      int[] n2 = new int[] { 4, 5, 6 };
      //Swap 1 and 2
      swap(n1, n2);
      System.out.println(Arrays.toString(n1) + "\n" + Arrays.toString(n2) + "\n");
      //Assign a zero to the element at index 1
      zero(n1, 1);
      System.out.println(Arrays.toString(n1) + "\n" + Arrays.toString(n2));
   }
   
   public static void swap(int[] n1, int[] n2) {
      int[] temp = new int[3];
      temp = n1;
      n1 = n2;
      n2 = temp;
   }
   
   public static void delete(int[] n1, int n) {
      boolean found = false;
      int index = 0;
      while(!found) {
         if(n1[index] == n) {
            found = true;
         }
         index++;
      }
      index--;
      for(int i = index; i < n1.length - 1; i++) {
         n1[i] = n1[i+1];
      }
      n1[n1.length-1] = 0;
   }
   
   public static void zero(int[] n1, int i) {
      n1[i] = 0;
   }
}