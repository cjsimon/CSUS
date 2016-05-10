public class XOPatternAlternative {
	public static void main(String[] args) {
		xo(8);
	}
	
	public static void xo(int size)
	{
		// We can initialize our x1 and x2 variables inside of the for loop,
		// and also increment and decrament them by using commas to add more
		// than one variable in the loop
		for(int line = 1, x2 = size; line <= size; line++, x2--)
		{
			
			for(int c = 1; c <= size; c++)
			{
				// variable x1 is always the same value as line,
				// so we can substitute x1 for line
				if(c == line || c == x2)
				{
					System.out.print("X");
				} else {
					System.out.print("O");
				}
			}

			System.out.println();
		}
	}
}