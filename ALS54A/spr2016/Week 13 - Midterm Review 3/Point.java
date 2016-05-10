public class Point {
	/*************
	 * Attributes
	 * (Privates)
	 ************/
	private int x;
	private int y;
	
	
	/**************
	 * Constructor
	 *************/
	// Point - Called when we create a new Point
	// Notice how there is no return type
	public Point(int x, int y) {
		setX(x);
		setY(y);
	}
	
	
	/************
	 *  Methods
	 * (Actions)
	 ***********/
	// Translate a point given an x and y coordinate
	public void move(int xcord, int ycord) {
		x += xcord;
		y += ycord;
	}
	// Calculate the slope of two points
	public double slope(Point p) {
		int y1 = y;
		int y2 = p.y;
		int x1 = x;
		int x2 = p.x;
		
		// We only need to cast one of the numbers
		// as a double to get a double result
		return ((double)(y1 - y2)) / (x1 - x2);
	}
	
	
	/***************************
	 *   Setters and Getters
	 * (Mutators and Accessors)
	 **************************/
	// Setters - Set the value of a private attribute
	public void setX(int v) {
		x = v;
	}
	public void setY(int v) {
		y = v;
	}
	// Getters - Get the value of a private attribute
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
	/******************
	 * Special Methods
	 *****************/
	// Equals - Check if two Points are equal
	public boolean equals(Point p) {
		if(x == p.x && y == p.y) {
			return true;
		} else {
			return false;
		}
	}
	// toString - Gets called when we print a point
	public String toString() {
		String s = "x: " + x + " y: " + y;
		return s;
	}
}