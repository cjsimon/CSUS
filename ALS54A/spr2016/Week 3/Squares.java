public class Squares {
	public static void main(String[] args) {
		// Basic for loop
		// Statement 1: Variable initialization used in the scope of the loop.
		// Statement 2: Run the statements inside of the statement 'SO LONG AS' the condition is true.
		// Statement 3: Modify the variable declared in the first statement.
		for(int i = 1; i <= 10; i = i + 1) {
			System.out.print(i*i);
			System.out.print(" ");
		}
		
		System.out.println();
		
		// Using Math.pow()
		// See: http://www.tutorialspoint.com/java/lang/math_pow.htm
		for(int i = 1; i <= 10; i++) {
			// (int) Changes the number from a decimal value to an int.
			// We will go over type casting next week
			System.out.print((int)Math.pow(i, 2));
			System.out.print(" ");
		}
		
		System.out.println();
		
		// Advanced for loop with two variables.
		// Each square is calculated by adding the last square
		// by the next odd number, starting with 3.
		for(int i = 1, o = 1; i <= 100; o += 2, i += o) {
			System.out.print(i);
			System.out.print(" ");
		}
	}
}
