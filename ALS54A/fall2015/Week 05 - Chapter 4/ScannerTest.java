// Don't forget to tell the computer that we want to use the Scanner library
// go ahead and commit this line to memory -- You're going to need it for the
// rest of the semester!
import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		// Create a Scanner named keyboard to grab input from the keyboard
		// You can go ahead and change the variable name, keyboard,
		// to whatever you want. Just be sure to reflect that in your code.
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("What is your favorite number? ");
		
		// Get the number from the keyboard. This will only get the number,
		// not including the "\n" (Enter Key) typed in when entering the text.
		int number = keyboard.nextInt();
		System.out.println("Your favorite number is: " + number);
		
		// Take out the extra "\n" that's left from typing in the number
		keyboard.nextLine();
		
		System.out.print("What is your favorite word? ");
		// Get the String from the keyboard. This DOES includes the "\n" with the word,
		// so there is no need to take out an extra "\n" like we did when calling keyboard.nextInt();
		String word = keyboard.nextLine();
		
		System.out.println("Your favorite word is: " + word);
	}
}