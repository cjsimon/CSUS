package main;

import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.text.DecimalFormat;

/**
 * Calculates and stores the average, greatest and least
 * values of an array of doubles. This implementation is
 * created for optimization and is all done in one method
 * @author Christopher Simon
 * @version 1.0
 */
public class Calculation {
    // The calculation results
    static double average = 0.0, greatest = 0.0, least = 0.0;

    // The strings of stored calculations used for printing
    // Calculation results are appended to these strings.
    // This can be disabled using the Toggle
    static String averages = "", greatests = "", leasts = "";

    // Use a decimal formatter to round and pad to two decimal places
    private static DecimalFormat df = new DecimalFormat("00.00");

    // The boolean used to toggle storing of calculation
    public static boolean store = true;

    /**
     * Calculates the greatest, least and average of an array of doubles
     * @param   doubles The input array of doubles
     */
    public static void calculate(double[] doubles) throws InvalidParameterException {
        // Set the rounding properties of the df to round up on a value of 5 or greater
        df.setRoundingMode(RoundingMode.HALF_UP);

        int totalDoubles = doubles.length;

        // Exception and shorthand handling
        if(totalDoubles == 0) throw new InvalidParameterException();
        if(totalDoubles == 1) {
            greatest = least = average = doubles[0];
            if(store) {
                // Store the formatted calculations if necessary
                greatests = leasts = averages = df.format(Double.toString(doubles[0]));
            }
            return;
        }

        // Start the greatest and least counts with
        // negative and positive infinity respectively
        double greatest = Double.NEGATIVE_INFINITY;
        double least    = Double.POSITIVE_INFINITY;
        // The sum of the doubles
        double sum = 0;

        // For each double as d
        for(double d : doubles) {
            // Add the currentDouble to the sum
            sum += d;

            // If the currentDouble is greater/lower than the current greatest/least,
            // then by definition it is the new greatest/least
            if(d > greatest)    greatest = d;
            if(d < least)       least    = d;
        }

        // Save the greatest, least and average double values
        Calculation.greatest = greatest;
        Calculation.least    = least;
        Calculation.average  = sum / totalDoubles;

        // Store the calculations if necessary
        if(store) {
            greatests += df.format(greatest) + " ";
            leasts    += df.format(least)    + " ";
            averages  += df.format(average)  + " ";
        }
    }

    /**
     * Static toString method used for printing to the console
     * @return  String
     */
    static String getString() {
       String output = (
            "AVG  %s%n" +
            "HIGH %s%n" +
            "LOW  %s%n"
        );

        String s = String.format(output, greatests, leasts, averages);
        return s;
    }
}