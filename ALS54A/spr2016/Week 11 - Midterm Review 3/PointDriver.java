class PointDriver
{
	public static void main(String[] args)
	{
		// Create a new point.
		// This runs public Point(int x int y) from our Point class
		Point p = new Point(1, 5);
		
		// Set the x value of p to 7
		// The dot makes the computer look for a
		// method in the point class called setX
		p.setX(7);
		
		// Calling a println on a Point will make
		// the computer run the toString method
		// inside our Point class. The string we
		// return from that method will be printed
		// in its place
		System.out.println("Point 1: " + p);
		
		Point p2 = new Point(2, 4);
		p2.move(7, 3);
		System.out.println("Point 2: " + p2);
		
		// Check if p is equal to p2
		if(p.equals(p2)) {
			System.out.print("These points are the same");
		} else {
			System.out.println("These points are not the same");
		}
		
		// Create a list of Points
		Point[] points = new Point[3];
		points[0] = new Point(1, 2);
		points[1] = new Point(8, 4);
		points[2] = new Point(4, 1);
		
		// Print out each point from the array
		for(int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
	}
}