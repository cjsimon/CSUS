class PerfectNum {
   public static void main(int limit) {
      String list = "";
      for(int i = 1; i <= limit; i++) {
         //Is the current number a perfect number?
         if(isPerfect(number)) {
            list += number + " ";
         }
         System.out.print("Perfect numbers up to " + limit);
         System.out.print(": " + list);
   }
   
   public static boolean isPerfect(int n) {
         //Find list of factors
         //Add up the list of factors
         int sum = 0;
         for(int i = 2; i < n; i++) {
            //Get sum of factors
            //Factor: has no remainder!
            if(n % i == 0) {
               sum += i;
            }
            //A perfect number is defiend
            //as a number whose factors equals the number
            if(n == sum) {
               //This is a perfect number
               return true;
            }
            //THis is not a perfect number
            return false;
         }
   }
}