class ArrayFun
{
	public static void main(String[] args)
	{
		// Create an array (list) of numbers
		int[] numbers = {3, 8, 1, 7, 2};
		//Index:		 0  1  2  3  4
		// Just like in strings, each number, or element, in the array has an index
		
		// Print out the number (element) at index 1
		System.out.println("Number at index 1: " + numbers[1]); // 8
		
		// Change the number (element) at index 1
		numbers[1] = 10; // {3, 10, 1, 7, 2}
		//Index:			 0   1  2  3  4
		// The number 8 changed to 10
		
		
		// Print out each of the numbers in the array.
		// The for loop goes from 0 to 4.
		// numbers.length gives back to total number of elements in the array.
		for(int i = 0; i < numbers.length; i++)
		{
			System.out.print(numbers[i]); // 3 10 1 7 2
			System.out.print(" ");
		}
	}
}