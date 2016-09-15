/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * 
 * Package Name:	main
 * File Name: 		DatePrompt.java
 * Description:		A program that prompts the user for a date and returns
 *					the holidays associated with the inputted date 
 *
 * Date Created: 	10/20/2014
 * Last Modified:	10/20/2014
 */

//Define this file as a part of the main package
package main;
//Include the custom Date class to format inputted dates and to check holidays
import calendar.Holiday;
import calendar.SwitchHoliday;
//Include the scanner class to prompt for input
import java.util.Scanner;
//Include the JFrame and JOptionPanel classes from the swing class for messages
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* The Holiday class that serves as a container for a Date instance */
public class DatePrompt {
	//The scanner input for the user
	public static Scanner input = new Scanner(System.in);
	//The frame for a dialogue box
	public static JFrame frame = new JFrame("Dialog");
	//Define a holiday object for use
	public static Holiday myDate;
	//The inputed month, day and year
	public static int month;
	public static int day;
	public static int year;
	
	/* Define the main method that will initialize our Date format instance */
	public static void main(String[] args) throws Exception {
		//The number of times to run the date prompt
		int count;
		//Init a new Holiday object that the user interacts with through input
		//Note: One can optionally use a HolidaySwitch object to view
		//the functionality required by the homework assignment
		myDate = new Holiday();
		//Additionally, more holidays can be added to the list
		myDate.addHoliday("Jesus' Birthday", 12, 25);
		//Repeat the following until the desired conditions are met
		//In this case, we break when the user has inputed a valid input
		while(true) {
			try {
				//Try to prompt for number of repetitions
				System.out.print(
					"How many times would you "
					+ "like to run the program? "
				);
				//Set the count to the user specified int
				//representing repetition
				count = input.nextInt();
				//Clear the extra data in the stream
				//that nextInt never interpreted
				input.nextLine();
				//The user has inputted a number
				//Break the loop
				break;
			} catch(Exception e) {
				//Display the error message
				error("Please enter a valid number for repetition!");
				//Clear the current line data
				input.nextLine();
			}
		}
		
		//Run the Date object as many times as the user has specified
		//For each iteration of the program
		for(int i = 0; i < count; i++) {
			//Prompt for the date properties
			System.out.println("\nPlease enter the date month, day, and year");
			
			//Repeat the following so long as the input is not valid
			//This will repeat the prompts on errors
			//The day validity
			boolean monthValid;
			do {
				//Prompt for the month adn get the validity status
				monthValid = promptMonth();
			} while(!monthValid);
			
			//The day validity
			boolean dayValid;
			do {
				//Prompt for the day and get the validity status
				dayValid = promptDay();
			} while(!dayValid);
			
			//The year validity
			boolean yearValid;
			do {
				//Prompt for the month an get the validity status
				yearValid = promptYear();
			} while(!yearValid);
			
			//Set the date of the Date object to the user input values
			myDate.setDate(month, day, year);
			//Format and display the date along with
			//the holidays that are associated with it
			System.out.println("\nThe date is: "
				+ myDate.getDate(Holiday.ALL)
				+ "\nHolidays: "
				+ myDate.getHoliday()
			);
		}
		
		//Close the input scanner as it is no longer needed
		input.close();
		System.out.println("\nExecution compleate! Goodbye!");
	}
	
	/* Prompt for the month and catch all input erros in the process */
	public static boolean promptMonth() throws Exception {
		try {
			//Prompt for a date
			System.out.print("Month: ");
			//Is the input an integer?
			if(input.hasNextInt()) {
				//Parse the input as an int
				month = input.nextInt();
				//Clear the stream
				input.nextLine();
			} else {
				//Get the input as a string
				String monthName = input.nextLine();
				//Convert the month name into an int representation
				month = myDate.getMonthNumber(monthName);
			}
			//Check if the month is valid
			if(!myDate.isMonthValid(month)) {
				//Trigger the catch
				throw new Exception();
			}
			//The input was valid and successful
			return true;
		} catch (Exception e) {
			//Display the error message
			error(
				"Please enter a valid month using "
				+ "a number representation or name!"
			);
		}
		//Failsafe return
		return false;
	}
	
	/* Prompt for the day and catch all input erros in the process */
	public static boolean promptDay() throws Exception {
		try {
			System.out.print("Day: ");
			//Convert the input to a string
			day = Integer.parseInt(input.nextLine());
			//Check if the day is valid
			if(!myDate.isDayValid(month, day)) {
				//Trigger the catch
				throw new Exception();
			}
			//The input was valid and successful
			return true;
		} catch(Exception e) {
			//Display the error message
			error(
				"Please enter a valid number for the day!"
			);
		}
		//Failsafe return
		return false;
	}
	
	/* Prompt for the year and catch all input erros in the process */
	public static boolean promptYear() throws Exception {
		try {
			System.out.print("Year: ");
			//Convert the input to a string
			year = Integer.parseInt(input.nextLine());
			//The input was valid and successful
			return true;
		} catch(Exception e) {
			//Display the error message
			error(
				"Please enter a valid number for the year!"
			);
		}
		//Failsafe return
		return false;
	}
	
	/* Displays an error meessage and clears the scanner input */
	public static void error(String e) {
		//Notify the user of the error using a message dialog
		JOptionPane.showMessageDialog(
			frame,
			e
		);
	}
}

/* START OF OUTPUT *\
~---------------------------------------------------------------~
Hello there!
Please insert a month, day, and year of choice for the program
and it will generate the specified date with the corresponding
holidays that lie on that date.

In terms of formatting:
A month can be inputted as:
- A full month name (i.e. "January")
- An abbreviated form of the month (i.e. "Jan")
- A number representation of the month (i.e. "1")

A day must be entered as a number (i.e. "5")

A year must be entered as a four digit number (i.e. 2010)
~---------------------------------------------------------------~
How many times would you like to run the program? 7

Please enter the date month, day, and year
Month: 5
Day: 5
Year: 2005

The date is: May 5, 2005  |  5/5/2005
Holidays: Cinco de Mayo

Please enter the date month, day, and year
Month: 2
Day: 12
Year: 2003

The date is: February 12, 2003  |  2/12/2003
Holidays: Abraham Lincoln's Birthday

Please enter the date month, day, and year
Month: April
Day: 20
Year: 2007

The date is: April 20, 2007  |  4/20/2007
Holidays: Grandma's Birthday

Please enter the date month, day, and year
Month: 12
Day: 25
Year: 1995

The date is: December 25, 1995  |  12/25/1995
Holidays: Christmas and My Birthday and Jesus' Birthday

Please enter the date month, day, and year
Month: 4
Day: 5
Year: 2015

The date is: April 5, 2015  |  4/5/2015
Holidays: Easter

Please enter the date month, day, and year
Month: Apr
Day: 16
Year: 1921

The date is: April 16, 1921  |  4/16/1921
Holidays: 

Please enter the date month, day, and year
Month: Sept
Day: 21
Year: 2017

The date is: September 21, 2017  |  9/21/2017
Holidays: 

Execution compleate! Goodbye!
\* END OF OUTPUT */