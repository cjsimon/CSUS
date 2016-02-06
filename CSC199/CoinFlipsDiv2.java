public class CoinFlipsDiv2 {
	public static void main(String... args) {
		System.out.println(countCoins("THHH"));
	}
	
	public static int countCoins(String state) {
		if(state.length() < 2) return state.length();
		
		int intrest = 0;
		char last = state.charAt(0);
		char next = state.charAt(1);
		
		// First
		if(last != next) {
			intrest++;
		}
		
		for(int c = 1; c < state.length()-1; c++) {
			char coin = state.charAt(c);
			next = state.charAt(c+1);
			if(coin != last || coin != next) {
				intrest++;
			}
			last = coin;
		}
		
		// Last
		if(state.charAt(state.length()-1) != state.charAt(state.length()-2)) {
			intrest++;
		}
		
		return intrest;
	}
}