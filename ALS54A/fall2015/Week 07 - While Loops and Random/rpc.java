import java.util.Random;
import java.util.Scanner;

public class rpc {
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		
		// Ask for the input from the user
		System.out.print("Pick r p or s: ");
		String u = inputUser(user);
		System.out.println("User Picks: " + u);
		
		// Ask the input from the computer
		String c = inputComputer();
		System.out.println("Computer picks: " + c);
		
		// Process input. If true, user wins. if false computer wins
		System.out.println(choice(u, c));
	}
	
	
	public static String inputUser(Scanner user) {
		// Get input from user
		String x = user.nextLine();
		
		// We need to remove the extra enter key from the input.
		// We can do this by getting the substring of x only containing
		// the first letter of the string, 0.
		// Here's a visual of the issue:
		// Say the user enters p:
		// x = "p\n"; <--- The \n is the enter key
		// Character:   "p\n"
		// Index Value:  0 1
		// x = x.substring(0) will give us the character at 0, which is just "p"
		// so, x is now equal to "p" without the enter key (\n)
		x = x.substring(0);
		return x;
	}
	
	public static String inputComputer() {
		// Get computer input
		Random rand = new Random();
		// Generate a random number from 0 - 2. Excluding 3.
		// rand.nextInt(2) will give us a number from 0 - 1.
		int number = rand.nextInt(3);
		
		// If else chain
		/*
		if(number == 0) {
			return "r";
		} else if(number == 1) {
			return "p";
		} else if(number == 2) {
			return "s";
		} else {
			// Fall back. Just in case the program messes up,
			// indicate that an error occurred
			return "None";
		}
		*/
		
		//case switch
		switch(number) {
			case 0:
				return "r";
				//break;
			case 1:
				return "p";
				//break;
			case 2:
				return "s";
				//break;
			// For any other case, if number is not 0, 1 or 2:
			default:
				return "Error";
		}
	}
	
	public static String choice(String u, String c) {
		// See who wins
		
		if(u.equals(c)) {
			// Tie
			return "Tie";
		} else if(u.equals("r") && c.equals("s")) {
			// User: Rock beats Scissors
			return "User Wins";
		} else if(u.equals("s") && c.equals("p")) {
			// User: Scissors beats Paper
			return "User Wins";
		} else if(u.equals("p") && c.equals("r")) {
			// User: Paper beats rock
			return "User Wins";
		} else if(c.equals("r") && u.equals("s")) {
			// Computer: Rock beats Paper
			return "Computer Wins";
		} else if(c.equals("s") && u.equals("p")) {
			// Computer: Scissors beats Paper
			return "Computer Wins";
		} else if(c.equals("p") && u.equals("r")) {
			// Computer: Paper beats Rock
			return "Computer Wins";
		}
		// Fall back. If an error occurs, indicate so
		return "Error! Please pick r, p or c!";
	}
}