/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * 
 * Package Name:	main
 * File Name: 		DisplayCalendar.java
 * Description:		A program that prompts the user for a year and returns the
 * 					corresponding twelve month calendar
 *
 * Date Created: 	11/13/2014
 * Last Modified:	11/14/2014
 */

//Define this file as a part of the main package
package main;

//Include the scanner class to prompt for input

import javax.swing.*;
import java.util.Scanner;

//Include the JFrame and JOptionPanel classes from the swing class for messages

/* The main class that serves as a container for the Calendar instance */
public class DisplayCalendar {
	//The scanner input for the user
	public static Scanner input = new Scanner(System.in);
	//The frame for a dialogue box
	public static JFrame frame = new JFrame("Dialog");
	//The calendar object
	public static Calendar c = new Calendar();
	//The month or year prompt
	public static String type;
	//The inputted year
	public static int month, year;
	//The range of months
	public static int limitMonth = 12;
	//The limitYear representing the lowest year interpretable by the class
	public static int limitYear = 1800;
	
	/* Define the main method that will initialize our Date format instance */
	public static void main(String[] args) throws Exception, RangeException {
		//Run the program until the user inputs otherwise
		do {
			//Repeat the prompt until a valid number for the count is inputed
			//The type validity
			boolean typeValid;
			do {
				//Check for type validity
				typeValid = checkType();
			} while(!typeValid);
			//Prompt for the month and or year based on the type specified
			//and format the display to the data provided
			if(type.equals("month")) {
				promptMonth();
				promptYear();
				System.out.println();
				//Display the month
				c.display(Calendar.MONTH, month, year);
			} else if(type.equals("year")) {
				promptYear();
				System.out.println();
				//Display the year
				c.display(year);
			}
		} while(runAgain());
		
		//Close the input scanner as it is no longer needed
		input.close();
		System.out.println("Execution complete! Goodbye!");
	}
	
	/* Get the specified year from the Calendar object */
	public static void promptYear() throws RangeException, Exception {
		//Prompt for a year so long as the input is not valid
		//This will repeat the prompts on errors
		//The year validity
		boolean yearValid;
		do {
			//Prompt for the year properties
			System.out.print("Please enter a year after 1800: ");
			//Set the year and indicate if it was properly set
			yearValid = checkYear();
		} while(!yearValid);
	}
	
	/* Get the specified month from the Calendar object */
	public static void promptMonth() throws RangeException, Exception {
		//Repeatedly prompt for a month
		boolean monthValid;
		do {
			//Prompt for the year properties
			System.out.print(
					"Please enter a month either as "
					+ "a name or a number between 1 and 12: "
			);
			//Set the month and indicate if it was properly set
			monthValid = checkMonth();
		} while(!monthValid);
	}

	/* Check the type input and catch all input errors */
	public static boolean checkType() throws Exception {
		try {
			//Try to prompt for the type
			System.out.print("Would you like to enter a month or year? ");
			//Set the count to the user specified int representing repetition
			type = input.nextLine().toLowerCase();
			//Throw an error on invalid input
			if(!type.equals("month") && !type.equals("year")) throw new Exception();
			//Indicate that the input is valid
			return true;
		} catch(Exception e) {
			error("Please enter the word \"month\" or \"year\"!");
		}
		//Failsafe return
		return false;
	}
	
	/* Check and set the year and catch all input errors */
	public static boolean checkYear() throws Exception, RangeException {
		try {
			//Convert the input to a string
			year = Integer.parseInt(input.nextLine());
			//Throw a range exception if necessary
			if(year <= limitYear) throw new RangeException();
			//The input was valid and successful
			return true;
		} catch(RangeException e) {
			//Display the error message
			error("Please enter a year after " + limitYear + ".");
		} catch(Exception e) {
			error("Please enter a valid number for the year!");
		}
		//Failsafe return
		return false;
	}
	
	/* Check and set the month and catch all input errors */
	public static boolean checkMonth() throws Exception, RangeException {
		try {
			//If the input is an int
			if(input.hasNextInt()) {
				//Convert the input to an int
				month = Integer.parseInt(input.nextLine()) - 1;
				//Throw a range exception if necessary
				if(!(month >= 0 && month <= limitMonth-1)) {
					throw new RangeException();
				}
				//Otherwise interpret as string input
			} else {
				//Get the input as a string
				String monthName = input.nextLine();
				//Convert the string to the month number
				int monthNumber = c.toIntMonth(monthName);
				//Check if the converted month is valid
				if(monthNumber != -1) {
					//Apply it
					month = monthNumber;
				} else {
					//Otherwise a valid month name was not specified
					throw new Exception();
				}
			}
			//The input was valid and successful
			return true;
		} catch(RangeException e) {
			//Display the error message
			error("Please enter a month from 1 to " + limitMonth + ".");
		} catch(Exception e) {
			error("Please enter a valid name or number for the month!");
		}
		//Failsafe return
		return false;
	}
	
	/* Display an error message given a string */
	public static void error(String e) {
		//Notify the user of the error using a message dialog
		JOptionPane.showMessageDialog(frame, e);
	}
	
	/* Check whether the user wants to run the program again or not */
	public static boolean runAgain() throws Exception {
		//The answer to the prompt
		String answer = "";
		while(true) {
			try {
				//Prompt for and sanitize input
				System.out.print("Yes or No: Would you like to run the program again? ");
				answer = input.nextLine().toLowerCase();
				//Return the interpreted user response
				return getResponse(answer);
			} catch(Exception e) {
				//Display the error message
				error("Please answer with \"yes\" or \"no\"!");
			}
		}
	}
	
	/* Check the state of a yes or no question with a generic interpreter */
	public static boolean getResponse(String answer) throws Exception {
		//The list of answers that the user can enter
		Object[][] answers = new Object[][] {
            {"yes"		, true},
            {"yeah"		, true},
            {"sure"		, true},
            {"okay"		, true},
            {"ok"		, true},
            {"great"	, true},
            {"why not"	, true},
            {"no"		, false},
            {"nope"		, false},
            {"pass"		, false},
            {"never"	, false},
            {"nein"		, false}
		};
		//Return the user response
		//throw an exception on any unlatching case
		/* 
		//Using a definite answer system that simply checks for "yes" and "no"
		//This implementation is left in for proof of concept and understanding
		switch(answer) {
			case "yes"	: return true;
			case "no" 	: return false;
			default		: throw new Exception();
		}
		*/
		
		/* 
		 * An indefinite answer implementation that allows
		 * for any generic answer and thus more responsive code
		 */
		//Check if the input answer corresponds to any answers[]
		//For each answer, a, in answers[]
		for(int a = 0; a < answers.length; a++) {
			//The current response table
			Object[] response = (Object[])answers[a];
			//The current response string
			String responseString = (String)response[0];
			//Check if the answer is at least equal to a substring of response
			if(answer.substring(0, responseString.length()).equals(responseString)) {
				//Return the response type
				//The current response boolean
				boolean responseBoolean = (Boolean)response[1];
				//True correlates to 'yes' while false to 'no'
				return responseBoolean;
			}
		}
		//No valid response was found
		throw new Exception();
	}
}

/* The RangeException class that signifies inputs that are out of range */
class RangeException extends Exception {
	RangeException() {
		//Call the parent constructor
		super();
	}
	RangeException(Exception e) {
		//Pass the exception to the super constructor class
		super(e);
	}
}

/* START OF OUTPUT *\
Would you like to enter a month or year? month
Please enter a month either as a name or a number between 1 and 12: NovEMber
Please enter a year after 1800: 2014

       November 2014
----------------------------
Sun Mon Tue Wed Thu Fri Sat
                        1   
2   3   4   5   6   7   8   
9   10  11  12  13  14  15  
16  17  18  19  20  21  22  
23  24  25  26  27  28  29  
30  
**Thanksgiving is on the 27

Yes or No: Would you like to run the program again? YeS Please!!!
Would you like to enter a month or year? year
Please enter a year after 1800: 2004

        January 2004
----------------------------
Sun Mon Tue Wed Thu Fri Sat
                1   2   3   
4   5   6   7   8   9   10  
11  12  13  14  15  16  17  
18  19  20  21  22  23  24  
25  26  27  28  29  30  31  

       February 2004
----------------------------
Sun Mon Tue Wed Thu Fri Sat
    1   2   3   4   5   6   
7   8   9   10  11  12  13  
14  15  16  17  18  19  20  
21  22  23  24  25  26  27  
28  29  

         March 2004
----------------------------
Sun Mon Tue Wed Thu Fri Sat
1   2   3   4   5   6   7   
8   9   10  11  12  13  14  
15  16  17  18  19  20  21  
22  23  24  25  26  27  28  
29  30  31  

         April 2004
----------------------------
Sun Mon Tue Wed Thu Fri Sat
            1   2   3   4   
5   6   7   8   9   10  11  
12  13  14  15  16  17  18  
19  20  21  22  23  24  25  
26  27  28  29  30  

          May 2004
----------------------------
Sun Mon Tue Wed Thu Fri Sat
                    1   2   
3   4   5   6   7   8   9   
10  11  12  13  14  15  16  
17  18  19  20  21  22  23  
24  25  26  27  28  29  30  
31  

         June 2004
----------------------------
Sun Mon Tue Wed Thu Fri Sat
    1   2   3   4   5   6   
7   8   9   10  11  12  13  
14  15  16  17  18  19  20  
21  22  23  24  25  26  27  
28  29  30  

         July 2004
----------------------------
Sun Mon Tue Wed Thu Fri Sat
            1   2   3   4   
5   6   7   8   9   10  11  
12  13  14  15  16  17  18  
19  20  21  22  23  24  25  
26  27  28  29  30  31  

        August 2004
----------------------------
Sun Mon Tue Wed Thu Fri Sat
                        1   
2   3   4   5   6   7   8   
9   10  11  12  13  14  15  
16  17  18  19  20  21  22  
23  24  25  26  27  28  29  
30  31  

      September 2004
----------------------------
Sun Mon Tue Wed Thu Fri Sat
        1   2   3   4   5   
6   7   8   9   10  11  12  
13  14  15  16  17  18  19  
20  21  22  23  24  25  26  
27  28  29  30  

       October 2004
----------------------------
Sun Mon Tue Wed Thu Fri Sat
                1   2   3   
4   5   6   7   8   9   10  
11  12  13  14  15  16  17  
18  19  20  21  22  23  24  
25  26  27  28  29  30  31  

       November 2004
----------------------------
Sun Mon Tue Wed Thu Fri Sat
1   2   3   4   5   6   7   
8   9   10  11  12  13  14  
15  16  17  18  19  20  21  
22  23  24  25  26  27  28  
29  30  
**Thanksgiving is on the 26

       December 2004
----------------------------
Sun Mon Tue Wed Thu Fri Sat
        1   2   3   4   5   
6   7   8   9   10  11  12  
13  14  15  16  17  18  19  
20  21  22  23  24  25  26  
27  28  29  30  31  

Yes or No: Would you like to run the program again? Sure why not?
Would you like to enter a month or year? yEAR
Please enter a year after 1800: 1985

        January 1985
----------------------------
Sun Mon Tue Wed Thu Fri Sat
        1   2   3   4   5   
6   7   8   9   10  11  12  
13  14  15  16  17  18  19  
20  21  22  23  24  25  26  
27  28  29  30  31  

       February 1985
----------------------------
Sun Mon Tue Wed Thu Fri Sat
                    1   2   
3   4   5   6   7   8   9   
10  11  12  13  14  15  16  
17  18  19  20  21  22  23  
24  25  26  27  28  

         March 1985
----------------------------
Sun Mon Tue Wed Thu Fri Sat
                    1   2   
3   4   5   6   7   8   9   
10  11  12  13  14  15  16  
17  18  19  20  21  22  23  
24  25  26  27  28  29  30  
31  

         April 1985
----------------------------
Sun Mon Tue Wed Thu Fri Sat
    1   2   3   4   5   6   
7   8   9   10  11  12  13  
14  15  16  17  18  19  20  
21  22  23  24  25  26  27  
28  29  30  

          May 1985
----------------------------
Sun Mon Tue Wed Thu Fri Sat
            1   2   3   4   
5   6   7   8   9   10  11  
12  13  14  15  16  17  18  
19  20  21  22  23  24  25  
26  27  28  29  30  31  

         June 1985
----------------------------
Sun Mon Tue Wed Thu Fri Sat
                        1   
2   3   4   5   6   7   8   
9   10  11  12  13  14  15  
16  17  18  19  20  21  22  
23  24  25  26  27  28  29  
30  

         July 1985
----------------------------
Sun Mon Tue Wed Thu Fri Sat
    1   2   3   4   5   6   
7   8   9   10  11  12  13  
14  15  16  17  18  19  20  
21  22  23  24  25  26  27  
28  29  30  31  

        August 1985
----------------------------
Sun Mon Tue Wed Thu Fri Sat
                1   2   3   
4   5   6   7   8   9   10  
11  12  13  14  15  16  17  
18  19  20  21  22  23  24  
25  26  27  28  29  30  31  

      September 1985
----------------------------
Sun Mon Tue Wed Thu Fri Sat
1   2   3   4   5   6   7   
8   9   10  11  12  13  14  
15  16  17  18  19  20  21  
22  23  24  25  26  27  28  
29  30  

       October 1985
----------------------------
Sun Mon Tue Wed Thu Fri Sat
        1   2   3   4   5   
6   7   8   9   10  11  12  
13  14  15  16  17  18  19  
20  21  22  23  24  25  26  
27  28  29  30  31  

       November 1985
----------------------------
Sun Mon Tue Wed Thu Fri Sat
                    1   2   
3   4   5   6   7   8   9   
10  11  12  13  14  15  16  
17  18  19  20  21  22  23  
24  25  26  27  28  29  30  
**Thanksgiving is on the 28

       December 1985
----------------------------
Sun Mon Tue Wed Thu Fri Sat
1   2   3   4   5   6   7   
8   9   10  11  12  13  14  
15  16  17  18  19  20  21  
22  23  24  25  26  27  28  
29  30  31  

Yes or No: Would you like to run the program again? No thank you...
Execution complete! Goodbye!
\* END OF OUTPUT */