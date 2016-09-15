package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Season {
	//The date formatter
	static SimpleDateFormat dateFormat;
	//The season start and end dates
	static Date winterS;
	static Date winterE;
	static Date springS;
	static Date springE;
	static Date summerS;
	static Date summerE;
	static Date fallS;
	static Date fallE;
	
	public Season() {
		//The date format as a string
		//Seasons are not reliant upon the current year
		String dateString = "M/d";
		//Construct the date format using the SimpleDateFormatter
		dateFormat = new SimpleDateFormat(dateString);
		
		try {
			//Define the start and end dates of the seasons parsed into new Date objects
			//Winter
			winterS = dateFormat.parse("12/15");
			winterE = dateFormat.parse("3/16");
			//Spring
			springS = dateFormat.parse("3/15");
			springE = dateFormat.parse("6/16");
			//Summer
			summerS = dateFormat.parse("6/15");
			summerE = dateFormat.parse("9/16");
			//Fall
			fallS   = dateFormat.parse("9/15");
			fallE   = dateFormat.parse("12/16");
		} catch(ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String getCurrent(int m, int d) {
		//The season to return
		String season = "";
		//Construct a date from the input month and day
		Date inputDate = null;
		try {
			inputDate = dateFormat.parse(m + "/" + d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			//Which season does current date lies within
			//Check for the case that is true
			//Is the current date before the end date and after the start date of each season
			//Winter uses OR as it's range is unacheivable since the dates are at opposite ends of the same year
			if(inputDate.before(winterE) || inputDate.after(winterS)) {
				//Set the current season
				season = "Winter";
			}
			//At this point it could be winter, but not necessarily
			if(inputDate.before(springE) && inputDate.after(springS)) {
				season = "Spring";
			} else if(inputDate.before(summerE) && inputDate.after(summerS)) {
				season = "Summer";
			} else if(inputDate.before(fallE) && inputDate.after(fallS)) {
				season = "Fall";
			}
		} catch(Exception e) {
			System.out.println("Invalid Date!");
		}
		//Return the season
		return season;
	}
}