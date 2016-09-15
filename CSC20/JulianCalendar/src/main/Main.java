package main;

import calendar.PrintCalendar;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Main container class that handles a PrintCalendar instance
 *
 * @author Christopher Simon
 */
public class Main {
    // The scanner
    Scanner input = new Scanner(System.in);

    /**
     * Entry point of the program. The first arg is interpreted as the input year
     *
     * @param args      Arguments passed in during execution
     */
    public static void main(String[] args) {
        // The inputYear for the calendar
        // Get the first argument as the inputYear for the start of the program
        int inputYear = getArguments(args);

        // Instantiate a PrintCalendar instance with the inputYear
        PrintCalendar c = new PrintCalendar(inputYear);
        // Print the twelve month calendar
        c.printYear();
    }

    /**
     * Gets the arguments that were passed into the program
     * <p>
     * Specifically checks for <code>args[0]</code> initialization so that it may be interpreted as an <code>inputYear</code>
     *
     * @param args      Arguments passed in during execution from the main method
     * @return          <code>args[0]</code> or the current year as the <code>inputYear</code>
     */
    public static int getArguments(String[] args) {
        int inputYear;
        // If no arguments exist
        if(args.length == 0) {
            // Set the inputYear to the current year, as no arguments were provided
            inputYear = Calendar.getInstance().get(Calendar.YEAR);
        } else {
            // Interpret the first argument as the inputYear for the calendar
            inputYear = Integer.parseInt(args[0]);
        }
        return inputYear;
    }
}