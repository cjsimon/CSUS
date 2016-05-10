// Passes Tests
public class ParenthesesDiv2Easy {
	public static void main(String[] args) {
		System.out.println(getDepth("()()(())"));
	}
	
	public static int getDepth(String s) {
		// Left and Right parenthesis count
		int l = 0, r = 0;
		
		// Get the last paren char
		char lastC = ' ';
		
		int depth = 1;
		int maxSet = 0;
		int lastSet = 0;
		
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == '(') {
				l++;
				// Depth increases when a new left paren is found after
				// the last character was also a left paren 
				if(lastC == c) {
					depth++;
				}
			} else {
				r++;
			}
			
			// End of the current set
			if(l == r && l != 0) {
				lastSet = depth;
				if(lastSet >= maxSet) maxSet = lastSet;
				l = r = 0;
				depth = 1;
			}
			
			lastC = c;
		}
		
		return maxSet;
	}
}