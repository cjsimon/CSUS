public class Main {
	public static void main(String[] args) {
		Phone iPhone = new Phone("iOS", 8, true);
		Phone android = new Phone("Android", 1, false);
		
		System.out.println(iPhone);
		iPhone.usePhone();
		System.out.println(iPhone);
		
		System.out.println(android);
	}
}