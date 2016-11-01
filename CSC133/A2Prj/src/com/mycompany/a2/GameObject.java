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
	// GameWorld instance that the GameObject is associated with.
	// Used to get properties from the room
	private GameWorld gw;
	// The default color
	static final int DEFAULT_COLOR = ColorUtil.rgb(0, 0, 0);
	
	// Constructors
	// TODO: Fix random location so that it can refer to the location bounds
	//       of an instance of a GameObject while still being a static method.
	// TODO: Find a better way to get width and height from GameWorld without
	//       the need to have a reference to it.
	public GameObject(GameWorld gw) {
		this(0, new Point2D(0.0, 0.0)/*randomLocation()*/, DEFAULT_COLOR, gw);
	}
	public GameObject(int size, GameWorld gw) {
		this(size, new Point2D(0.0, 0.0)/*randomLocation()*/, DEFAULT_COLOR, gw);
	}
	public GameObject(int size, Point2D location, GameWorld gw) {
		this(size, location, DEFAULT_COLOR, gw);
	}
	public GameObject(int size, Point2D location, int color, GameWorld gw) {
		this.setSize(size);
		this.setLocationBounds(0.0, 0.0, gw.getWidth(), gw.getHeight());
		this.setLocation(location);
		this.setColor(color);
		// Bind the object to a specific GameWorld
		// TODO: If this implementation is to be kept,
		//       then it would be better to make the
		//       GameWorld a singleton, so that all
		//       GameObjects are only bound to a single
		//       gw at a time, as to prevent a GameObject
		//       from having conflicting location bounds
		//       from many different GameWorlds.
		this.gw = gw;
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