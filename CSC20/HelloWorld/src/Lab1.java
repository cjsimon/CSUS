/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 20 - 4
 * Instructor:		Professor Nguyen
 *
 * File Name: 		Lab1.java
 * Description:		Prompts for user input and displays it
 *
 * Date Created: 	2/3/2015
 * Last Modified:	2/4/2015
 */

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        //Prompt for the age, income and name
        int age 	 = promptInt(input, "What is your age? ");
        float income = promptFloat(input, "What is your annual income? ");
        String name  = promptString(input, "What is your name? ");
        System.out.println();

        //Print the message
        String message = (
            "Hello, %s!%n"
            + "Your age is %d!%n"
            + "Your annual income is $%.2f!"
        );
        System.out.printf(message, name, age, income);
    }

    /* Prompt the user for a String given a scanner and a message */
    public static String promptString(Scanner input, String m) {
        //Print the message
        System.out.print(m);
        String s;

        try {
            //Try to capture the input
            //if it fails indicate so and prompt again
            s = input.nextLine();
        } catch(Exception e) {
            //An error occurred
            System.out.println("Please enter a string!");
            //Clear the input
            input.nextLine();
            //Prompt the user again
            return promptString(input, m);
        }
        return s;
    }

    /* Prompt the user for an int a scanner and a message */
    public static int promptInt(Scanner input, String m) {
        //Print the message
        System.out.print(m);
        int i;

        try {
            //Try to capture the input
            //if it fails indicate so and prompt again
            i = input.nextInt();
            input.nextLine();
        } catch(Exception e) {
            //An error occurred
            System.out.println("Please enter an integer!");
            //Clear the input
            input.nextLine();
            //Prompt the user again
            return promptInt(input, m);
        }
        return i;
    }

    /* Prompt the user for a float given a scanner and a message */
    public static float promptFloat(Scanner input, String m) {
        //Print the message
        System.out.print(m);
        float f;

        try {
            //Try to capture the input
            //if it fails indicate so and prompt again
            f = input.nextFloat();
            input.nextLine();
        } catch(Exception e) {
            //An error occurred
            System.out.println("Please enter a float!");
            //Clear the input
            input.nextLine();
            //Prompt the user again
            return promptFloat(input, m);
        }
        return f;
    }
}
