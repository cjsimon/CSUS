public class perfectNumbers {
   public static void main(int limit) {
      String list = "";
      for(int i = 1; i <= limit; i++) {
         if(isPerfect(number)) {
            list += number + " ";
         }
         System.out.print("Perfect numbers up to " + limit);
         System.out.print(": " + list);
      }
      
      public static boolean isPerfect() {
         //Find list of factors
         //Add up the list offactors
         int sum = 0;
         for(int i = 2; i < n; i++) {
            //Get sum of factors
            //Factor: has no remainder!
            if(n % i == 0) {
               sum += i;
            }
            if(n == sum) {
               return true;
            }
            return false;
         }
      }
   }
}