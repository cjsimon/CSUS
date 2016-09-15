package mainProgram;

//Import the Season class for the calendar package
import calendar.Season;
import calendar.Date;

public class Main {
	public static void main(String[] args) {
		//This is the main program
		//Let's say we want to get the current Season
		//Create a season handler
		Season s = new Season();
		System.out.println(s.getCurrent(12, 16));
		
		//Create a date representing my birthday
		Date myBirthday = new Date(12, 25, 1995);
		System.out.println(myBirthday.print());
	}
}
