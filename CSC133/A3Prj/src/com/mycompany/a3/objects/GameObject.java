package com.mycompany.a3.objects;

import com.codename1.maps.BoundingBox;
import com.codename1.maps.Coord;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.Random;
import com.codename1.charts.util.ColorUtil;

// Later we may add other kinds of game objects to the game,
// such as robots that are helpers that aid both astronauts and aliens.
// These new objects may be only moving, only guided, both moving and guided, or neither moving nor guided.
public abstract class GameObject implements IDrawable, ICollidable {
	static final Random R = Random.getInstance();
	
	// Attributes
	// The type of GameObject used for filtering search queries
	@SuppressWarnings("deprecation")
	private final String type = this.getClass().getSimpleName().toString();
	private int size;
	// The point (X, Y) is the center of the object.
	private Point2D location;
	private int color;
	BoundingBox collisionMask;
	// Attribute Bounds
	// All game objects have a location, defined by floating point non-negative values X and Y,
	// within the range 0.0 to GameWorld.width and 0.0 to GameWorld.height respectively.
	private double minXLocation;
	private double minYLocation;
	private double maxXLocation;
	private double maxYLocation;
	// The default color
	static final int DEFAULT_COLOR = ColorUtil.BLACK;
	
	public GameObject(int size, int startWidth, int startHeight, int endWidth, int endHeight, int color) {
		// The location of the object needs to be set before it's size can be calculated
		this.setLocationBounds(startWidth, startHeight, endWidth, endWidth);
		this.setLocation(new Point2D(startWidth, startHeight));
		this.setSize(size);
		this.setColor(color);
	}
	
	// Accessors
	public String getType() {
		return this.type;
	}
	public int getSize() {
		return this.size;
	}
	public Point2D getLocation() {
		return this.location;
	}
	public int getColor() {
		return this.color;
	}
	public BoundingBox getCollisionMask() {
		return collisionMask;
	}
	public double getMinXLocation() {
		return minXLocation;
	}
	public double getMinYLocation() {
		return minYLocation;
	}
	public double getMaxXLocation() {
		return maxXLocation;
	}
	public double getMaxYLocation() {
		return maxYLocation;
	}
	
	// Mutators
	public boolean setSize(int size) {
		this.size = size;
		// Recalculate the bounding box according to the new size
		calculateCollisionMask();
		return true;
	}
	public boolean setLocationBounds(double minX, double minY, double maxX, double maxY) {
		boolean withinBounds = (maxX - minX > 0) && (maxY - minY > 0);
		if(withinBounds) {
			this.minXLocation = minX;
			this.minYLocation = minY;
			this.maxXLocation = maxX;
			this.maxYLocation = maxY;
		}
		return withinBounds;
	}
	// All GameObjects provide the ability for external code to obtain and change their location.
	public boolean setLocation(Point2D location) {
		double minXLocation = this.getMinXLocation();
		double minYLocation = this.getMinYLocation();
		double maxXLocation = this.getMaxXLocation();
		double maxYLocation = this.getMaxYLocation();
		boolean withinBounds = (
				(minXLocation <= location.getX() && location.getX() <= maxXLocation)
				&& (minYLocation <= location.getY() && location.getY() <= maxYLocation));
		if(withinBounds) this.location = location;
		return withinBounds;
	}
	public boolean setColor(int color) {
		this.color = color;
		return true;
	}
	
	// Helper Methods
	@SuppressWarnings("unused")
	private Point2D randomLocation() {
		double minXLocation = this.getMinXLocation();
		double minYLocation = this.getMinYLocation();
		double maxXLocation = this.getMaxXLocation();
		double maxYLocation = this.getMaxYLocation();
		return new Point2D(
				R.nextDouble(minXLocation, maxXLocation),
				R.nextDouble(minYLocation, maxYLocation));
	}
	
	/**
	 * Calculate the bounding box of the object according to it's current size
	 * @return BoundingBox
	 */
	private boolean calculateCollisionMask() {
		double size = this.getSize();
		double diagonalSize = size/2;
		
		Point2D swPoint = new Point2D(location.getX() - diagonalSize, location.getY() - diagonalSize);
		Point2D nePoint = new Point2D(location.getX() + diagonalSize, location.getY() + diagonalSize);
		
		//		                    logitude         latitude
		Coord swCoord = new Coord(swPoint.getY(), swPoint.getX());	
		Coord neCoord = new Coord(nePoint.getY(), nePoint.getX());
		
		collisionMask = new BoundingBox(swCoord, neCoord);
		return true;
	}
	
	// All GameObjects use circular collider checking
	public boolean collidesWith(ICollidable other) {
		// Find Centers
		double thisX = location.getX();
		double thisY = location.getY();
		double thisR = this.getSize()/2;
	    double thisCenterX = thisX + thisR;
	    double thisCenterY = thisY + thisR;
	    // Other Center
		double otherX = location.getX();
		double otherY = location.getY();
		double otherR = ((GameObject) other).getSize()/2;
	    double otherCenterX = otherX + otherR;
	    double otherCenterY = otherY + otherR;
	    
	    // Get the distance between the two obj centers
	    // Keep the centers as squared numbers,
	    // to avoid having to take their square roots
	    double dx = thisCenterX - otherCenterX;
	    double dy = thisCenterY - otherCenterY;
	    double centerDistance = (dx*dx + dy*dy);
	    
	    // Find the square of sum of radii
	    double radiiSqr = (thisR*thisR + 2*thisR*otherR + otherR*otherR);
    
	    return (centerDistance <= radiiSqr);
	}
	
	@Override
	public String toString() {
		Point2D location = this.getLocation();
		double x = Math.round(location.getX());
		double y = Math.round(location.getY());
		
		String s = "";
		s += "Name:      " + this.getType() 		  + "\n";
		s += "Size:      " + this.getSize()			  + "\n";
		s += "Location:  " + "(" + x + ", " + y + ")" + "\n";
		s += "Color:     " + this.getColor();
		return s;
	}
}