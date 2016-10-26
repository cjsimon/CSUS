package com.mycompany.a2;

import com.codename1.maps.BoundingBox;
import com.codename1.maps.Coord;
import com.codename1.ui.geom.Point2D;
import com.codename1.charts.util.ColorUtil;

// Later we may add other kinds of game objects to the game,
// such as robots that are helpers that aid both astronauts and aliens.
// These new objects may be only moving, only guided, both moving and guided, or neither moving nor guided.
public abstract class GameObject {
	static final Random R = Random.getInstance();
	
	// Attributes
	// The type of GameObject used for filtering search queries
	@SuppressWarnings("deprecation")
	private final String type = this.getClass().getSimpleName().toString();
	private int size;
	// The point (X,Y) is the center of the object.
	private Point2D location;
	private int color;
	BoundingBox collisionMask;
	// Attribute Bounds
	// All game objects have a location, defined by floating point non-negative values X and Y,
	// within the range 0.0 to GameWorld.WIDTH and 0.0 to GameWorld.HEIGHT respectively.
	static final double MIN_X_LOCATION = 0.0;
	static final double MIN_Y_LOCATION = 0.0;
	static final double MAX_X_LOCATION = (double)GameWorld.WIDTH;
	static final double MAX_Y_LOCATION = (double)GameWorld.HEIGHT;
	static final int 	DEFAULT_COLOR  = ColorUtil.rgb(0, 0, 0);
	
	// Constructors
	public GameObject() {
		this(0, randomLocation(), DEFAULT_COLOR);
	}
	public GameObject(int size) {
		this(size, randomLocation(), DEFAULT_COLOR);
	}
	public GameObject(int size, Point2D location) {
		this(size, location, DEFAULT_COLOR);
	}
	public GameObject(int size, Point2D location, int color) {
		this.setSize(size);
		this.setLocation(location);
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
	
	// Mutators
	public boolean setSize(int size) {
		this.size = size;
		// Recalculate the bounding box according to the new size
		calculateCollisionMask();
		return true;
	}
	// All GameObjects provide the ability for external code to obtain and change their location.
	public boolean setLocation(Point2D location) {
		boolean withinBounds = (
				(MIN_X_LOCATION <= location.getX() && location.getX() <= MAX_X_LOCATION)
				&& (MIN_Y_LOCATION <= location.getY() && location.getY() <= MAX_Y_LOCATION));
		if(withinBounds) this.location = location;
		return withinBounds;
	}
	public boolean setColor(int color) {
		this.color = color;
		return true;
	}
	
	// Helper Methods
	private static Point2D randomLocation() {
		return new Point2D(
				R.nextDouble(MIN_X_LOCATION, MAX_X_LOCATION),
				R.nextDouble(MIN_Y_LOCATION, MAX_Y_LOCATION));
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