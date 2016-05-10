public class pattern {
	public static void main(String[] args) {
		int[] a1 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		int[] a2 = {1, 0, 1};
		// Is a2 contained in a1?
		System.out.println(contains(a1, a2));
	}
	
	public static boolean contains(int[] a1, int[] a2) {
		// The current index of a2
		// Once we reach the ending index, we have a match
		int a2Index = 0;
		
		// For each letter in the first array, a1
		for(int i = 0; i < a1.length; i++) {
			// Go to the next number if we have a matching number
			if(a1[i] == a2[a2Index]) {
				a2Index++;
			} else {
				// Otherwise, if the number from a1[i]
				// does not match the number from a2[a2Index]
				// Start at the beginning of a2, and search for the pattern again
				a2Index = 0;
			}
			
			// If all of a2 has been traversed, then
			// we have sucessfully found the pattern			
			if(a2Index == a2.length) {
				return true;
			}
		}
		// After going through each number in a1 and not finding a pattern, return false
		return false;
	}
}