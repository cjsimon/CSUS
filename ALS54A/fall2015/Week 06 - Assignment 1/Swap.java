public class Swap {
	public static void main(String... args) {
		String s = "hello world";
		System.out.println(swap(s));
	}
	
	public static String swap(String s) {
		String flippedString = "";
		int size = s.length() / 2 * 2;
		for(int i = 0; i < size; i += 2) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(i+1);
			flippedString += "" + c2 + c1;
		}
		if(s.length() % 2 != 0) {
			flippedString += s.charAt(size);
		}
		return flippedString;
	}
}