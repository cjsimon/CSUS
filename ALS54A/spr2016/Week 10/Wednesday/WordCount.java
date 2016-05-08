class WordCount
{
	public static void main(String[] args) {
		System.out.println(wordCount("   test     string"));
	}
	
	public static int wordCount(String word) {
		// These are the variables that
		// we came up with in our sudo
		// code that we need the computer
		// to understand.
		
		// + "" is used to convert a char to a String in this program,
		// so that we can use String comparison methods, such as .equals
		
		int count = 0;								// The word count
		int index = 0;								// The index of the char we are trying to get. This is the int.
		String currentChar = word.charAt(0) + "";	// The char at the index we are trying to get. This is the char.
		
		// So long as we have't reached the end of the word yet...
		// We use length() - 1 because the index starts at 0.
		while(index <= word.length()-1)
		{
			// So long as we haven't found a character yet...
			while(currentChar.equals(" "))
			{
				// The caveat:
				// If at any point the index reaches the end of the word,
				// end the method and return the count
				if(index >= word.length()-1) {
					return count;
				}
				
				// Keep going to the next index,
				// and get the char at that index
				index++;
				currentChar = word.charAt(index) + "";
			}
			
			// Add one to count
			count++;
			
			// Keep going to the next index until we find a space
			while(!currentChar.equals(" ")) //AKA: So long as the char is not a space...
			{
				// The caveat:
				// If at any point the index reaches the end of the word,
				// end the method and return the count 
				if(index >= word.length()-1) {
					return count;
				}
				
				// Keep going to the next index,
				// and get the char at that index
				index++;
				currentChar = word.charAt(index) + "";
			}
		}
		return count;
	}
}