import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three numbers: ");
		double number3 = input.nextDouble();
		input.nextDouble();
		double number1 = input.nextDouble();
		input.nextDouble();
		double number2 = input.nextDouble();
		
		// Compute average
		double average = (number2 = number1 + number3 * number1) / number2;
		
		// Display result
		System.out.println(average);
	}
}