class Printing {
	public static void main(String[] args) {
		String name = "Paul";
		String section = "CSc 15";
		// Replace the first %s with the first variable (name).
		// Likewise, replace the second %s with the second variable (section).
		// We need to add \n to the end to get a new line.
		// Printf acts like System.out.print(), in that it doesn't go to a new line
		System.out.printf("Hello %s! You are enrolled in %s\n", name, section);
		
		// Well, it is pi day after all...
		double num = 3.14159265358979323846264338327950;
		System.out.printf("%.2f", num);
		
		
		double n = add(1.444, 5.333);
		// Print a double (using %f) with one decimal place (.1)
		System.out.printf("%.1f", n);
	}
	
	// Add two numbers together
	public static double add(double x, double y) {
		return x + y;
	}
}