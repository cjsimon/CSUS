import java.util.Scanner;

public class PracticeIt49 {
	public static void main(String[] args) {
		sum();
	}
	
	public static void sum() {
		// Start the keyboard input
		Scanner keyboard = new Scanner(System.in);
		int sum = 0;
		String input = "";
		
		// Keep asking for numbers so long as input is not "exit"
		int i = 1;
		while(!input.equals("exit")) {
			System.out.print("Number " + i + ": ");
			// Get the input from the keyboard and store it in a variable
			input = keyboard.nextLine();
			
			//if(!input.equals("exit")) {
				int number = Integer.parseInt(input);
				sum = sum + number;
			//}
			i++;
		}
		System.out.println("Sum: " + sum);
	}
}