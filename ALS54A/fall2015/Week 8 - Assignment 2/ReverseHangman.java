/* This program plays a reverse game of hangman in which the computer tries
 to guess the letters of a word that the user chooses.
 implement one method at a time, test it, then move to the next method*/

 import java.util.*;

 public class ReverseHangman {
 	public static final int MAX_INCORRECT_GUESSES = 6;
 	public static final int MAX_LENGTH = 8;
 	public static final String LETTERS = "ABCDEFGHIJKLMONPQRSTUVWXYZ";
 	public static void main(String[] args)
 	{
 		boolean morePlayer = true;
 		Scanner console = new Scanner(System.in);
 		
 		while(morePlayer)
 		{
 			int totalPlay =0;
 			int totalWin =0;
 			giveIntro();
 			boolean more = true;
 			while(more)
 			{
 				
 				int letters = getLengthWord(console);
 				System.out.println();         
 				console.nextLine();
 				boolean result = playGame(letters, console);
 				if( result)
 				totalWin++;
 			printResult(result, console);     
 			String prompt = "\n\nDo you want to play another game y/n: ";
			   // String answer = console.next();
 			totalPlay++;
 			if (!yesTo(prompt, console))
 			more = false;      
 	}
 	System.out.println("\n");
 	printStat(totalPlay, totalWin);
 	morePlayer = yesTo("Is there any other player", console);
 }   
}

	/*This method prints messages on the screen  
	if compuer was able to guess all the letters, prints certain messages and then asks the user about the word
	if the compuer was not able to guess all the letters will output some other messages. Look at the sample for the
	appropriate messages*/
	public static void printResult(boolean result,  Scanner console)
	{
		//.nextLine();
		if (result)
		{
		   //your code                    
		}    
		else
		{
		   //your code
		}
		 //your code     
	}
	
	
	/*This method prints how many different games the user played and how many times the computer won and how many
	times the computer lost*/ 
	public static void printStat(int totalPlay, int totalWin) 
	{  
		
		//your code
	}
	
	
   /* this method actually plays the game. This method gets the number of the letters in the
   word and then computer start guessing different characters by calling the method getGuess, there should be a while loop
   that loops until either computer guesses all the letters or computer runs out of the number of tries. After computer 
   generates a random character, then computer will ask the user if that letter is in the word or not, 
   if it is then computer will ask how namy times that letter is being repeated in the word,
	the user's answer cannot exceed the number of the letters left to be guesed. as long as the user enters an invalid
	input, your code must ask for a valid answer. after each guess made by the computer the method printGallows
	must be called and the parameter for this method is the number of incorrect guesses by the computer. 
	After exiting the while loop, you must output the list of all the letters that was not picked by the computer
	and the list of all the letters that was picked by the computer. 
	also you must print the correct guesses made by the computer. This method return true if the computer was able to
	guess all the letters in the user's word*/ 
	public static boolean playGame(int letters, Scanner console)
	{ 
		boolean result = false;
		String guessed = "";
		int correct = 0;
		int incorrect = 0;
		String lettersInYourWord ="";
		printGallows(incorrect);
		
		
		while (correct < letters && incorrect < MAX_INCORRECT_GUESSES)
		{
			
			
			   //your code
			
			
			
			if (yesTo("Is that letter in the word?", console)) 
			{
				 //your code
			} 
			else 
			{
			   // your code
			}
			//your code 
		}
		
		 //your code         
		return correct == letters;
		
		
		
	}
	/*This method gets the length of the word from the user.
	This method must keep asking the user until user enters a valid input.
	The length of the word cannot exceed the constant MAX_LENGTH*/
	public static int getLengthWord(Scanner kb)
	{
		int length = 0;
	   //your code
		return length;   
	} 
	
	/*This methods  gets one string representing all the letters guessed by the computer. and outputs all the letters 
	that was not picked by the computer. Refer to the output*/
	public static String printNotGuessedLetters(String guesses)
	{
		String remaind="";
	  //your code
		return remaind;
		
	} 
	
	/*This method outputs the letters that was picked by the computer. 
	This method recives the paramter guesses which contains the letters picked by the computer
	refer to the output*/ 
	public static void printGuessedLetters(String guesses)
	{
	   //your code
	}           
	
	
	/*this method picks a letter at random that we haven't yet guessed. you have to make sure that the char geneterated
	 by the computer has not been picked by the computer previously. 
	 This method gets the string contating all the guessed letters by the computer so far. */
	 
	 /**
	 * Gets the guess from the computer
	 * @return [The letter that was picked]
	 */
	public static String getGuess(String guesses) {
		Random r = new Random();
		int length = guesses.length();
		int index = r.nextInt(length);
		String pickedLetter = guesses.charAt(index) + "";
		return pickedLetter;
	}
	
	public static String removeLetter(String alphabet, String remove) {
		alphabet = alphabet.replace(remove, "");
		return alphabet;
	}

   // explains the program to the user, refer to the output
	 public static void giveIntro() {
	   // your code
	 }

	/* Draws a hangman figure with appropriate body parts for the number
	 of incorrect guesses, adding a head, torso, legs, and arms. this method get the parameter,
	 indicating the number of the wrong guesses need to use conditional statments and print the hangman
	 so for differnt number of incorrect guesses you want to draw differnet part of the hangman the number of incorrect gueeses could be between 0 -6. */
	 
	 public static void printGallows(int guesses)
	 {
	 	
	 }



	/* asks the user a yes/no question, returns true if yes
	the paramert prompt contains the message that we want the user to see. basically the prompt
	is the question that we will be asking the user
	you must do data validation and only y/n are valid inputs
	you rewrite the return statment base on your code*/
	public static boolean yesTo(String prompt, Scanner console) {
	  //your code
		return true;           
	}
}