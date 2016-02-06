/**
 * Problem Statement:
 * We call a pair of Strings (s, t) "wood" if t is contained in s as a subsequence.
 *
 * Given Strings s and t, return the String "Yep, it's wood."
 * if the pair (s, t) is wood and "Nope." otherwise.
 * 
 * Class:		IdentifyingWood
 * Method:		check
 * Parameters:	String, String
 * Returns:		String
 * Signature:	String check(String s, String t)
 * See:	https://community.topcoder.com/stat?c=problem_statement&pm=13487&rd=16078
 */
class IdentifyingWood {	
	public static String check(String s, String t) {
		int i = 0; // Index of t
		int j = 0; // Index of s
		for(; j < s.length() - 1; j++) {
			if(t.charAt(i) == s.charAt(j)) {
				// A char in t has been found in a.
				// Go to the next letter to check if we have found that character in t
				i++;
			}
			// Terminating Case: When index i has checked each letter in, t
			if(i > t.length() - 1) return "Yep, it's wood.";
		}
		// At this point, index j has traversed through each letter in s
		// Since index, i, still hasn't checked each character in t, (i !> t.length() - 1),
		// we can deduce that t is not a subsequence contained in s.
		return "Nope.";
	}
}