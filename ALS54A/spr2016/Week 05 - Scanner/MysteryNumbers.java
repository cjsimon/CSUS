public class MysteryNumbers {
	public static void main(String[] args) {
		String one = "two";
		String two = "three";
		String three = "1";
		int number = 20;

		sentence(one, two, 3);
		sentence(two, three, 14);
		sentence(three, three, number + 1);
		sentence(three, two, 1);
		sentence("eight", three, number / 2);
		
		/********************
		Solutions:
		---------------------
		three times two = 6
		1 times three = 28
		1 times 1 = 42
		three times 1 = 2
		1 times eight = 20
		********************/
	}

	public static void sentence(String three, String one, int number) {
		System.out.println(one + " times " + three + " = " + (number * 2));
	}
}