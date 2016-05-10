public class BoxFigure
{
	public static final int SIZE = 5;
	
	public static void main(String[] args)
	{
		drawPlus();
		for(int line = 1; line <= SIZE; line++)
		{
			drawBars();
		}
		drawPlus();
	}
	
	public static void drawPlus()
	{
		System.out.print("+");
		for(int i = 1; i <= SIZE; i++)
		{
			System.out.print("/\\");
		}
		System.out.println("+");
	}
	
	public static void drawBars()
	{
		System.out.print("|");
		for(int i = 1; i <= SIZE*2; i++)
		{
			System.out.print(" ");
		}
		System.out.println("|");
	}
}