public class Pattern
{
	public static final int SIZE = 15;
	public static void main(String[] args)
	{
		for(int i = 1; i <= SIZE; i++)
		{
			for(int j = i; j <= SIZE; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		for(int i = SIZE; i >= 1; i--)
		{
			for(int j = i; j <= SIZE; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}