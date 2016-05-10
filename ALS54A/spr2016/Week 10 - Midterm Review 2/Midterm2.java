public class Midterm2
{	
	public static void main(String[] args)
	{
		int x = 4;
		int z = 3;
		int y = 6;
		x = mystery(x,z,y);
		z = mystery(z,z,x);
		y = x + y;
		System.out.println("x = " + x);
		System.out.println("Z = " + z);
		System.out.println("Y = " + y);
		System.out.println("X + Y + Z = " + (x + z + y));
	}

	public static int mystery(int y, int x, int z)
	{
		z++;
		boolean b = false;
		if( !(z > 5 && z <=10) || !true && !(x+ y >0) || !b)
		{
			x = x + y * 2;
			y = y/2;
		}
		else if ( !(x == z))
		{
			x = z;
		}
		else
		{
			x = x -y * z;
			z++;
		}
		x = x + y + z;
		return x;
	}
}