package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

public class Spaceship extends Rescuer implements IGuided {
	private static Spaceship instance = new Spaceship();
	
	// Attributes
	@SuppressWarnings("unused")
	// Attribute Bounds
	// The size attribute of the spaceship which indicates the size of its door is constrained to be a
	// positive integer between 50 and 1024 (inclusive), and set to 100 when the object is created.
	static final int START_SIZE = 100;
	static final int MIN_SIZE	= 50;
	static final int MAX_SIZE	= 1024;	
	
	// Constructors
	// TODO: This is technically bad practice.
	//       The fact that code for setting a parameter exists
	//       in the singleton indicates that this object shouldn't
	//       really be using the singleton design pattern.
	//       Singletons should have an empty body implementation.
	private Spaceship() { setSize(START_SIZE); }
	public static Spaceship getInstance() {
		if(instance != null) {
			return instance;
		}
		return instance = new Spaceship();
	}
	
	// Mutators
	@Override
	public boolean setSize(int size) {
		boolean withinBounds = (MIN_SIZE <= size && size <= MAX_SIZE);
		if(withinBounds) super.setSize(size);
		return withinBounds;
	}

	// Actions
	@Override
	public boolean moveUp(double amount) {
		double y = this.getLocation().getY();
		double dy = amount;
		double newY = y + dy;
		double x = this.getLocation().getX();
		
		boolean withinBounds = 0 < newY && newY < GameWorld.HEIGHT;
		if(!withinBounds) return false;
		return this.setLocation(new Point2D(x, newY));
	}
	@Override
	public boolean moveDown(double amount) {
		return this.moveUp(-amount);
	}

	@Override
	public boolean moveRight(double amount) {
		double x = this.getLocation().getX();
		double dx = amount;
		double newX = x + dx;
		double y = this.getLocation().getY();
		
		boolean withinBounds = 0 < newX && newX < GameWorld.WIDTH;
		if(!withinBounds) return false;
		return this.setLocation(new Point2D(newX, y));
	}
	@Override
	public boolean moveLeft(double amount) {
		return this.moveRight(-amount);
	}
	
	@Override
	public boolean jumpToLocation(Point2D location) {
		return this.setLocation(location);
	}
	
	// Helper Methods
	@Override
	public String toString() {
		return super.toString();
	}
}