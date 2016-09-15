/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * 
 * Package Name:	main
 * File Name: 		Calendar.java
 * Description:		A class that formats and displays twelve month calendars
 *
 * Date Created: 	11/13/2014
 * Last Modified:	11/14/2014
 */

//Define this file as a part of the main package
package main;

/* The Calendar class that formats a calendar for a given date */
public class Calendar {
	//The type or format of the display
	public static final int MONTH = 0;
	public static final int YEAR  = 1;
	//The current month
	public int month;
	//The current year
	public int year;
	
	//The month titles and their respective number of days
	//Spacing is used to center the names on the calendar output
	public static final Object[][] months = new Object[][] {
			{"  January", 31},
			{" February", 28},
			{"   March"	, 31},
			{"   April"	, 30},
			{"    May"	, 31},
			{"   June"	, 30},
			{"   July"	, 31},
			{"  August"	, 31},
			{"September", 30},
			{" October"	, 31},
			{" November", 30},
			{" December", 31}
	};
	
	/* Display either a single or twelve month calendar for a given date */
	public void display() {
		display(YEAR, 0, year);
	}
	public void display(int year) {
		display(YEAR, 0, year);
	}
	public void display(int type, int m, int y) {
		//If a month type, 0, is specified, set the for loop to
		//run only for the specified month
		//Otherwise loop through all months
		int month = 0;
		int monthRange = months.length;
		if(type == 0) {
			month = m;
			monthRange = m + 1;
		}
		//For each month
		for(; month < monthRange; month++) {
			//The number of days in the current month
			int monthDays = (Integer) months[month][1];
			//Check to see if an extra day for leap year is required
			if(month == 1 && isLeapYear(y)) monthDays++;
			//Get the starting day for the current month
			int dayOffset = getFirstDay(month, y);
			//Print the current month header
			printMonth(month, y);
			//Print the days for the current month
			printDays(monthDays, dayOffset);
			//Print any holidays associated with the current month
			printHolidays(month, y);
			System.out.println();
		}
	}
	
	/* Returns the first day of the specified month and year */
	public int getFirstDay() {
		return getFirstDay(month, year);
	}
	public int getFirstDay(int month, int year) {
		//The total number of days from Jan 1, 1800
		//to the month before the specified date
		int start = getTotalDays(month, year) + 3;
		//Return the remainder of the sum of the days from (1800 to year) + 3
		//divided by 7 which represents each week
		return start % 7;
	}
	
	/* Get the total number of days since Jan 1, 1800 to the specified month */
	public int getTotalDays() {
		return getTotalDays(month, year);
	}
	public int getTotalDays(int month, int year) {
		//The totalDays is equal to all of the days in the years past
		//plus the past days in the months of the current year
		return getYearDays(year) + getMonthDays(month, year);
	}
	
	/* Get the total days from the years past the specified year */
	public int getYearDays() {
		return getYearDays(year);
	}
	public int getYearDays(int year) {
		//Disclude the middle of the current year
		year--;
		//Get the difference in years and convert to days
		int days = (year - 1800) * 365;
		//Cycle through the range of years and check for leap years
		for(int y = 1800; y <= year; y++) {
			if(isLeapYear(y)) {
				//Add an extra day for every leap year
				days++;
			}
		}
		return days;
	}
	
	/* Get the total days in the months past of the specified year */
	public int getMonthDays() {
		return getMonthDays(month, year);
	}
	public int getMonthDays(int month, int year) {
		//The total number of days up until the specified month
		int days = 0;
		//For each month
		for(int m = 0; m < month; m++) {
			//Add the total days for the month, m
			days += (Integer) months[m][1];
		}
		//Check to see if an extra day for leap year is required
		if(month == 1 && isLeapYear(year)) days++;
		//Return the total number of days
		return days;
	}
	
	/* Check if the current or specified month is a leap year */
	public boolean isLeapYear() {
		return isLeapYear(year);
	}
	public boolean isLeapYear(int year) {
		//A leap year is divisible by 400 or divisible by 4 but not 100
		boolean leapYear = (year % 400 == 0)
				|| ((year % 4 == 0) && (year % 100 != 0));
		return leapYear;
	}
	
	/* Print the current month header */
	private void printMonth() {
		printMonth(month, year);
	}
	private void printMonth(int month, int year) {
		//The current month name
		String monthName = (String) months[month][0];
		//Print the header
		System.out.println("      "
            + monthName + " " + year
            + "\n----------------------------"
            + "\nSun Mon Tue Wed Thu Fri Sat"
		);
	}
	
	/* Format and print days given a max value and a offset position */
	private void printDays() {
		printDays(month, year);
	}
	private void printDays(int days, int offset) {
		//The last position on the calendar
		int totalOffset = 28;
		//The temporary offset counter
		int tempOffset = 0;
		//Calculate the initial position based on the offset
		//Avoid printing an extra line if the offset is 6
		if(offset != 6) {
			for(int o = 0; o <= offset; o++) {
				//Each print line represents an increment in the day placement
				String placeInc = "    ";
				System.out.print(placeInc);
				//Account for the position change on a tempOffset so that the
				//offset update does not interfere with the for loop
				//that relies on the original offset value
				tempOffset += placeInc.length();
			}
		}
		//Recalculate the offset with the new initial position
		offset = tempOffset;
		
		//For each day
		for(int d = 1; d <= days; d++) {
			//If the last position has been reached
			if(offset >= totalOffset) {
				//Continue on the next line
				System.out.println();
				//Restart the position offset
				offset = 0;
			}
			
			//The formatted day to output as d
			String dayString = "" + d;
			//If d is more than one digit, add one less space
			//as to account for the alignment of characters
			dayString += (d > 9) ? "  " : "   ";
			//Print the day
			System.out.print(dayString);
			//Update the currentOffset position
			offset += dayString.length();
		}
		//Close the day section with a newline
		System.out.println();
	}
	
	/* Convert an input monthName to an interger representation */
	public int toIntMonth(String monthName) {
		//For each month
		for(int m = 0; m < months.length; m++) {
			//The sanitized name of the current month
			//Trim the string so that string comparison is accurate
			String mName = ( (String) months[m][0] ).trim();
			//Check if the input is equal to any of the months in months[][0]
			if(monthName.equalsIgnoreCase(mName)) {
				//Return the matching month index, m
				return m;
			}
		}
		//No month matched the input monthName
		return -1;
	}
	
	/* Get and print all associated holidays with the current month */
	private void printHolidays() {
		printHolidays(month, year);
	}
	private void printHolidays(int month, int year) {
		//This setup allows for additional holidays if needed
		switch(month) {
			//Nov
			case 10:
				getThanksgiving(year);
				break;
		}
	}
	
	/* Get the date on which Thanksgiving falls on for a specified year */
	private void getThanksgiving(int year) {
		//Get the first Thursday of November
		//The first Thursday initially stating at the first day of the month
		int day = 1;
		int dayOfWeek = getFirstDay(10, year);
		//Add days according to the firstDay of the year specified
		//in order to get to Thursday
		switch(dayOfWeek) {
			//Sun
			case 6: day += 4; break;
			//Mon
			case 0: day += 3; break;
			//Tues
			case 1: day += 2; break;
			//Wed
			case 2: day += 1; break;
			//Fri
			case 4: day += 6; break;
			//Sat
			case 5: day += 5; break;
		}
		//Add three weeks to get the last thursday of the month
		day += 21;
		System.out.println("**Thanksgiving is on the " + day);
	}
}
