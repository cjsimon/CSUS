package calendar;

import java.util.Calendar;

/**
 * Formats and displays a calender in the console
 * <p>
 * Given a year, a twelve month calendar will be generated.
 * The year can be passed in the class constructor, setter
 * method or through the print
 *
 * @author Christophr Simon
 * @version 1.0
 */
public class PrintCalendar {
    // The year, month within that year, and days within that month
    private int year;
    private int month;
    private int days;
    // Enumerated constants for instance variables
    private enum Vars {YEAR, MONTH, DAYS}
    // The julian date that calculates the day of the week in which a month starts on
    private final JulianDate jd = new JulianDate();

    // Constructors
    /**
     * Creates a PrintCalendar instance with a set year if it is passed
     *
     * @param year      The year to create the calendar for
     */
    public PrintCalendar() {}
    public PrintCalendar(int year) {
        setYear(year);
    }

    //
    // Setters
    //

    /**
     * Sets the year to print the calendar for
     *
     * @param year      The input year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Sets the month to print the calendar for
     *
     * @param month     The month specifically within the set year
     */
    public void setMonth(int month) {
        this.month = month;
    }

    //
    // Getters
    //

    /**
     * Get the year instance variable
     *
     * @return int
     */
    public int getYear() {
        return year;
    }

    /**
     * Get the month instance variable
     *
     * @return int
     */
    public int getMonth() {
       return month;
    }

    /**
     * Gets the number of days in a month. The year is passed in as a parameter
     * so that leap year calculations can be made for Feburary if necessary
     *
     * @param month     The month to get the number of days
     * @param year      The year to check for a leap year
     * @return int      Number of days in the specified month
     */
    public int getDays() {
        if(isSet(Vars.MONTH) && isSet(Vars.YEAR)) {
            return getDays(month, year);
        }
        return 0;
    }
    public int getDays(int month, int year) {
        switch(month) {
            // 31 Days
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            // 30 Days
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            // February
            case 2:
                return (isLeapYear(year) ? 29 : 28);
            // Failsafe return
            default: return 0;
        }
    }

    //
    // Display Calendar
    //

    /**
     * Prints a year calendar containing all months given a year
     *
     * @param year                          The year to display a twelvemonth calendar for
     * @throws IllegalArgumentException     If year is not initialized
     */
    public void printYear() throws IllegalArgumentException {
        // Use the year if it has already been set
        if(isSet(Vars.YEAR)) {
            printYear(year);
        }
    }
    public void printYear(int year) {
        // Print the year label
        System.out.printf("%13s%n%n", year);
        // Print each month
        for(int m = 1; m <= 12; m++) {
            printMonth(m, year);
        }
    }

    /**
     * Prints a month calendar for a given month and year
     * <p>
     * A month calendar consists of the month name, day names
     * and days included in that month. If no arguments are passed
     * the instance variables will be used if they have been set
     *
     * @param month     The month to display
     * @param year      The year which the month is located
     */
    public void printMonth() {
        if(isSet(Vars.MONTH) && isSet(Vars.YEAR)) {
            printMonth(month, year);
        }
    }
    public void printMonth(int month, int year) {
        // Print the month name, day names and days
        printMonthName(month);
        printDayNames();
        printDays(month, year);
    }

    /**
     * Prints the numbered days of the given month
     *
     * @param month     The month to print the days
     */
    private void printDays() {
        if(isSet(Vars.MONTH) && isSet(Vars.YEAR)) {
            printDays(month, year);
        }
    }
    private void printDays(int month, int year) {
        // Get the number of days in the month
        int days = getDays(month, year);
        // Get the first day of the month
        int firstDay = ((jd.toJulian(year, month, 1) + 1) % 7) + 1;

        if((firstDay - 1) > 0) {
            // Print the padding for the first day
            // 3 spaces per day
            System.out.printf("%" + ((firstDay - 1) * 3) + "c", ' ');
        }
        // The currentDay count that keeps track of the days in one week for alignment
        int currentDay = firstDay;
        for(int j = 1; j <= getDays(month, year); j++) {
            System.out.printf(" %2s", j);
            // If the current day is the last day of the week
            if(currentDay == 7) {
                // Move to the next week
                System.out.print("\n");
                // Reset the currentDay count
                currentDay = 0;
            }
            currentDay++;
        }
        System.out.print("\n\n");
    }

    //
    // Display Labels
    //

    /**
     * Prints the month name as a header for the calendar according
     * to a given month
     * <p>
     * This current implementation is based on an array index.
     * No IndexOutOfBounds Exceptions are handled
     *
     * @param month     The month name to print
     */
    private void printMonthName() {
        if(isSet(Vars.MONTH)) {
            printMonthName(month);
        }
    }
    private void printMonthName(int month) {
        //The month string
        final String[] months = new String[] {
                "  January",
                " February",
                "   March" ,
                "   April" ,
                "    May"  ,
                "   June"  ,
                "   July"  ,
                "  August" ,
                "September",
                " October" ,
                " November",
                " December"
        };
        // Print the month with the padding
        String monthName = "      " + months[month-1];
        // The padding is not done in printf
        // as it keeps the dates shifted
        System.out.printf("%s%n", monthName);
    }

    /**
     * Prints the names of the days of the week
     */
    private void printDayNames() {
        System.out.println("  S  M  Tu W  Th F  S");
    }

    //
    // Booleans
    //

    /**
     * Checks if the specified instance variable has been set
     *
     * @param instanceVar                   The enum instance variable
     * @return bool                         The init status
     * @throws IllegalArgumentException     If var is not set
     */
    private boolean isSet(Vars instanceVar) throws IllegalArgumentException {
        switch(instanceVar) {
            case YEAR:
                if(year != 0) return true;
                break;
            case MONTH:
                if(month != 0) return true;
                break;
            case DAYS:
                if(days != 0) return true;
                break;
        }
        // The var was not set
        // Throw an exception
        throw new IllegalArgumentException();
    }

    /**
     * Check if the current or specified year is a leap year
     *
     * @param year      The year to test
     * @return bool
     */
    public boolean isLeapYear() {
        if(isSet(Vars.YEAR)) {
            return isLeapYear(year);
        }
        //Failsafe return
        return false;
    }
    public boolean isLeapYear(int year) {
        // A leap year is divisible by 400 or divisible by 4 but not 100
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }
}