public class Variables
{
	public static void main(String[] args)
	{
		int max;
		double min = 10;
		min--;
		max = 17 - (4 / 10) * 3 - 2 % 5;
		max = max + 8 % 2 * 5 + 1;
		++max;
		min = (double)max - min;
		System.out.println((double)max * 2/4);
		System.out.println(min);
		System.out.println(--max);
		System.out.println(min++ % 4 + 1);
	}
}