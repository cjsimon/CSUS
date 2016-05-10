public class PracticeIt47 {
	public static void main(String[] args) {
		xo(8);
	}
	
	public static void xo(int a) {
		//int start = 1;
		//int end = a;
		
		// Print each line a number of times
		for(int line = 1, end = a; line <= a; line++, end--) {	
			// Print a number of O
			for(int i = 1; i <= a; i++) {
				// Print either x or o depending on the current position which is i
				if(i == line || i == end) {
					System.out.print("X");
				} else {
					System.out.print("O");
				}
			}
			System.out.println();
			//end--;
		}
	}
}