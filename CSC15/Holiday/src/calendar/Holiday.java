/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * 
 * Package Name:	calendar
 * File Name: 		Holiday.java
 * Description:		An extention to the Date class that contains methods 
 * 					for returning the holidays assosiated with a given date
 *
 * Date Created: 	10/20/2014
 * Last Modified:	10/21/2014
 */

//Define this file as a part of the custom package, calendar
package calendar;

/* 
 * The holiday class that extends date
 * and checks for holidays on a given date
 */
public class Holiday extends Date {
	//The list of holidays and their respected dates of occurrence
	public static Object[][] holidays = new Object[][] {
		//The dates
		//Datatype Object[] can be used simply by
		//including the data without a datatype {"x", "y"}
		new String[] {
			"11",
			"119",
			"22",
			"212",
			"214",
			"222",
			"317",
			"41",
			"420",
			"422",
			"424",
			"51",
			"55",
			"74",
			"83",
			"1013",
			"1031",
			"1111",
			"1225",
			"1231"
		},
		//The list of holidays on each respective date
		{
			new String[] { "New Year's Day" },
			new String[] { "Martin Luther King Jr. Day" },
			new String[] { "Ground Hog Day" },
			new String[] { "Abraham Lincoln's Birthday" },
			new String[] { "St. Valentine's Day" },
			new String[] { "George Washington's Birthday" },
			new String[] { "St. Patrick's Day" },
			new String[] { "April Fool's Day" },
			new String[] { "Grandma's Birthday" },
			new String[] { "Earth Day" },
			new String[] { "Arbor Day" },
			new String[] { "May Day" },
			new String[] { "Cinco de Mayo" },
			new String[] { "Independence Day" },
			new String[] { "International Friendship Day" },
			new String[] { "Columbus Day" },
			new String[] { "Halloween" },
			new String[] { "Vereran's Day" },
			new String[] { "Christmas", "My Birthday" },
			new String[] { "New Year's Eve" }
		}
	};
	
	/* Construct the holiday object using the date constructor */
	public Holiday() {
		//Call the super constructor
		//Similar to calling Date()
		super();
	}
	public Holiday(int m, int d, int y) {
		//Call the super constructor passing a date
		//Similar to calling Date(month, day, year)
		super(m, d, y);
	}
	
	/* Add a holiday with a date of occurrence in which it is celebrated */
	public void addHoliday(String holidayName, int month, int day) {
		//Get the specified date index from the holidays array
		int dateIndex = this.getDateIndex(month, day);
		//If the date does exists in the array (any index except -1)
		if(dateIndex != -1) {
			//Add the holiday to the existing date element
			//The list of holidays for the specified date
			//from the holidays array
			String[] holidaysOnDate = (String[]) holidays[1][dateIndex];
			//The number of holidays on the specified date
			int holidaysCount = holidaysOnDate.length;
			//Resize the current date by one to add another holiday
			String[] tmpHolidays = new String[holidaysCount+1];
			//Append each holiday to the temp array
			for(int h = 0; h < holidaysCount; h++) {
				//Append each holiday onto a corresponding
				//element index in the tmp array
				tmpHolidays[h] = holidaysOnDate[h];
			}
			//Append the last holiday to the last slot
			tmpHolidays[holidaysCount] = holidayName;
			//Overwrite the original holidays array
			//with the date index representing holidaysOnDate
			holidays[1][dateIndex] = tmpHolidays;
		} else {
			//TODO: Add holiday method
			//Add the new date to the array
			//Add Holiday
		}
	}
	
	/* Return the holidays that lie on the specified date */
	//No Parameters: Use the object's current date
	public String getHoliday() {
		//Return the holidays using the current date
		return this.getHoliday(this.month, this.day, this.year);
	}
	//Parameters: Use the specified month and day
	public String getHoliday(int month, int day, int year) {
		//Get the specified date index from the holidays array
		int dateIndex = this.getDateIndex(month, day);
		//If the date does exists in the array (any index except -1)
		if(dateIndex != -1) {
			//Return the string of holidays using the returned dateIndex
			//which represents the desired date from the dates array
			return getHolidayString(dateIndex);
		}
		//The specified date does not exist (indicated as -1)
		//For now, return an empty string to compensate for lack of results
		//The holidays string to return
		String holidays = "";
		//Check for additional holidays
		//that are not recognized by a specific date
		if(isEaster(month, day, year)) {
			//If the holidays string is empty
			if(holidays.isEmpty()) {
				//Include "Easter" as a holiday without an extra " and "
				//as it is the only holiday
				holidays += "Easter";
			} else {
				//Add " and " as this is not the first holiday
				holidays += " and Easter";
			}
		}
		//Return the holidays string
		return holidays;
	}
	
	/* Searches for and returns the specified date index from the holidays array */
	private int getDateIndex(int month, int day) {
		//The month date id representing the specified day in the array
		String date = "" + month + day;
		//The dates list in the holidays list
		String[] dates = (String[]) holidays[0];
		//Look through all of the dates to see if the specified date exists
		//For each date in dates represented as d
		for(int d = 0; d < dates.length; d++) {
			//The current date in dates as a string
			String currentDate = (String) dates[d];
			//If the specified date is found as a date in the holiday list
			if(date.equals(currentDate)) {
				//Return the current date index in the holidays array
				return d;
			}
		}
		//After searching all of the date listings,
		//if no date has been found in the holidays array:
		//Indicate that the date was not found using -1 as an error status
		return -1;
	}
	
	/* Get a string of holidays for a given date index representing the desired date */
	private String getHolidayString(int d) {
		//The holiday list of the specified date
		String[] holidaysOnDate;
		//Set the currentDate index, d, as the target array of holidays
		holidaysOnDate = (String[]) holidays[1][d];
		//The string representing all holidays that lie on the specified day
		String holiday = "";
		//The number of holidays for the currentDate
		int holidayCount = holidaysOnDate.length;
		//For each holiday of the currentDate represented as h
		for(int h = 0; h < holidayCount; h++) {
			//The current holiday, represented through an index of h
			String currentHoliday = holidaysOnDate[h];
			//Append the currentHoliday to the holiday string
			holiday += currentHoliday;
			//Append an " and " if this is not the last holiday in holidays
			if(h != holidayCount-1) {
				holiday += " and ";
			}
		}
		//Return the holidays assosiated with the specified date
		return holiday;
	}
	
	/* Check if Easter lies on the spcified date */
	public boolean isEaster(int month, int day, int year) {
		//Calculate the day that easter lands on for a given year
		int goldenNumber = (this.year % 19) + 1;
		int a = (24 + 19 * (goldenNumber - 1)) % 30;
		int b = a - (a/28);
		int c = (this.year + (this.year/4) + (b - 13)) % 7;
		int d = b - c;
		//The month and day of easter for the specified year
		int easterMonth = 3 + (d + 40)/44;
		int easterDay = d + 28 - 31 * (easterMonth/4);
		//The month and day as a strings representing
		//the date for easter and the specified date
		//to allow for a simpler comparison
		String easterId = "" + easterMonth + "" + easterDay;
		String dateId = "" + month + "" + day;
		//Check whether the specified date properties
		//match the date of Easter for on the given year
		if(dateId.equals(easterId)) {
			//The specified date is Easter
			return true;
		}
		//The specified date is not Easter
		return false;
	}
	
	//Pass the validators to the super class for handling
	public Boolean isMonthValid(int month) {
		return super.isMonthValid(month);
	}
	public Boolean isDayValid(int month, int day) {
		return super.isDayValid(month, day);
	}
}