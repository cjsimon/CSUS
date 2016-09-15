public class Guess {
   static int[] numbers;
   
	public static void main(String args[]) {
		makeGuesses();
	}

	public static void makeGuesses() {
		//The number to guess
		int guess = 48;
		//The range of number to guess from
		int min = 1;
		int max = 50;
		//The totalNumber of entries is defined as the max-min
		int totalNumbers = max-min;
		//Create an array of totalNumbers elemnts
		numbers = new int[totalNumbers];
		//Populate the number array from min to max digits
		for(int i = min; i < max; i++) {
		//The index of an element of numbers is defined as the (current element i - min)
		//This is an offset that accounts for range
		int index = (i - min);
			//Store the current number into the array
			numbers[index] = i;
		}
		//The number of guesses
		int guessCount = 0;
		//The guess element index in the numbers
		int guessIndex = (guess - min);
		//Check whether the guess in numbers has been eliminated yet
		while(notGuessed(guess, min, max)) {
			//The randNumber and it's index in the numbers
			int randNumber, index;
			//Check if this number was already guessed
			//If it has make another guess
			do {
				//Pick another random number from min to max
				randNumber = (int)(max - (Math.random() * (max-min)));
				//And reevaluate the index for the new number
				index = (randNumber - min);
			} while(numbers[index] != randNumber);
   		//Eliminate it from the numbers
   		//set the current element value to a number that is not used in numbers
   		//min-1 is never used in numbers
   		numbers[index] = (min-1);
   		//Print the randNumber
   		System.out.println("guess = " + randNumber);
   		//Incrament the guessCount
   		guessCount++;
		}
	}
   
   public static boolean notGuessed(int guess, int min, int max) {
      for(int i = guess-1; i < max-1; i++) {
         if(numbers[i] == min-1) {
            return false;
         }
      }
      return true;
   }
}