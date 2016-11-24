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
		if(withinBounds) this.direction = direction;
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
		// The resulting coordinates that the object will move to
		double resultX;
		double resultY;
		
		// The bounds of the object
		double minXLocation = this.getMinXLocation();
		double minYLocation = this.getMinYLocation();
		double maxXLocation = this.getMaxXLocation();
		double maxYLocation = this.getMaxYLocation();
		boolean withinXBounds = minXLocation <= newX && newX <= maxXLocation;
		boolean withinYBounds = minYLocation <= newY && newY <= maxYLocation;
		
		// Coordinate Bounds
		// Move the object to the proposed coordinate if it is within bounds
		// If not, modify the coordinate to move the object in the opposite direction
		if(withinXBounds) {
			// The proposed coordinate is within bounds.
			// Update the result to use this proposed value
			resultX = newX;
		} else {
			// Make the object move in the reverse direction.
			// This is done by subtracting the proposed coordinate,
			// thus applying a negative (opposite) translation.
			// With this, the direction of the object must also be
			// mirrored to prevent the object from sticking,
			// or jittering, up on the edge of the bounding wall.
			resultX = -newX;
			// Reversing direction is done by making the object turn.
			// Use the bounce method to calculate the degree necessary to rotate
			this.bounce();
		}
		if(withinYBounds) {
			resultY = newY;
		} else {
			resultY = -newY;
			this.bounce();
		}
		
		// Now that the coordinate pair has been modified,
		// set it as the new location by sending it to the
		// original, super setLocation method.
		// Note: Doing so will run the bound checks once again.
		// 		 This doesn't and shouldn't be done, as if the
		//		 check were more costly, it would cause extra
		//		 unnecessary overhead. Since the coordinates
		//		 Have already been checked, consider instead
		//		 modifying the location components directly.
		//
		//return super.setLocation(new Point2D(resultX, resultY));
		// The location has been modified and is now within the bounds.
		// Update it directly. This is allowed because location is a protected attribute.
		this.location = new Point2D(resultX, resultY);
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
		// Constrain the direction to a degree value from 0 to 359
		int degree = this.getDirection() % 360;
		// Calculate the new x and y positions based on the object's current location, direction, and speed
		double x = this.getLocation().getX() + Math.cos(90 - degree) * this.getSpeed();
		double y = this.getLocation().getY() + Math.sin(90 - degree) * this.getSpeed();
		// Apply the new location, while bouncing if necessary.
		this.setLocation(new Point2D(x, y));
	}
	
	/**
	 * Make the object bounce by rotating the object depending on what direction it is currently facing
	 */
	public boolean bounce() {
		int currentDirection = this.getDirection();
		if(0 < currentDirection && currentDirection < 180) {
			// If the object is facing east, the object needs to rotate +90 clockwise.
			return this.setDirection(this.getDirection() + 90);
		} else if(180 < currentDirection && currentDirection < 360) {
			// If the object is facing west, the object needs to rotate -90 clockwise.
			return this.setDirection(this.getDirection() - 90);
		} else if(currentDirection == 0 || currentDirection == 180) {
			// If the object is facing exactly north or south, the object needs to rotate 180.
			return this.setDirection(this.getDirection() + 180);
		}
		return false;
	}
	
	// Helper Methods
	public String toString() {
		String s = super.toString() 			  + "\n";
		s += "Speed:     " + this.getSpeed() 	  + "\n";
		s += "Direction: " + this.getDirection();
		return s;
	}
}
