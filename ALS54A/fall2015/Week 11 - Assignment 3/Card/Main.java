// This is the main program that drives the card class.
// This is also known as a Driver class. This is where we use the card class.
public class Main {
	public static void main(String[] args) {
		// Create a multidimentional array
		Card[][] cards = new Card[4][4];
		
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 4; y++) {
				cards[x][y] = new Card(n, true);
				System.out.println(cards[x][y]);
			}
		}
	}
}