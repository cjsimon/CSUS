package com.mycompany.myapp;


// TODO
// The direction of opponents indicates heading specified by a compass angle in degrees.
// 0 is north, 90 is east, 180 is south, and 270 is west.
// See below for details on updating an opponent’s position when its move() method is invoked.


// All opponents are moving and they all move the same way.
public abstract class Opponent extends GameObject implements IMovable {
	private final static Random R = Random.getInstance();
	
	// Attributes
	// All opponents have integer attributes speed and direction,
	// which are used to define how they move through the world
	private int direction;
	private int speed;
	// Attribute Bounds
	// Each opponent size is chosen randomly when created, and constrained to 20 and 50
	private static final int MIN_SIZE = 20;
	private static final int MAX_SIZE = 50;
	// Direction is initialized to a random value, ranging between 0 and 359
	private static final int MIN_DIRECTION = 0;
	private static final int MAX_DIRECTION = 359;
	private static final int MIN_SPEED = 0;
	
	// Constructors
	public Opponent() {
		this(R.nextInt(MIN_SIZE, MAX_SIZE), R.nextInt(MIN_DIRECTION, MAX_DIRECTION), MIN_SPEED);
	}
	public Opponent(int size) {
		this(size, R.nextInt(MIN_DIRECTION, MAX_DIRECTION), MIN_SPEED);
	}
	public Opponent(int size, int direction) {
		this(size, direction, MIN_SPEED);
	}
	public Opponent(int size, int direction, int speed) {
		this.setSize(size);
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
		// All opponents have a size which cannot be changed once the object is created
		return false;
	}
	public boolean setDirection(int direction) {
		boolean withinBounds = (MIN_DIRECTION <= direction && direction <= MAX_DIRECTION);
		if(withinBounds) this.direction = direction;
		return withinBounds;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
