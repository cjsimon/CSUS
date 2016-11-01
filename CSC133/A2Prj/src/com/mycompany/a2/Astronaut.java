package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Astronaut extends Opponent {
	// Attributes
	private int health;
	@SuppressWarnings("unused")
	private int color = ColorUtil.WHITE;
	// Attribute Bounds
	// The health of the astronaut starts at 5
	static final int DEFAULT_HEALTH = 5;
	// To calculate the speed, use the formula, speed = health x constant.
	// For now, we assume that constant is equal to 1.
	static final int SPEED_CONSTANT = 1;
	
	// Constructors
	public Astronaut(GameWorld gw) {
		super(gw);
		this.setSize(R.nextInt(MIN_SIZE, MAX_SIZE));
		this.setDirection(R.nextInt(MIN_DIRECTION, MAX_DIRECTION));
		this.setSpeed(MIN_SPEED);
		this.setColor(DEFAULT_COLOR);
		this.setHealth(DEFAULT_HEALTH);
	}
	public Astronaut(int size, GameWorld gw) {
		super(size, gw);
		this.setHealth(DEFAULT_HEALTH);
	}
	
	// Accessors
	public int getHealth() {
		return health;
	}

	// Mutators
	public boolean setHealth(int health) {
		// The health of the astronaut is in the range 0-5
		boolean withinBounds = 0 < health && health < 5;
		if(!withinBounds) return false;
		this.health = health;
		// 
		this.setSpeed(this.getHealth() * SPEED_CONSTANT);
		return withinBounds;
	}
	
	// Actions
	/**
	 * Subtracts the current health of the Astronaut by 1
	 * @return
	 */
	public boolean hit() {
		boolean hit = this.setHealth(this.getHealth() - 1);
		// Change the color
		int currentColor = this.getColor();
		// Get the existing color and increase the red component
		int newColor = ColorUtil.rgb(
				ColorUtil.red(currentColor)   + 20,
				ColorUtil.green(currentColor) + 0,
				ColorUtil.blue(currentColor)) + 0;
		this.setColor(newColor);
		return hit;
	}
	
	// Helper Methods
	@Override
	public String toString() {
		String s = super.toString() 			 + "\n";
		s += "Speed:     " + this.getSpeed() 	 + "\n";
		s += "Direction: " + this.getDirection() + "\n";
		s += "Health:    " + this.getHealth();
		return s;
	}
}
