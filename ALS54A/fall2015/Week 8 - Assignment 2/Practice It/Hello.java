public class Hello {
	public static void main(String[] args) {
		String x = sum(29107); // 2 + 9 + 1 + 0 + 7
		System.out.println(x);
		
		// This line of code will produce the same output as the two lines above
		System.out.println( sum(29107) );
	}
	
	public static String sum(int n) {
		// Create a string to hold the resultant string sum
		String sum = "";
		
		// Convert the number to a string
		String stringNumber = n + "";
		
		// Get the first number before the while loop. Convert it to a string
		sum = sum + stringNumber.charAt(0) + "";
		 
		// Loop: Take us through each index of the stringNumber, starting with index 1
		int i = 1;
		while(i <= stringNumber.length() - 1) {
			// Get the current number at i. Convert that char to a string using ""
			String stringAnswer = stringNumber.charAt(i) + "";
			// Add that number to the sum string along with the " + "
			sum = sum + " + ";
			sum = sum + stringAnswer;
			
			// Increment to the next i, the index value
			i++;
		}
		
		// Return the sum string containing the whole string
		return sum;
	}
}