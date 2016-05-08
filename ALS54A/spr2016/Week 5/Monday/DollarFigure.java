public class DollarFigure
{
	// Represent the height as int SIZE
	public static final int SIZE = 3;
	
	public static void main(String[] args)
	{
		// For each line
		for(int line = 1; line <= SIZE; line++)
		{
			printStars(line);
			
			printDollars(line);
			
			printCenterStars(line);
			
			printDollars(line);
			
			printStars(line);
			
			// Move the output to next line
			System.out.println("");
		}
	}
	public static void printCenterStars(int line) {
		for() {
			System.out.print("*");
		}
	}
	
	public static void printStars(int line) {
		// Print out each *
		for() {
			System.out.print("*");
		}
	}
	
	public static void printDollars(int line) {
		// Print each right $
		for() {
			System.out.print("$");
		}
	}
	
}