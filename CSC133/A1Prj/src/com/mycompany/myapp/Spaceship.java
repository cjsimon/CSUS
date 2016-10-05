package com.mycompany.myapp;

import com.codename1.ui.geom.Point2D;

public class Spaceship extends Rescuer {
	private static Spaceship instance = new Spaceship();
	// Attribute Bounds
	// The size attribute of the spaceship which indicates the size of its door is constrained to be a
	// positive integer between 50 and 1024 (inclusive), and set to 100 when the object is created.
	static final int START_SIZE = 100;
	static final int MIN_SIZE	= 50;
	static final int MAX_SIZE	= 1024;	
	// Attributes
	@SuppressWarnings("unused")
	private int size = 100;
	
	// Constructors
	private Spaceship() {}
	
	public static Spaceship getInstance() {
		if(instance != null) {
			return instance;
		}
		return instance = new Spaceship();
	}
	
	@Override
	public boolean setSize(int size) {
		boolean withinBounds = (MIN_SIZE <= size && size <= MAX_SIZE);
		if(withinBounds) this.setSize(size);
		return withinBounds;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean moveUp(double amount) {
		double x = this.getLocation().getX();
		double y = amount;
		return this.setLocation(new Point2D(x, y));
	}

	@Override
	public boolean moveDown(double amount) {
		double x = this.getLocation().getX();
		double y = -amount;
		return this.setLocation(new Point2D(x, y));
	}

	@Override
	public boolean moveLeft(double amount) {
		double x = -amount;
		double y = this.getLocation().getY();
		return this.setLocation(new Point2D(x, y));
	}

	@Override
	public boolean moveRight(double amount) {
		double x = amount;
		double y = this.getLocation().getY();
		return this.setLocation(new Point2D(x, y));
	}

	@Override
	public boolean jumpToLocation(Point2D location) {
		return this.setLocation(location);
	}
}