class Midterm2 {
	public static void main(String[] args) {
		System.out.println("Superman: " + secondHalf("superman"));
		
		int[] numbers = {2, 3, 4, 5};
		//				 0  1  2  3
		
		shift(numbers); // [5 2 3 4]
		
		// Print each of the numbers in the array
		System.out.print("{ ");
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.print("}");
	}
	
	// Problem #12: Shifting the array
	public static void shift(int[] numbers) {
		// Get the last element and store it in a temp value
		int lastIndex   = numbers.length-1; // 3
		int temp = numbers[lastIndex]; // numbers[4] -> 5
		
		// Loop through the array, from 0 to 2
		for(int i = numbers.length-2; i >= 0; i--) {
			// Store the next number
			numbers[i+1] = numbers[i];
		}
		// Set the first element, numbers[0], equal to the last element, stored in temp
		numbers[0] = temp;
	}
	
	// Problem #4 (The second 4)
	public static int secondHalf(String s) {
		s = s.toLowerCase();
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= 'n') {
				count++;
			}
		}
		return count;
	}
}