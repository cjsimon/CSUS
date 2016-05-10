public class mystery {
	public static void mystery3(int[] data, int x, int y) {
		data[data[x]] = data[y];
		data[y] = x;
	}
	
	public static void main(String[] args) {
		int[] numbers = {3, 7, 1, 0, 25, 4, 18, -1, 5};
		mystery3(numbers, 3, 1);
		mystery3(numbers, 5, 6);
		mystery3(numbers, 8, 4);
		
		for(int i : numbers) System.out.println(i);
	}
}