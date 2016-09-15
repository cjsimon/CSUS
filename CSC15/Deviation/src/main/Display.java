/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * Instructor:		Professor Faroughi
 * 
 * Package Name:	main
 * File Name: 		Display.java
 * Description:		The main class that displays the calculated deviations
 *
 * Date Created: 	11/21/2014
 * Last Modified:	11/21/2014
 */

package main;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Display {
	//The Input Scanner
	public static final Scanner input = new Scanner(System.in);
	//The deviation instance
	public static Deviation d = new Deviation();
	//The iteration count
	public static int i;
	/* The main method that prompts for input and displays deviation results */
	public static void main(String[] args) {
		//Run the program so long as the user specifies so
		do {
			//Prompt for the set of numbers
			prompt();
			//Display the various deviation properties
			//as deifned in the deviation class of instance d
			display(d);
			//Clear the numbers in the array
			d.clear();
		} while(runAgain());
		//Close the scanner input as it is no longer needed
		input.close();
		System.out.println("Goodbye! :)");
	}
	
	/* Prompt for the numbers */
	public static void prompt() {
		//The current number, n, and iteration, i
		double n = 0;
		i = 0;
		//The termanation (0) status
		boolean done = false;
		System.out.println(
			"You will be prompted to enter your numbers."
			+ " Enter \"0\" to indicate the end of your input."
		);
		//While n is not 0 
		while(!done) {
			//Get the next double from the input stream as n
			n = getDouble();
			//Check the value of n
			if(n != 0) {
				//Processes the valid number
				//Add n to the list of numbers
				d.add(n);
			} else if(i > 0) {
				//Indicate that a zero value terminator was found
				done = true;
			} else {
				//No numbers were entered
				error("Please enter at least one number!");
				//Repeat the current iteration by deincramenting
				i--;
			}
			//Incrament the iterator count
			i++;
		}
	}
	
	/* Display all of the deviation properties of a specified deviation instance */
	public static void display(Deviation d) {
		//Invoke the specified object's get methods and store the data
		String numbers 	 = d.get();
		double average 	 = d.getAverage();
		double variance  = d.getVariance();
		double deviation = d.getDeviation();
		//Display the data
		System.out.printf(
			"%nYou entered: %s%nAverage: %.2f%nVariance: %.2f%nDeviation: %.2f%n%n",
			numbers, average, variance, deviation
		);
	}
	
	/* Get the next double from the input stream while checking for errors */
	public static double getDouble() {
		System.out.print("Number " + (i+1) + ": ");
		try {
			return Double.parseDouble(input.nextLine());
		} catch(Exception e) {
			//Indicate that the input was invalid
			error("Please enter a number!");
			//Rerun the method until a valid input is found
			return getDouble();
		}
	}
	
	/* Prompt the user for another run and return the response */
	public static boolean runAgain() {
		//Prompt for and store the input response
		System.out.print("Yes or No: Do you have another set of numbers? ");
		String response = input.nextLine();
		//Interpret the response else display an error and recall the prompt
		if(response.equalsIgnoreCase("yes")) {
			return true;
		} else if(response.equalsIgnoreCase("no")) {
			return false;
		} else {
			//Run the prompt recrusivly until an ethical answer is given
			error("Please enter \"Yes\" or \"No\"!");
			//Return the recrusive method result the the original request
			return runAgain();
		}
	}
	
	/* Display an error meessage given a string */
	public static void error(String e) {
		//The frame to s the message on
		JFrame frame = new JFrame("Dialog");
		//Notify the user of the error using a message dialog
		JOptionPane.showMessageDialog(frame, e);
	}
}

/* START OF OUTPUT *\
You will be prompted to enter your numbers. Enter "0" to indicate the end of your input.
Number 1: 3
Number 2: 8
Number 3: 3
Number 4: 7
Number 5: 2
Number 6: 0

You entered: 3.0, 8.0, 3.0, 7.0, 2.0
Average: 4.60
Variance: 5.84
Deviation: 2.42

Yes or No: Do you have another set of numbers? yes
You will be prompted to enter your numbers. Enter "0" to indicate the end of your input.
Number 1: 2
Number 2: 4
Number 3: 6
Number 4: 10
Number 5: 0

You entered: 2.0, 4.0, 6.0, 10.0
Average: 5.50
Variance: 8.75
Deviation: 2.96

Yes or No: Do you have another set of numbers? no
Goodbye! :)
\* END OF OUTPUT */
