// I've attached my mess of a solution
// I want to reupload this on a later date; I'm sure I can figure it out with enough time.

public class EqualSubstrings2 {
	public static void main(String... args) {
		equal("kaszzzjdnaaaabkjsdzzzzanzflaaaaaa");
	}
	
	public int equal(String s) {
		s.split("");
		int count = 0;
		int endIndex = 0;
		int indexSize = 1;
		
		// For each selection, starting with one character selection
		for(int i = 0; i < s.length; i++) {
			endIndex = i;
			getString(s[i], );
			
			// Check each other letter for the given selectionLength
			for(int c = endIndex; c < s.length; c += indexSize) {
				String sub = getString(s, endIndex-(indexSize-1), endIndex);
				if() {
					
				}
			}
		}		
		
		return count;
	}
	
	public String getString(String[] s, int start, int end) {
		String res = "";
		for(int c = start; c <= end; c++) {
			res += s[c];
		}
		return res;
	}
}