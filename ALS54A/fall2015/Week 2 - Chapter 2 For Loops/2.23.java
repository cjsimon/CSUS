public class MoneyBaller {
	/**
	 * SIZE = 3:
	 * $$$******$$$
	 * **$$****$$**
	 * ****$**$****
	 * 
	 * Split the pattern in half,
	 * as it is the same on both
	 * left and right sides:
	 *
	 * 	LEFT | RIGHT
	 * $$$***|***$$$
	 * **$$**|**$$**
	 * ****$*|*$****
	 *  LEFT | RIGHT
	 *  
	 * Create for loops for each
	 * pattern on the LEFT side,
	 * then use the same code to
	 * produce the RIGHT side.
	 * 
	 * The code below is setup to
	 * produce only the LEFT side.
	 * 
	 */
	
	// The size representing the number of lines in the pattern
	// We need this variable to be accessable to all methods,
	// so it is initialized outside of the main method
	private static final int SIZE = 3;
	
	public static void main(String[] args) {
		// Create lines until the number of lines matches the SIZE
		for(int line = 1; line <= SIZE; line++) {
			/**
			 * -- 1st Star Pattern --
			 * Equation: (2 * (line - 1))
			 * 
			 * Line 1  : (2 * ((1) - 1) = 0
			 * Line 2  : (2 * ((2) - 1) = 2
			 * Line 3  : (2 * ((3) - 1) = 4
			 * Line 4  : (2 * ((4) - 1) = 6
			 */
			for() {
				System.out.print("*");
			}
			
			/**
			 * -- 2nd Dollar Pattern --
			 * Equation: (SIZE - (line-1)
			 * 
			 * Assuming SIZE = 3:
			 * Line 1  : (3 - ((1) - 1)) = 3
			 * Line 2  : (3 - ((2) - 1)) = 2
			 * Line 3  : (3 - ((3) - 1)) = 1
			 */
			for() {
				System.out.print("$");
			}
			
			/**
			 * -- 3rd Star Pattern --
			 * Equation: (SIZE - (line-1)
			 * 
			 * Assuming SIZE = 3:
			 * Line 1  : (3 - ((1) - 1)) = 3
			 * Line 2  : (3 - ((2) - 1)) = 2
			 * Line 3  : (3 - ((3) - 1)) = 1
			 */
			for() {
				System.out.print("*");
			}
			
			//
			// Insert code here to produce the RIGHT side.
			// Hint: You have already created most of the code
			// after filling in the for loops for the LEFT side.
			//
			
			// Drop down to the next line using println
			System.out.println();
		}
	}
}