package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;

public class Alien extends Opponent {
	// Attribute Bounds
	// To calculate the speed, use the formula, speed = 5 x constant.
	// For now, we assume that constant is equal to 1.
	private static final int SPEED_CONSTANT = 1;
	private static final int DEFAULT_SPEED  = 5;
	// All objects of the same class have the same initial color
	
	// Attributes
	private int color = ColorUtil.GREEN;
	
	public Alien() {
		super();
		super.setSpeed(DEFAULT_SPEED * SPEED_CONSTANT);
	}
	public Alien(int size) {
		super(size);
		super.setSpeed(DEFAULT_SPEED * SPEED_CONSTANT);
	}
	public Alien(int size, int direction) {
		super(size, direction);
		super.setSpeed(DEFAULT_SPEED * SPEED_CONSTANT);
	}

	@Override
	// The speed of an alien never changes
	public boolean setSpeed(int speed) {
		return false;
	}
	
	@Override
	public String toString() {
		String s = super.toString() 			 + "\n";
		s += "Speed:     " + this.getSpeed() 	 + "\n";
		s += "Direction: " + this.getDirection();
		return s;
	}
	
}
