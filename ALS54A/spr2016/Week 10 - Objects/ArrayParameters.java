import java.util.Arrays;

class ArrayParameters
{
	public static void main(String[] args) 
	{	
		int[] num = {1, 2, 3, 4, 5};
		
		// Reverse the numbers
		num = reverse(num); // {5, 4, 3, 2, 1}
		System.out.println(Arrays.toString(num));
		
		// Make all of the numbers zero
		zeros(num); // {0, 0, 0, 0, 0}
		System.out.println(Arrays.toString(num));
	}
	
	public static int[] reverse(int[] n)
	{
		// Generally, whenever we decide to create a new array,
		// we need to use a return to pass it back to the original. 
		int[] reversedArray = new int[n.length];
		int end = reversedArray.length-1;
		for(int i = 0; i < n.length; i++)
		{
			reversedArray[i] = n[end-i];
		}
		return reversedArray;
	}
	
	public static void zeros(int[] n)
	{
		// Since we are not creating a new array in this case,
		// we do not need to return an array. Our method should
		// be void in this case.
		for(int i = 0; i < n.length; i++)
		{
			// Replace each element in the array with 0.
			// Since we are not creating a new array, we
			// do not need to return anything.
			n[i] = 0;
		}
	}
}