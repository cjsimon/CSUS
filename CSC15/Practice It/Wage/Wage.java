public class Wage {
   public static void main(String[] args) {
      System.out.println(
         pay(8.75, 12)
      );
   }
   public static double pay(double salary, int hours) {
       //Define the pay
       double pay = 0d;
       //The overPay wage
       double overSalary = (salary * 1.5d);
       //For the first 8 hours
       for(int h = 0; h < 8 && hours > 0; h++, hours--) {
           //Give the hourly salary for each hour
           pay += salary;
       }
       //For the remainder of hours after 8 hours
       for(int overTime = 0; overTime < hours; overTime++) {
           //Give overPay hourly salary
           pay += overSalary;
       }
       //Give the man his paycheck, damnit!
       return pay;
   }
}