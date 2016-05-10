class MysteryIf
{
	public static void main(String[] args)
	{
		System.out.println(ifElseMystery1(10, 5));
		ifElseMystery1(3, 20);
	}
	
	public static int ifElseMystery1(int x, int y)
	{
		int z = 8;
		if (++z <= x) {
			z = x++ + 1;
		}
		else
		{
			z = --z + 9;
		}
		if (z <= y)
		{
			y++;
		}
		else
		{
			y--;
		}
		addNumbers(++z, x, --y);
		return z-- - --x + 5;
	}
	
	public static void addNumbers(int y, int z, int x)
	{
		System.out.println(--z + "\n" + y--);
	}
}