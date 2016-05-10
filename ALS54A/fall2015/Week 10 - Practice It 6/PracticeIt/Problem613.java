// Import these whenever we are working with Files
import java.io.*;
import java.util.Scanner;

public class Problem613 {
	public static void main(String[] args) {
		// Whenever we are dealing with files, we need to use this try catch block.
		// Just memorize it for now -- You'll learn more about it in CSc 20.
		try {
			
			// Load the file
			File f = new File("code.java");
			
			// Create a scanner for the loaded file.
			// This scanner will help us to traverse each line of the file
			Scanner file = new Scanner(f);
			
			// Strip the comments from the file
			stripComments(file);
			
		} catch(FileNotFoundException e) {
			// We can't find the file. Print out an error.
			System.err.println(e);
		}
	}
	
	public static void stripComments(Scanner file) {
		// Keep running until there are no more lines in the file
		while(file.hasNext()) {
			// Get the next line from the file.
			// This is something that we've used in the past.
			// file is a scanner, so we can use methods like
			// nextLine(), nextInt() and next() to read the data from it,
			// just like we do for the keyboard.
			
			// Hint: Use substring to check for "/*" and "*/" remove everything in between
			// Do this for "//" as well 
			
			// Print out the next line in the file
			System.out.println( file.nextLine() );
		}
	}
}