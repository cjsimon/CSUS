//import java.util.*;
import java.util.Scanner;

public class Birthday
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		// Pass in the scanner that we have already created, kb,
		// into the inputBirthday method, so that we do not have
		// to create a new one
		inputBirthday(kb);
	}
	
	public static void inputBirthday(Scanner kb)
	{
		// Ask the user for a name
		System.out.println("What is your name?");
		// Get a string from the keyboard and store it into the variable, name
		String name = kb.nextLine();
		// Print out the name we got from the keyboard
		System.out.println("Hello, " + name);
	}
}