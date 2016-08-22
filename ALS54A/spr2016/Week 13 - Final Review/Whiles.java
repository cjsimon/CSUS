class Whiles {
	public static void main(String[] args) {
		int i = 1;
		while(i <= 2) {
			int j = i;
			while (j <= 3) {
				int k = j;
				while(k <= 4) {
					System.out.print("*");
					k++;
				}
				System.out.print("!");
				j++;
			}
			System.out.println();
			i++;
		}
		System.out.println();
	}
}