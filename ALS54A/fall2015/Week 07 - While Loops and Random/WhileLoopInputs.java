import java.util.Scanner;

public class WhileLoopInputs {
	public static void main(String[] args) {
		// Get the sum of an indefinite amount of numbers
		sumOfNumbers();
	}
	
	public static void sumOfNumbers() {
		// Start the keyboard input
		Scanner keyboard = new Scanner(System.in);
		// The input from the user
		String input = "";
		// The sum 
		int sum = 0;
		
		// Keep asking for numbers so long as input is not equal to "exit"
		int i = 1;
		while(!input.equals("exit")) {
			System.out.print("Number " + i + ": ");
			// Get the input from the keyboard and store it in a variable
			input = keyboard.nextLine();
			
			// If the input is not exit, calculate the number
			if(!input.equals("exit")) {
				int number = Integer.parseInt(input);
				sum = sum + number;
			}
			i++;
		}
		// Now that the while loop is all done, print the sum
		System.out.println("Sum: " + sum);
	}
	
	public static void sumOfNumbers2() {
		// Start the keyboard input
		Scanner keyboard = new Scanner(System.in);
		// The input from the user
		String input = "";
		// The sum 
		int sum = 0;
		
		// Keep asking for numbers forever.
		int i = 1;
		while(true) {
			System.out.print("Number " + i + ": ");
			// Get the input from the keyboard and store it in a variable
			input = keyboard.nextLine();
			
			// So long as input is not equal to "exit", calculate the number
			if(!input.equals("exit")) {
				int number = Integer.parseInt(input);
				sum = sum + number;
			} else {
				// Otherwise, jump/break out of while loop.
				// break end the while loop end immediately.
				break;
			}
			i++;
		}
		// Now that the while loop is all done, print the sum
		System.out.println("Sum: " + sum);
	}
}