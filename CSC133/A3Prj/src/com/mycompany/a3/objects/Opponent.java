package com.mycompany.a3.objects;

import com.codename1.ui.geom.Point2D;

// All opponents are moving and they all move the same way.
public abstract class Opponent extends GameObject implements IMovable {
	// Attributes
	// All opponents have integer attributes speed and direction,
	// which are used to define how they move through the world
	private int direction;
	private int speed;
	// All opponents have a size which can only be changed once, when the object is instantiated
	private boolean isSizeSet = false;
	// Attribute Bounds
	// Each opponent size is chosen randomly when created, and constrained to 20 and 50
	static final int MIN_SIZE = 20;
	static final int MAX_SIZE = 50;
	// Direction is initialized to a random value, ranging between 0 and 359
	static final int MIN_DIRECTION = 0;
	static final int MAX_DIRECTION = 359;
	static final int MIN_SPEED 	   = 2;
	static final int MAX_SPEED 	   = 10;
	
	// Constructors
	public Opponent(int size, int x, int y, int startWidth, int startHeight, int endWidth, int endHeight, int color, int direction, int speed) {
		super(size, x, y, startWidth, startHeight, endWidth, endHeight, color);
		// Opponents also have direction and speed
		this.setDirection(direction);
		this.setSpeed(speed);
	}
	// Simple Constructor
	public Opponent(int size, int startWidth, int startHeight, int endWidth, int endHeight, int color, int direction, int speed) {
		super(size, startWidth, startHeight, endWidth, endHeight, color);
		// Opponents also have direction and speed
		this.setDirection(direction);
		this.setSpeed(speed);
	}
	
	// Accessors
	public int getDirection() {
		return direction;
	}
	public int getSpeed() {
		return speed;
	}
	
	// Mutators
	@Override
	public boolean setSize(int size) {
		// If the size hasn't been set already, set it. Then prevent it from being set anymore
		if(!isSizeSet) isSizeSet = super.setSize(size);
		// Size is not settable after instantiation. Negate the status indicating that it was set,
		// As to indicate that it was successfully set this one and only time.
		return !isSizeSet;
	}
	public boolean setDirection(int direction) {
		boolean withinBounds = (MIN_DIRECTION <= direction && direction <= MAX_DIRECTION);
		// Constrain the direction to a degree value from 0 to 359
		if(withinBounds) this.direction = direction % 360;
		return withinBounds;
	}
	public boolean setSpeed(int speed) {
		boolean withinBounds = 0 < speed;
		if(withinBounds) this.speed = speed;
		return withinBounds;
	}
	@Override
	// Opponents provide the ability to bounce off the bounds.
	public boolean setLocation(Point2D location) {
		// When the object is first being instantiated, it's location is unset.
		// In this case, run the original, super setLocation method to initially
		// set the location without attempting to check for bouncing.
		// This is okay to do because the object can never be initially bouncing.
		if(this.getLocation() == null) super.setLocation(location);
		
		// The current coordinates before the translation
		double currentX		= this.getLocation().getX();
		double currentY	 	= this.getLocation().getY();
		// The newly proposed coordinates
		double newX 		= location.getX();
		double newY 		= location.getY();
		
		// The bounds of the object
		double minXLocation = this.getMinXLocation();
		double minYLocation = this.getMinYLocation();
		double maxXLocation = this.getMaxXLocation();
		double maxYLocation = this.getMaxYLocation();
		boolean withinXBounds = minXLocation <= newX && newX <= maxXLocation;
		boolean withinYBounds = minYLocation <= newY && newY <= maxYLocation;
		
		if(!withinXBounds) this.bounceX();
		if(!withinYBounds) this.bounceY();
		
		this.location = new Point2D(newX, newY);
		return true;
	}
	
	// Actions
	/**
	 * The direction of opponents indicates heading specified by a compass angle in degrees:
	 * 0 is north
	 * 90 is east
	 * 180 is south
	 * 270 is west
	 * See below for details on updating an opponent's position when its move() method is invoked.
	 * @see com.mycompany.myapp.IMovable#move()
	 */
	public void move() {
		// Calculate the degree of the object based on its specified direction.
		// Calculate the new x and y positions based on the object's current location, direction, and speed
		double x = this.getLocation().getX() + Math.cos(90 - this.getDirection()) * this.getSpeed();
		double y = this.getLocation().getY() + Math.sin(90 - this.getDirection()) * this.getSpeed();
		// Apply the new location, while bouncing if necessary.
		this.setLocation(new Point2D(x, y));
	}
	
	/**
	 * Make the object bounce by rotating the object depending on what direction it is currently facing.
	 * Reflective angle.
	 */
	public boolean bounceX() {
		return this.setDirection(180 - this.getDirection());
	}
	public boolean bounceY() {
		return this.setDirection(180 - this.getDirection());
	}
	
	// Helper Methods
	public String toString() {
		String s = super.toString() 			  + "\n";
		s += "Speed:     " + this.getSpeed() 	  + "\n";
		s += "Direction: " + this.getDirection();
		return s;
	}
}
