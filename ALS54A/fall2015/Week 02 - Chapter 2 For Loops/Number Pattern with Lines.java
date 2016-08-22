/**
 * For Loops Introduction 2 and Sudo Code Generation and Modolus
 * 
 * Output:
 *           |          |          |          |          |          |
 * 123456798901234567989012345679890123456798901234567989012345679890
 */
public class Main {
	public static void main(String[] args) {
		int cols = 6;
		// Display a | every tenth character
		// Loop from 1 to 10
		for(int i = 1; i <= 10 * cols; i++) {
			// If the current loop integer, i, is a multiple of 10
			if(i % 10 == 0) {
				// i is a multiple of 10, which means that this is a tenth iteration
				// Then print a |
				System.out.print("|");
			} else {
				// i is not a multiple of 10
				// Otherwise, print a space
				System.out.print(" ");
			}
		}
		
		// Next Line
		System.out.println();
		
		// Objective: Display the numbers 0 through 9 starting with 1 
		// Loop from 1 to 10, starting with 1
		for(int i = 1; i <= 10 * cols; i++) {
			// If the current loop integer, i, is a multiple of 10
			if(i % 10 == 0) {
				// i is a multiple of 10, which means that this is a tenth iteration
				// Then print a 0
				System.out.print(0);
			} else {
				// Otherwise, print the number
				System.out.print(i % 10);
			}
		}
	}
}