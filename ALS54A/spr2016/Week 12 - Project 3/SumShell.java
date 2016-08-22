// This program reads an input file that contains sequences of integers to
// be added together.  The program reads them as Strings so that it can
// process large integers.  Reset the constant DIGITS to allow it to handle
// larger integers.

import java.io.*;
import java.util.*;

public class SumShell {
	public static final int DIGITS = 25;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("sum.txt"));
		processFile(input);
	}

   //this method calls the method processLine
	public static void processFile(Scanner input) {
		int lines = 0;
		while(input.hasNextLine()) {
			String line = input.nextLine();
			// Pass the line to the next scanner
			processLine(line);
			lines++;
		}
		System.out.println();
		System.out.println("Total lines = " + lines);
	}
	//declare an array for the result of sum
	public static void processLine(String s) {
		// Make a new scanner to get each token from the current line
		Scanner data = new Scanner(s);
		// Get the next number
		String next = data.next();
		// Create an array to transfer the next number to
		int[] result = new int[DIGITS];
		// Transfer the next number to the resulting array
		transfer(next, result);
		System.out.print(next);
		while(data.hasNext()) {
			int[] number = new int[DIGITS];
			//read the next token
			next = data.next();
			//declare an array to convert the token that was read into that array
			result = new int[DIGITS];
			//call the method transfer
			transfer(next, number);
			//call the method addto
			addTo(result, number);
			System.out.print(" + " + next);
		}
		System.out.print(" = ");
		print(result);
		System.out.println();
	}
	
	//transfer the string to the array digits
	public static void transfer(String data, int[] digits) {
		// The index of the string, starting from the end
		int index = data.length()-1;
		for(int i = digits.length-1; index >= 0; i--) {
			// Get the number as a char from the string
			char tmpNum = data.charAt(index);
			
			// Convert the char to an int
			int num = Character.getNumericValue(tmpNum);
			// Convert the char to a string and then to an int
			//String stringNum = tmpNum + "";
			//int num = Integer.parseInt(stringNum);
			
			// Replace the number. int i represents the index of the array
			digits[i] = num;
			
			// Go to the next char in the string, which is back one index
			index--;
		}	
	}
	
	// add the array number to the array sum
	public static void addTo(int[] sum, int[] number) {
		int carry = 0;
		for (int i = DIGITS - 1; i >= 0; i--) {
			int result = number[i];
			carry = result / 10;
			result = result % 10;
			sum[i] += result + carry;
		}
		if(carry > 0) {
			throw new RuntimeException("overflow");
		}
	}
	//output the content of the array digits
	public static void print(int[] digits) {
		// Use a for loop to check for the first non zero
		// value. Set start to that number. Then print each
		// number starting from start up until the end of the array
		//for(int start = 0; digits[start] != 0; start++) {}
		int start;
		for(start = 0; start <= digits.length-1; start++) {
			if(digits[start] != 0) {
				break;
			}
		}
		for(int i = start; i <= digits.length-1; i++) {
			System.out.print(digits[start]);
			start++;
		}
		
	}
}
