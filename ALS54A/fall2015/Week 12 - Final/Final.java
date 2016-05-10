public class Final {
	public static void main(String[] args) {
		double[] example = {59, 60, 99, 89, 0, 100};
		
		System.out.printf("%.2f%%\n", q5(example));
	}
	
	public static double q5(double[] value) {
		int counter = 0;
		for(int i = 0; i < value.length; i++) {
			if(value[i] > 90) {
				counter++;
			}
		}
		
		double percent = (double) counter / value.length * 100;
		return percent;
	}
}