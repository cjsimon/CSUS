import java.util.Random;

public class GetGuess {
	public static void main(String[] args) {
		// This is our testbed to test the getGuess and 
		String guesses = "ABCDEFGHIJKLMONPQRSTUVWXYZ";
		String computerGuess = getGuess(guesses);
		guesses = removeLetter(guesses, computerGuess);
		System.out.println("The computer guessed: " + computerGuess + "!");
		System.out.println("The remaining letters are: " + guesses + "!");
	}
	
	/**
	 * Gets the guess from the computer
	 * @param  guesses [The String of letters to pick from]
	 * @return 		   [The picked letter from guesses]
	 */
	public static String getGuess(String guesses) {
		Random r = new Random();
		int length = guesses.length();
		int index = r.nextInt(length);
		String pickedLetter = guesses.charAt(index) + "";
		return pickedLetter;
	}
	
	/**
	 * Removes the specified letter, remove, from 
	 * @param  alphabet [The String to remove the letter from]
	 * @param  remove   [The letter to remove]
	 * @return          [The modified String, alphabet with the removed character]
	 */
	public static String removeLetter(String alphabet, String remove) {
		// Replace the letter, remove, with nothing, "", in the the alphabet string
		alphabet = alphabet.replace(remove, "");
		// Return the new alphabet string
		return alphabet;
	}
}