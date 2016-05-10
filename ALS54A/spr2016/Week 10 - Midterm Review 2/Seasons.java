class Seasons {
	public static void main(String[] args) {
		System.out.println(season(1, 21));  // Winter
		System.out.println(season(2, 28));  // Winter
		System.out.println(season(3, 15));  // Winter
		System.out.println(season(3, 16));  // Spring
		System.out.println(season(4, 1));   // Spring
		System.out.println(season(6, 15));  // Spring
		System.out.println(season(6, 16));  // Summer
		System.out.println(season(8, 9));   // Summer
		System.out.println(season(9, 15));  // Summer
		System.out.println(season(9, 16));  // Fall
		System.out.println(season(10, 31)); // Fall
		System.out.println(season(12, 15)); // Fall
		System.out.println(season(12, 16)); // Winter
	}
	
	public static String season(int m, int d) {
		String season = "Fall";
		if((m == 12 && d >= 16) || (m == 3 && d <= 15) || (m >= 1 && m < 3)) {
			season = "Winter";
		} else if((m == 3 && d >= 16) || (m == 6 && d <= 15) || (m > 3 && m < 6)) {
			season = "Spring";
		} else if((m == 6 && d >= 16) || (m == 9 && d <= 15) || (m > 6 && m < 9)) {
			season = "Summer";
		} //else if((m == 9 && d >= 16) || (m == 12 && d <= 15) || (m > 9 && m < 12)) {
			//season = "Fall";
		//}
		// If it's not one of the above seasons, then it's must be fall.
		return season;
		
		// This isn't a good fallback, as Fall will be returned even for an invalid date
		// If considering error checking, it would be a better idea to have a conditional
		// for Fall and to have the default string be the error string instead. In this
		// case, we are assuming that no invalid input is being entered into the method.
	}
}