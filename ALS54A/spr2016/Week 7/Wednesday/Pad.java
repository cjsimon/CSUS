public class Pad
{
	public static void main(String[] args) {
		// Print out the new string with padded spaces
		System.out.println(padString("hello", 8));
	}
	
	public static String padString(String word, int length)
	{
		// How many spaces do we need to add to the front?
		int spaces = length - word.length();
		
		// This line will add one space to the beginning of the word
		// How can we repeat this process, or this line of code,
		// to get the correct number of spaces added to the front of the word?
		word = "_" + word;
		
		// Return the modified word with spaces
		return word;
	}
}