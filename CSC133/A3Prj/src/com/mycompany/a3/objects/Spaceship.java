package com.mycompany.a3.objects;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class Spaceship extends Rescuer implements IGuided {
	private static Spaceship instance;
	
	// Attribute Bounds
	// The size attribute of the spaceship which indicates the size of its door is constrained to be a
	// positive integer between 50 and 1024 (inclusive), and set to 100 when the object is created.
	private static final int START_SIZE = 100;
	private static final int MIN_SIZE	= 50;
	private static final int MAX_SIZE	= 1024;
	// The spaceship default color is black
	private static final int DEFAULT_COLOR = ColorUtil.BLACK;
	
	private static int x;
	private static int y;
	private static int w;
	private static int h;
	
	// Constructor
	private Spaceship(int size, int x, int y, int width, int height, int color) {
		super(size, x, y, width, height, color);
		Spaceship.x = x;
		Spaceship.y = y;
		Spaceship.w = width;
		Spaceship.h = height;
	}
	// Simple Constructor
	private Spaceship(int x, int y, int width, int height) {
		super(START_SIZE, x, y, width, height, DEFAULT_COLOR);
		Spaceship.x = x;
		Spaceship.y = y;
		Spaceship.w = width;
		Spaceship.h = height;
	}
	
	@SuppressWarnings("static-access")
	public static Spaceship getInstance(int size, int x, int y, int width, int height, int color) {
		if(instance == null) {
			return instance = new Spaceship(size, x, y, width, height, color);
		}
		return instance;
	}
	public static Spaceship getInstance(int x, int y, int width, int height) {
		return getInstance(START_SIZE, x, y, width, height, DEFAULT_COLOR);
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
		
		boolean withinBounds = 0 < newY && newY < y + h;
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
		
		boolean withinBounds = 0 < newX && newX < x + w;
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
	
	public void draw(Graphics g) {
		int x      = (int)this.getLocation().getX();
		int y      = (int)this.getLocation().getY();
		int width  = Spaceship.w;
		int height = Spaceship.h;
		int size   = super.getSize();
		
		System.out.println("Spaceship:");
		System.out.println("X, Y:     (" + Spaceship.x + ", " + Spaceship.y + ")");
		System.out.println("Location: (" + x + ", " + y + ")");
		System.out.println("Wdth/Hgt: (" + width + ", " + height + ")");
		System.out.println("Size    : " + size);
		System.out.println();
		
		g.setColor(DEFAULT_COLOR);
    	g.drawRect(x+w, y+h, size, size);
	}
	
	public void handleCollision(ICollidable other) {
		// TODO Auto-generated method stub
		
	}
	
	// Helper Methods
	@Override
	public String toString() {
		return super.toString();
	}
}