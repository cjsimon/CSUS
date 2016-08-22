class Price {
	public static void main(String[] args) {
		int number = priceIsRight(new int[] {200, 300, 250, 999, 40}, 280);
		System.out.println(number);
	}
	
	public static int priceIsRight(int[] prices, int n) {
		// Step 1: Find the largest number
		// Step 2: Whose value is less than n
		
		int greatest = -1;
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] > greatest && prices[i] < n) {
				greatest = prices[i];
			}
		}
		return greatest;
	}
}