public class OddDashes {
	
	public static final int SIZE = 5;
	
	public static void main(String[] args) {
		// From lines SIZE through 1, subtracting by two
		for(int line = SIZE; line >= 1; line -= 2)
		{
			// Print out each dash, from 1 to line
			for(int dash = 1; dash <= line; dash++)
			{
				System.out.print("-");
			}
			
			System.out.println();
		}
	}
}
