package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

public class Spaceship extends Rescuer implements IGuided {
	private static Spaceship instance = new Spaceship(new GameWorld(false));
	
	// Attribute Bounds
	// The size attribute of the spaceship which indicates the size of its door is constrained to be a
	// positive integer between 50 and 1024 (inclusive), and set to 100 when the object is created.
	static final int START_SIZE = 100;
	static final int MIN_SIZE	= 50;
	static final int MAX_SIZE	= 1024;
	// Having a static GameWorld breaks good practice for this singleton class,
	// because it forces the singleton to be bound to a single, parameterized GameWorld.
	// This is bad because many GameWorlds can be instantiated with different parameters
	// and since the singleton class is bound to one of them, it parameterizes the singleton.
	// TODO: Find a better way to get the width and height from a GameWorld without needing
	//       to have a reference to it. Perhaps also make GameWorld a singleton?
	private static GameWorld gw;
	
	// Constructors
	// TODO: This is technically bad practice.
	//       The fact that code for setting a parameter exists
	//       in the singleton indicates that this object shouldn't
	//       really be using the singleton design pattern.
	//       Singletons should have an empty body implementation.
	private Spaceship(GameWorld gw) {
		// TODO: Fix bad practice
		super(gw);
		setSize(START_SIZE);
	}
	// TODO: Fix bad practice
	// We need a way to bind the calling GameWorld to the single Spaceship
	// This additional parameter is a side effect of having GameWorld as an
	// instantiatable class
	public static Spaceship getInstance(GameWorld gw) {
		if(instance != null) {
			// Bind the calling GameWorld instance to the singleton Spaceship.
			// Only bind the instance if it is not already bound to a GameWorld
			// as to prevent another GameWorld instance from "stealing" the 
			// parameters that the Spaceship already has from the current GameWorld.
			if(instance.gw == null) instance.gw = gw; // TODO: Fix bad practice
			return instance;
		}
		return instance = new Spaceship(gw);          // TODO: Fix bad practice
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
		
		boolean withinBounds = 0 < newY && newY < gw.getHeight();
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
		
		boolean withinBounds = 0 < newX && newX < gw.getWidth();
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