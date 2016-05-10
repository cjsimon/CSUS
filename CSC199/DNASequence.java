class DNASequence {	
	public static void main(String... args) {
		System.out.println(longestDNASequence("ATCGE"));
	}
	
	public static int longestDNASequence(String s) {
		
		// Base Case
		if(s.length() == 0) return 0;
		
		int count = 0, greatest = 0;
		
		// Brute force iterate over the string
		for(int i = 0; i < s.length()-1; i++) {
			if(checkLetter("" + s.charAt(i))) {
				count++;
			} else {
				// Greedily check for the greatest count,
				// before resetting the count back to 0
				greatest = Math.max(count, greatest);
				count = 0;
			}
		}
		greatest = Math.max(count, greatest);
		return greatest;
	}
	
	/**
	 * Checks if the input letter is one of the chars in the String o
	 * @param  c The input char as a String
	 * @return   boolean
	 */
	public static boolean checkLetter(String c) {
		String[] o = {"A", "C", "G", "T"};
		for(int i = 0; i < o.length; i++) {
			if(c.equals(o[i])) {
				return true;
			}
		}
		return false;
	}
}