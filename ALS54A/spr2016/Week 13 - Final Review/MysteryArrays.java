import java.util.Arrays;

public class MysteryArrays
{
	public static void mystery3(int[] data, int x, int y)
	{
		System.out.println(data[++x]++);
		System.out.println(data[y]--);
	}
	
	public static void main(String[] args)
	{
		int[] numbers = {3, 7, 1, 0, 25, 4, 18, -1, 5};
		mystery3(numbers, 2, 1);
		//mystery3(numbers, 3, 6);
		//mystery3(numbers, 7, 4);
		
		System.out.println(Arrays.toString(numbers));
	}
}