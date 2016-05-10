public class practiceMidtermProblem1 {
	private static int SIZE = 5;
	public static void main(String[] args) {
		for(int line = 1; line <= SIZE; line++) {
			for(int i = 1; i <= SIZE - line; i++) {
				System.out.print(i);
			}
			System.out.print("-");
			for(int j = SIZE - line; j >= 1; j--) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
}