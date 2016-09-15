/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * 
 * Package Name:	calendar
 * File Name: 		SwitchHoliday.java
 * Description:		An extention to the holiday class that returns the holidays
 * 					assosiated with a given date. This was written for the sake
 * 					of the assignment requirements. Overrides getHoliday method
 *
 * Date Created: 	10/21/2014
 * Last Modified:	10/21/2014
 */
package calendar;

/* 
 * The holiday class extention that overrides the getHoliday() method
 * to function as is required in the assignment, using nested switch statements
 */
public class SwitchHoliday extends Holiday{
	/* 
	 * The expected way of getting holidays for the date using case switch.
	 * This has been included for the sake of the assignment requirements
	 */
	@Override
	public String getHoliday() {
		return this.getHoliday(this.month, this.day, this.year);
	}
	@Override
	public String getHoliday(int month, int day, int year) {
		//The holidays string
		//Personally, I would indicate "None"
		//if no holidays exists for a date,
		//but the homework assignment calls for ""
		String holidays = "";
		//Determine the month and date and return the associated holidays
		switch(month) {
			//Months
			//Jan
			case 1: { 
				//Days
				switch(day) {
					case 1:  { holidays = "New Year's Day"; break; }
					case 19: { holidays = "Martin Luther King Jr. Day"; break; }
				}
				break;
			}
			//Feb
			case 2: { 
				//Days
				switch(day) {
					case 2:  { holidays = "Ground Hog Day"; break; }
					case 12: { holidays = "Abraham Lincoln's Birthday"; break; }
					case 14: { holidays = "St. Valentine's Day"; break; }
					case 22: { holidays = "George Washington's Birthday"; break; }
				}
				break;
			}
			//Mar
			case 3: { 
				//Days
				switch(day) {
					case 17: { holidays = "St. Patrick's Day"; break; }
				}
				break; 
			}
			//Apr
			case 4: { 
				//Days
				switch(day) {
					case 1:  { holidays = "April Fool's Day"; break; }
					case 20: { holidays = "Grandma's Birthday"; break; }
					case 22: { holidays = "Earth Day"; break; }
					case 24: { holidays = "Arbor Day"; break; }
				}
				break; 
			}
			//May
			case 5: { 
				//Days
				switch(day) {
					case 1: { holidays = "May Day"; break; }
					case 5: { holidays = "Cinco de Mayo"; break; }
				}
				break; 
			}
			//Jul
			case 7: { 
				//Days
				switch(day) {
					case 4: { holidays = "Independence Day"; break; }
				}
				break; 
			}
			//Aug
			case 8: { 
				//Days
				switch(day) {
					case 3: { holidays = "International Friendship Day"; break; }
				}
				break; 
			}
			//Oct
			case 10: { 
				//Days
				switch(day) {
					case 13: { holidays = "Columbus Day"; break; }
					case 31: { holidays = "Halloween"; break; }
				}
				break; 
			}
			//Nov
			case 11: { 
				//Days
				switch(day) {
					case 11: { holidays = "Vereran's Day"; break; }
				}
				break; 
			}
			//Dec
			case 12: { 
				//Days
				switch(day) {
					case 25: { holidays = "Christmas and My Birthday"; break; }
					case 31: { holidays = "New Year's Eve"; break; }
				}
				break; 
			}
		}
		//Check if Easter lies on the specified date
		if(this.isEaster(month, day, year)) {
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
		//Return all of the holidays associated with the specified date
		return holidays;
	}
}
