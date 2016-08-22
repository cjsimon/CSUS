import java.util.Scanner;

class Practice
{
	public static void main(String[] args)
	{
		
		Scanner in = new Scanner(System.in);
		
		int x = in.nextInt();
		int y = 4;
		int z = 5;
		System.out.println(add(x, y, z));
	}
	
	public static int add(int x, int y, int z)
	{
		int sum = x + y + z;
		return sum;
	}
}