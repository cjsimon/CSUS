package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;

public class Astronaut extends Opponent {
	// Attributes
	private int health;
	private int color = ColorUtil.red(255);
	// Attribute Bounds
	// The health of the astronaut starts at 5
	static final int DEFAULT_HEALTH = 5;
	// To calculate the speed, use the formula, speed = health x constant.
	// For now, we assume that constant is equal to 1.
	static final int SPEED_CONSTANT = 1;
	
	public Astronaut() {
		super();
		this.setHealth(DEFAULT_HEALTH);
	}
	public Astronaut(int size) {
		super(size);
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
		this.setSpeed(this.getHealth() * SPEED_CONSTANT);
		return withinBounds;
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
