public class practiceMidtermProblem3 {
	// The constant size that can be modified to produce different sized patterns
	public static final int SIZE = 4;
	
	public static void main(String[] args) {
		// Ask yourself: What is changing? What's the pattern?
		//
		// We want to print a certain amount of slashes, stars, and backslashes
		// based on the line number, according on the following equations:
		// /: ((SIZE*4) - (line*4))
		// *: (line*8)
		// \: ((SIZE*4) - (line*4))
		//
		// For the slashes, the SIZE*4 represents the initial total for that given size,
		// while the line*4 represents the number of slashes removed, based on the current
		// line number. Here is a table for reference:
		// _____________________________________________________
		// | SIZE  |  LINE  |  /  |  (SIZE*4) - (line*4)       |
		// | 4     |  1     |  12 |  (16)     - (4)       = 12 |
		// | 4     |  2     |  8  |  (16)     - (8)       = 8  |
		// | 4     |  3     |  4  |  (16)     - (12)      = 4  |
		// | 4     |  4     |  0  |  (16)     - (16)      = 0  |
		// +---------------------------------------------------+
		
		
		// Create SIZE lines
		// For each of the lines
		for(int line = 1; line <= SIZE; line++) {
			
			// Print ((SIZE*4) - (line*4)) many slashes, "/"
			for(int slash = 1; slash <= ((SIZE*4) - (line*4)); slash++) {
				System.out.print("/");
			}
			
			// Print (line*8) many stars, "*"
			for(int star = 1; star <= (line*8); star++) {
				System.out.print("*");
			}
			
			// Print ((SIZE*4) - (line*4)) many backslashes, "\"
			for(int backslash = 1; backslash <= ((SIZE*4) - (line*4)); backslash++) {
				System.out.print("\\");
			}
			
			// Go to the next line
			System.out.println();
		}
	}
}