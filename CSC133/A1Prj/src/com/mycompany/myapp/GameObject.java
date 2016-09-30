package com.mycompany.myapp;

import com.codename1.maps.BoundingBox;
import com.codename1.ui.geom.Point2D;
import com.codename1.charts.util.ColorUtil;

// Later we may add other kinds of game objects to the game,
// such as robots that are helpers that aid both astronauts and aliens.
// These new objects may be only moving, only guided, both moving and guided, or neither moving nor guided.

public abstract class GameObject {
	private static final Random r = Random.getInstance();
	
	// Attributes
	private int size;
	// The point (X,Y) is the center of the object.
	private Point2D location;
	private int color;
	BoundingBox boundingMask;
	// Attribure Bounds
	// All game objects have a location, defined by floating point non-negative values X and Y,
	// within the range 0.0 to GameWorld.WIDTH and 0.0 to GameWorld.HEIGHT respectively.
	private static final double MIN_X_LOCATION = 0.0;
	private static final double MIN_Y_LOCATION = 0.0;
	private static final double MAX_X_LOCATION = (double)GameWorld.WIDTH;
	private static final double MAX_Y_LOCATION = (double)GameWorld.HEIGHT;
	private static final int 	DEFAULT_COLOR  = ColorUtil.rgb(0, 0, 0);
	
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
	public int getSize() {
		return size;
	}
	public Point2D getLocation() {
		return location;
	}
	public int getColor() {
		return color;
	}

	// Mutators
	public boolean setSize(int size) {
		this.size = size;
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
				r.nextDouble(MIN_X_LOCATION, MAX_X_LOCATION),
				r.nextDouble(MIN_Y_LOCATION, MAX_Y_LOCATION));
	}
}