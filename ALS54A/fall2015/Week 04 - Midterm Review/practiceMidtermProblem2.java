public class practiceMidtermProblem2 {
	/**
	 * Output:
	 * 14
	 * three one 7 x + z
	 */
	public static void main(String[] args) {
		int x = 4;
		int eight = 2;
		int one = 8;
		String y = "three";
		String z = "7";
		String ten = "one";
		
		addFour(x, one); // 8 - 4 + 10 = 14
		subtractFive(ten, y, z); // "three one 7 "
		String four = getFive(z, x); // returns "x + z"
		System.out.print(four); // "x + z"
	}
	
	public static void addFour(int eight, int x) {
		System.out.println(x - eight + 10);
	}
	
	public static void subtractFive(String eight, String four, String one) {
		System.out.print(four + " " + eight + " " + one + " ");  
	}
	
	public static String getFive(String x, int z) {
		z = z + 10;
		return "x + z";
	}
}