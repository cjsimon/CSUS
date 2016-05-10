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
		String season;
		// (Month 12 AND a day later or equal to than the 16th)
		// OR
		// (Month 3 AND a day earlier or equal to the 15th)
		// OR
		// (Any month in between 12 and 3 not including 12 and 3)
		if((m == 12 && d >= 16) || (m == 3 && d <= 15) || (m >= 1 && m < 3)) {
			season = "Winter";
		} else if() {
			season = "Spring";
		} else if() {
			season = "Summer";
		} else if() {
			season = "Fall";
		} else {
			// If it's not one of the above seasons, then we have encountered an error
			season = "Error";
		}
		return season;
	}
}