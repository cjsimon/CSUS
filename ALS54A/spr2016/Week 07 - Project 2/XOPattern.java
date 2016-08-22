public class XOPattern {
	public static void main(String[] args) {
		xo(5);
	}
	
	public static void xo(int size)
	{
		// The two character positions
		// where X's should be placed
		int x1 = 1;
		int x2 = size;
		
		// Print out each line
		for(int line = 1; line <= size; line++)
		{
			// Print out each character
			for(int c = 1; c <= size; c++)
			{
				// If the character matches the character
				// where x1 or x2 should be, then print out an X
				// Otherwise, print out an O
				if(c == x1 || c == x2)
				{
					System.out.print("X");
				} else {
					System.out.print("O");
				}
			}
			
			// Incrament x1 and Decrament x2
			// This will change where the X's
			// are printed on the next line
			x1++;
			x2--;
			System.out.println();
		}
	}
}