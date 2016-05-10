import java.util.Scanner;

public class YesTo {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		// Print the answer to the question, "Do you like cats"
		System.out.println( yesTo("Do you like cats? ", kb) );	
	}
	
	public static boolean yesTo(String prompt, Scanner console) {
		// Ask the question
		System.out.print(prompt);
		// Get the answer to the question from the user
		String answer = console.nextLine();
		if(answer.equals("y")) { // If the answer is "y"
			return true; // The user answered yes!
		} else if(answer.equals("n")) { // Otherwise, if the answer is "n"
			return false; // The user answered no!
		} else { // Otherwise, for any other input from the keyboard
			// Error! Tell the user that they need to type either 'y' or 'n'
			System.out.println("Please input 'y' or 'n'!");
			// Re-ask the question over again, simply by rerunning
			// the same method over again with the same prompt and Scanner.
			// This will allow us to keep asking and checking for a 'y' or an 'n'
			yesTo(prompt, console);
		}
		// We shouldn't ever reach this point,
		// but we need to have this return
		// as a fall back for the computer.
		// Without this, you will get an error!
		return false;
	}
} 