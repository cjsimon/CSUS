class NumberPattern {
	
	// public static final variables are constant.
	// They cannot be changed after they are set.
	public static final int SIZE = 4;
	
	// As an example, PI will always be a constant number. We do not want it to change.
	public static final double PI = 3.14159265358979323;
	
	public static void main(String[] args)
	{
		// Repeat the code inside the block {   } from 1 to 5
		for(int repeat = 1; repeat <= 5; repeat = repeat + 1)
		{
			
			//// This for loop will print out each number, from 0 to SIZE.
			// For each number, from 0 to SIZE
			for(int i = 0; i <= SIZE; i++)
			{
				
				// Print out each number
				System.out.print(i);
				
			}
			
		}
	}
}