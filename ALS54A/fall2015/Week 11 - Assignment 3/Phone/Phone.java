public class Phone {
	// Attributes: The properties of the object you are defining
	String software;
	int batteryLife;
	boolean isTouch;
	
	/**
	 * The constructor helps create a new Phone given the following attributes.
	 * Notice how there is no return type for this method.
	 * This method is asking, "What attributes (parameters) do I expect from the user?
	 * This allows us to use the code, Phone android = new Phone("Android", 10, true); in the Main class
	 * @param  s [software]
	 * @param  b [batteryLife]
	 * @param  t [isTouch]
	 */
	public Phone(String s, int b, boolean t) {
		software = s;
		batteryLife = b;
		isTouch = t;
	}
	
	/**
	 * Use the phone. Subtract an hour of battery life
	 */
	public void usePhone() {
		// Indicate that the phone is being used
		System.out.println(software + " is being used!");
		// Then, subtract an hour from the batteryLife which is an attribute
		batteryLife--;
	}
	
	/**
	 * The toString method is called whenever a Phone is inside a System.out.println()
	 * @return [The string to print out]
	 */
	public String toString() {
		String s = "";
		s += "Software: " + software + "\n";
		s += "Battery Power: " + batteryLife + "hrs\n";
		s += "Touch Screen: " + isTouch + "\n";
		return s;
	}
}