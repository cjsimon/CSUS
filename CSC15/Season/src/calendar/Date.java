package calendar;

public class Date {
	//The date specified
	public String date;
	
	//Set the date 
	//With no parameters use the current date
	public Date() {
		//Set the current date
		date = "Today" /*Get Today*/;
	}
	//Use the month day and year specified
	public Date(int m, int d, int y) {
		//Set the date to the date specified
		date = m + "/" + d + "/" + y;
	}
	
	//Display the date as a string
	public String print() {
		return date;
	}
}
