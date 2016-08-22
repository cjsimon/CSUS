public class Lines {
	public static void main(String[] args) {
		// Starting from 5 to 1
		for(int line = 5; line >= 1; line--) {
			// Print each dash from 1 to line
			for(int dash = 1; dash <= line; dash++) {
				System.out.print("-");
			}
			// Goto the next line on the output
			System.out.println();
		}
		
		// For each line, starting from 1 to 5
		for(int line = 1; line <= 5; line++) {
			// Print each "-" from 1 to line
			for(int dash = 1; dash <= (6-line); dash++) {
				System.out.print("-");
			}
			// Goto the next line on the output
			System.out.println();
		}
	}
}