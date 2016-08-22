/**
 * ////////////////\\\\\\\\\\\\\\\\
 * ////////////********\\\\\\\\\\\\
 * ////////****************\\\\\\\\
 * ////***********************\\\\\
 * ********************************
 */

// Ask yourself: What is changing? What's the pattern?
public static void main() {
	// We want to print a certain amount of
	// slashes stars and backslashes based on the line number
	// according on the following equations:
	// /: (16 - (line*4))
	// *: (line*8)
	// \: (16 - (line*4))
	
	// Create five lines
	// for each of the lines
	for(int line = 0; line <= 4; line++) {
		for(int i = 16; i >= 0; i = i - 4) {
			System.out.println("/");
		}
		for(int s = 8; s <= 32; s += 8) {
			System.out.println("*");
		}
		for(int b = 16; b >= 0; b = b - 4) {
			System.out.println("\\");
		}
		// print (16 - (line*4)) many /
		// print (line*8) many *
		// print (16 - (line*4)) many \
		// Go to the next line
	}
}