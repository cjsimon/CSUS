/**
 * Step 1: Determine the different patterns associated with the problem.
 * This will indicate the number of for loops that we need to have in our solution.
 * Ask yourself: "How many different characters are included in the solution?"
 * 
 * When creating patterns, it's a good idea to separate the problem line by line.
 * So, we should include an outter for loop that represents the line number.
 * for(int line = 1; line <= 4; line++)
 * {
 *     // line will start at 1 and will loop up to 4.
 * }
 * 
 * We will then need a for loop for each character, "\", "!" and "/",
 * to control the number of times each character is printed per line.
 * These for loops will go inside of the line number for loop, like so:
 * 
 * // Line
 * for()
 * {
 * 	   // Print each "\"
 *     for()
 *     {
 *         
 *     }
 *     
 *     // Print each "!"
 * 	   for()
 * 	   {
 * 	       
 * 	   }
 *     
 *     // Print each "/"
 * 	   for()
 * 	   {
 * 	       
 * 	   }
 * }
 * 
 * Step 2: Construct a table for at least one of the sizes.
 * Let's use size 4. Size 7 is included for reference.
 * 
 * SIZE = 4:							Size = 7:
 * +-------------------------------+	+------------------------------+
 * |	line	\		!		/  |	|	line	\		!		/  |
 * |-------------------------------|	|------------------------------|
 * |	1		0		14		0  |	|	1		0		14		0  |
 * |	2		2		10		2  |	|	2		2		10		2  |
 * |	3		4		6		4  |	|	3		4		6		4  |
 * |	4		6		2		6  |	|	4		6		2		6  |
 * +-------------------------------+	|	5		8		2		8  |
 * 										|	6		10		2		10 |
 *           							|	7		12		2		12 |
 * 										+------------------------------+
 * 
 * Step 3: Determine the mathematical expressions
 * Each character in the table is going to need it's own expression.
 * This will tell the computer how many times it needs to print that
 * character for the line number it's currently at.
 * 
 * For this reason, we need an expression dependent upon the line number.
 * 
 * Let's start with the "/".
 * We need to find an equation that satisfies the following requirements:
 * +-----------------------+
 * |  line  Expression  /  |
 * |-----------------------|
 * |  1		line*____ =	0  |
 * |  2		line*____ =	2  |
 * |  3		line*____ =	4  |
 * |  4		line*____ =	6  |
 * +-----------------------+
 * 
 * Expression:  line * ______ = /
 * Ask yourself: "What can I do to this expression to get the correct number of slashes?"
 * 
 * Solution:   (line * 2) - 2 = /
 * 
 * Check if the expression satisfies the conditions:
 * +----------------------------+
 * |  line  Expression  	 /  |
 * |----------------------------+
 * |  1		(line * 2) - 2 = 0  | -> (2) - 2 = 0
 * |  2		(line * 2) - 2 = 2  | -> (4) - 2 = 2
 * |  3		(line * 2) - 2 = 4  | -> (6) - 2 = 4
 * |  4		(line * 2) - 2 = 6  | -> (8) - 2 = 6
 * +----------------------------+
 * 
 * Therefore, the expression, (line * 2) - 2, gives us the
 * number of "/" that we need to print out for each line.
 * 
 * Set up the for loop accordingly:
 * 
 * // Print each "/"
 * for(int f = 1; f <= (line * 2) - 2; f++)
 * {
 *     System.out.print("/");
 * }
 * 
 * This process, Step 3, needs to be repeated for every character in the pattern.
 * 
 * Now it's your turn... 
 * What mathematical expression will give us the correct
 * number of "!" that we need to print out for each line?
 */
class SlashFigureSolution
{
	public static final int SIZE = 4;
	
	public static void main(String[] args)
	{	
		// Line Number
		for(int line = 1; line <= SIZE; line++)
		{ 
			// Print out each "\"
			for(int b = 1; b <= (2*line) - 2; b++)
			{
				System.out.print("\\");
			}
			
			// Print out each "!"
			for(int i = 4*SIZE; i >= (4*line - 1); i--) {
				System.out.print("!");
			}
			
			// Print out each "/"
			for(int f = 1; f <= (2*line) - 2; f++)
			{
				System.out.print("/");
			}
			
			// Go to the next line in the output
			System.out.println();
		}
	}
}