// 1, 8, 27, 64, 125, 216, 343, 512, 729, 1000
public class Main {
	public static void main(String[] args) {
		// First Attempt
		for(int i = 1; i <= 10; i++) {
			int cube = Math.pow(i, 3);
			System.out.print(cube + ", ");
		}

		// Second Attempt
		System.out.print(Math.pow(1, 3));
		for(int i = 2; i <= 10; i++) {
			System.out.print(", ");
			int cube = Math.pow(i, 3);
		}
	}
}