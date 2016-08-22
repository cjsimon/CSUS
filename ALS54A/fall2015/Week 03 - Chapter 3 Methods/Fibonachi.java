public class Fibonachi {
	public static void main(String[] args) { 
	System.out.print("1 1");
		int n2 = 1;
		int n1 = 1;
		for(int counter = 3; counter <= 12; counter++) {
			int fibonachi = n2 + n1;
			n2 = n1;
			n1 = fibonachi;
			System.out.print(" " + fibonachi);
		}
	}
}