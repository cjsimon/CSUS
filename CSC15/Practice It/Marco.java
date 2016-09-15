import java.util.Scanner;
public class Marco {
   public static int day(Scanner kb) {
      int theDay;
      //prompt the user to enter the day
      System.out.println("Please enter the day.");
      //check to see if the user is entering an integer for the day
      theDay = kb.nextInt();
      return theDay;
   }
   public static int year(Scanner kb) {
     int theYear;
      //prompt the user to enter the year
      System.out.println("Please enter the year.");
      //check to see if the user is entering an integer for the day
      theYear = kb.nextInt();
      return theYear;
   }
   public static String holiday(String Stringmonth, int intday, int intyear) {
      String theHoliday = "";
      if (Stringmonth.equals("January") && intday == 1) {
         theHoliday = "New Year's Day";
      }else if (Stringmonth.equals("January") && intday == 20 && intyear == 2014) {
         theHoliday = "Martin Luther King Jr. Day";
      }else if (Stringmonth == "February" && intday == 2 && intyear == 2014) {
         theHoliday = "Ground Hog Day";
      }else if (Stringmonth == "February" && intday == 17 && intyear == 2014) {
         theHoliday = "Abraham Lincoln's Birthday";
      }else if (Stringmonth == "February" && intday == 14) {
         theHoliday = "St. Valeninte's Day";
      }else if (Stringmonth == "February" && intday == 17 && intyear == 2014) {
         theHoliday = "George Washington's Birthday";
      }else if (Stringmonth == "March" && intday == 17 && intyear == 2014) {
         theHoliday = "St. Patrick's Day";
      }else if (Stringmonth == "April" && intday == 1) {
         theHoliday = "April Fool's Day";
      }else if (Stringmonth == "April" && intday == 20 && intyear == 2014) {
         theHoliday = "Easter";
      }else if (Stringmonth == "April" && intday == 22 && intyear == 2014) {
         theHoliday = "Earth Day";
      }else if (Stringmonth == "April" && intday == 26 && intyear == 2014) {
         theHoliday = "Abor Day";
      }else if (Stringmonth == "April" && intday == 27) {
         theHoliday = "Mom's Birthday";
      }else if (Stringmonth == "May" && intday == 1) {
         theHoliday = "May Day";
      }else if (Stringmonth == "May" && intday == 5) {
         theHoliday = "Cinco de Mayo";
      }else if (Stringmonth == "July" && intday == 4) {
         theHoliday = "Independence Day";
      }else if (Stringmonth == "August" && intday == 3) {
         theHoliday = "International Friendship Day";
      }else if (Stringmonth == "August" && intday == 9) {
         theHoliday = "My Birthday";
      }else if (Stringmonth == "October" && intday == 13 && intyear == 2014) {
         theHoliday = "Columbus Day";
      }else if (Stringmonth == "October" && intday == 31) {
         theHoliday = "Halloween";
      }else if (Stringmonth == "November" && intday == 11 & intyear == 2014) {
         theHoliday = "Vereran's Day";
      }else if (Stringmonth == "December" && intday == 25) {
         theHoliday = "Christmas";
      }else if (Stringmonth == "December" && intday == 31) {
         theHoliday = "New Year's Eve";
      }
      return theHoliday;
   }
   
   public static String getMonthString(int monthNum) {
       String name = "";
       switch(monthNum) {
         case 1 : name = "January";
                  break;
         case 2 : name = "February";
                  break;
         case 3 : name = "March";
                  break;
         case 4 : name = "April";
                  break;
         case 5 : name = "May";
                  break;
         case 6 : name = "June";
                  break;
         case 7 : name = "July";
                  break;
         case 8 : name = "August";
                  break;
         case 9 : name = "September";
                  break;
         case 10: name = "October";
                 break;
         case 11: name = "November";
                  break;
         case 12: name = "December";
                  break;
         }
       return name;
   }
   
   public static int getMonthNum(String m) {
      int month = 0;
      switch (m) {
         case "January"  : month = 1;
                        break;
         case "February" : month = 2;
                           break;
         case "March"    : month = 3;
                           break;
         case "April"    : month = 4;
                           break;
         case "May"      : month = 5;
                           break;
         case "June"     : month = 6;
                           break;
         case "July"     :  month = 7;
                           break;
         case "August"   :  month = 8;
                           break;
         case "September"   : month = 9;
                           break;
      }
   return month;
  }
   
   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);
      int program;
      //ask the user how many times to run the code
      System.out.println("Please enter the amount of times you want the program to run.");
      program = kb.nextInt();
     //create a for loop
      for (int i = 1; i <= program; i++) {
      
      String theMonth = "";
      System.out.println("Please choose the current month.");
      
      int intMonth;
      String nameMonth;
      if (kb.hasNextInt()){
        intMonth = kb.nextInt();
        nameMonth = getMonthString(intMonth);
      } else {
        nameMonth = kb.next();
        intMonth = getMonthNum(nameMonth);
      }
      kb.nextLine();
      
      int theDay = day(kb);
      int theYear = year(kb);
      String theHoliday = holiday(nameMonth, theDay, theYear);
      System.out.print("The current date is: " + intMonth + "/" + theDay + "/" + theYear + " ");
      System.out.println(nameMonth + " " + theDay + ", " + theYear);
      System.out.println(theHoliday);
      }
   }
}