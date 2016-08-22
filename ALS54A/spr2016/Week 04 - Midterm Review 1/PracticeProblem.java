public class PracticeProblem
{
	public static void main(String[] args)
	{
		int x = 9;
		int y = 47;
		int z = 15;
		x = z / 4;
		z = z - x;
		
		for(int i = 1; i < z-8; i++) {
			System.out.print("Line i-1: ");
			for(int j = 1; j <= x*i; j++) {
				System.out.print(j*i + " ");
			} 
			for(int k = (2*i) / 5; k > 0; k--) {
				System.out.print((double)k);
				for(int e = i; e > 0; e--) {
					System.out.print(i);
				}
			}
			System.out.println();
		}
	}
}