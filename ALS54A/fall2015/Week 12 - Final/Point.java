// This file defines a new class of objects named Point.
// This version of the class adds the following features:
// - Constructor: 		(Initializes new Point objects)
// - toString method:	(Tells Java how to println Point objects)
// - Attributes:		(Private fields to protect the object's data)
public class Point {
	// Attributes: The properties that make up a Point
	// Private means that only the Point object can access these variables
	private int x;	// Each Point object should have a variable
	private int y;	// inside it named x, and a variable named y
	
	// Initializes the state of a new Point object at the given x/y location.
	// 1) This method runs when new Point(x, y) is used in the main class file.
	// 2) Initializes the x and y coordinates of the object being created.
	public Point(int initialX, int initialY) {
		x = initialX;
		y = initialY;
	}
	
	public static void main(String[] args) {
		int j = 1;
		int i = ++j + j++ * 5;
		System.out.println(i);
		System.out.println(j);
	}
	
	// Getters
	// Returns the Point's x coordinate attribute.
	public int getX() {
		return x;
	}
	// Returns the Point's y coordinate attribute.
	public int getY() {
		return y;
	}
	
	// Setters
	public void setX(int newX) {
		x = newX;
	}
	public void setY(int newY) {
		y = newY;
	}
	// Sets the Point's x/y coordinates to a new location.
	public void setLocation(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	// Actions
	// Computes the slope between this point and another Point, p2.
	public double slope(Point p2) {
		int x2 = p2.x;
		int y2 = p2.y;
		// Slope is defined as (y2 - y)/(x2 - x)
		double slope = (y2 - y)/(x2 - x);
		return slope;
	}
	
	// This methods is used when System.out.println() is called
	public String toString() {
		// Return the x and y coordinates as a String: "(-5, 2)"
		return "(" + x + ", " + y + ")";
	}
}
