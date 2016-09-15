/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * 
 * Package Name:	calendar
 * File Name: 		Date.java
 * Description:		A date formatting engine that outputs the given holidays
 *					assosiated with the inputted date and what day Easter is on
 *
 * Date Created: 	10/20/2014
 * Last Modified:	10/20/2014
 */

//Define this file as a part of the custom package, calendar
package calendar;

/* 
 * The date class that prompts for a month, day and year and outputs the
 * formatted date with the corresponding holidays that lie on the date
 */
public class Date {
	//The constants for the various date display options
	public static final int MONTH = 0;
	public static final int SLASH = 1;
	public static final int ALL   = 2;
	
	//The initial month, day and year
	public int month = 1;
	public int day 	 = 1;
	public int year  = 1970;
	
	//The hardcoded directions on how to use the data class
	private static final String[] directions = new String[] {
		"~---------------------------------------------------------------~",
		"Hello there!",
		"Please insert a month, day, and year of choice for the program"
		+ "\nand it will generate the specified date with the corresponding"
		+ "\nholidays that lie on that date.",
		"",
		"In terms of formatting:",
		"A month can be inputted as:",
		"- A full month name (i.e. \"January\")",
		"- An abbreviated form of the month (i.e. \"Jan\")",
		"- A number representation of the month (i.e. \"1\")",
		"",
		"A day must be entered as a number (i.e. \"5\")",
		"",
		"A year must be entered as a four digit number (i.e. 2010)",
		"~---------------------------------------------------------------~"
	};
	
	//The months and their respective number of days
	private static final String[] months = new String[] {
		"January", "February", "March", "April", "May", "June",
		"July", "August", "September", "October", "November", "December"
	};
	//The days in each month
	private static final int[] daysInMonth = new int[] {
		31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	};
	
	/* Construct the date object with or without an intitial date */
	public Date() {
		//Print the directions on first use
		this.printDirections();
	}
	/* Construct the date object with the provided date */
	public Date(int month, int day, int year) {
		//Update the date
		this.month 	= month;
		this.day	= day;
		this.year 	= year;
		//Print the directions on first use
		this.printDirections();
	}
	
	/* Set the current date of the object */
	public void setDate(int month, int day, int year) {
		//Update the month day and year of the object to the specified values
		this.month 	= month;
		this.day 	= day;
		this.year 	= year;
	}
	
	/* Displays the directions of how to use the date object */
	public void printDirections() {
		//For each line in the directions
		for(String line : Date.directions) {
			//Print out the line
			System.out.println(line);
		}
	}
	
	/* Get the date in the specified format */
	//No Parameters: use the current date and default format
	public String getDate() {
		return this.getDate(this.month, this.day, this.year, Date.MONTH);
	}
	//One Parameter: Use the existing date and specified format
	public String getDate(int format) {
		return this.getDate(this.month, this.day, this.year, format);
	}
	//Four Parameters: Use the specified date and format
	public String getDate(int month, int day, int year, int format) {
		//The formatted date to return
		String date = "";
		//Are all formats requested
		Boolean allFormats = (format == Date.ALL);
		//Format the string as specified
		switch(format) {	
			//Month
			case Date.ALL:
			case Date.MONTH: {
				//Convert the month to a string representation
				date += getMonthString(month) + " " + day + ", " + year;
				//Fall through (don't break) if all formats requested
				if(!allFormats) break;
			}
			
			//If all formats are requested
			//append a separator before the next case
			if(allFormats) date += "  |  ";
			
			//Slash
			case Date.SLASH: {
				date += month + "/" + day + "/" + year;
				//Follow through if all formats request
				if(!allFormats) break;
			}
		}
		//Return the formatted date string
		return date;
	}
	
	/* Check if the specified month is valid */
	public Boolean isMonthValid(int month) {
		//The month is valid if it is between 1 and 12
		if(month >= 1 && month <= 12) return true;
		//Otherwise, the month is invalid
		return false;
	}
	
	/* Check if the specified day is valid */
	public Boolean isDayValid(int month, int day) {
		//The month is valid if it is between 1 and 12
		if(month >= 1 && month <= 12) {
			//Get the number of days in the selected month 
			int monthDays = daysInMonth[month-1];
			//Is the specified day within the range
			//of the days in the specified month
			if(day >= 1 && day <= monthDays) return true;
		}
		//Otherwise, the day is invalid
		return false;
	}
	
	/* Convert an input month number into a string representation */
	private String getMonthString(int monthNumber) {
		//The month name
		String name = "";
		//Get the inputted month name
		name = months[monthNumber-1];
		//Return the name of the month
		return name;
	}
	
	/* Convert an input month name into an int representation */
	public int getMonthNumber(String monthName) {
		//The input month as an int
		int monthNumber = 0;
		//The abbreviated month name
		monthName = monthName.toLowerCase().substring(0, 3);
		//Get the month based on it's representing abbreviation
		switch(monthName) {
			case "jan": monthNumber = 1;  break;
			case "feb": monthNumber = 2;  break;
			case "mar": monthNumber = 3;  break;
			case "apr": monthNumber = 4;  break;
			case "may": monthNumber = 5;  break;
			case "jun": monthNumber = 6;  break;
			case "jul": monthNumber = 7;  break;
			case "aug": monthNumber = 8;  break;
			case "sep": monthNumber = 9;  break;
			case "oct": monthNumber = 10; break;
			case "nov": monthNumber = 11; break;
			case "dec": monthNumber = 12; break;
		}
		//Return the month number
		return monthNumber;
	}
}