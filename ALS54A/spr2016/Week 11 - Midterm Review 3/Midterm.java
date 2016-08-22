public class Midterm {
	public static void main(String[] args) {
		Figure(4, 7);
	}
	
	public static void Figure(int min, int max) {
		int range = max - min + 1;
		for(int i = 0; i < range; i++) {
			for(int j = 0; j < range; j++) {
				System.out.println((j + i) % range + min * 2 + "*");			
			}
			System.out.println("\n");
		}
	}
}