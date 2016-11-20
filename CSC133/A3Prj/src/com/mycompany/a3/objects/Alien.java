package com.mycompany.a3.objects;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Alien extends Opponent {
	// Attribute Bounds
	// To calculate the speed, use the formula, speed = 5 x constant.
	// For now, we assume that constant is equal to 1.
	private static final int SPEED_CONSTANT = 1;
	private static final int DEFAULT_SPEED  = 5;
	// All objects of the same class have the same initial color
	private static final int DEFAULT_COLOR = ColorUtil.GREEN;
	
	// Constructors
	public Alien(int size, int x, int y, int width, int height, int color, int direction, int speed) {
		super(size, x, y, width, height, color, direction, speed * SPEED_CONSTANT);
	}
	// Simple Constructor
	public Alien(int x, int y, int width, int height) {
		super(R.nextInt(MIN_SIZE, MAX_SIZE),			 // Speed
				x, y, width, height,					 // Location
				DEFAULT_COLOR,		 					 // Color
				R.nextInt(MIN_DIRECTION, MAX_DIRECTION), // Direction
				DEFAULT_SPEED * SPEED_CONSTANT);		 // Speed
	}
	
	@Override
	// The speed of an alien never changes
	public boolean setSpeed(int speed) {
		return false;
	}
	
	@Override
	public String toString() {
		String s = super.toString() 			  + "\n";
		s += "Speed:     " + this.getSpeed() 	  + "\n";
		s += "Direction: " + this.getDirection();
		return s;
	}
	
	public void draw(Graphics g) {
		int x    = (int)this.getLocation().getX();
		int y    = (int)this.getLocation().getY();
		int size = (int)this.getSize();
		
		//System.out.print("(" + x + ", " + y + ")");
		//System.out.println(" " + size);
		
		g.setColor(this.getColor());
		g.drawArc(x, y, size, size, 0, 360);
	}
	
	public void handleCollision(ICollidable other) {
		// TODO Auto-generated method stub
		
	}
	
}
