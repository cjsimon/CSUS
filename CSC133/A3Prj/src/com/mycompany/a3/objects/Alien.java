package com.mycompany.a3.objects;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Alien extends Opponent {
	// All aliens have a speed which cannot be changed once it is set on instantiation
	private boolean isSpeedSet = false;
	// Attribute Bounds
	// To calculate the speed, use the formula, speed = 5 x constant.
	// For now, we assume that constant is equal to 1.
	private static final int SPEED_CONSTANT = 1;
	private static final int DEFAULT_SPEED  = 5;
	// All objects of the same class have the same initial color
	private static final int DEFAULT_COLOR = ColorUtil.GREEN;
	
	// Constructors
	public Alien(int size, int x, int y, int startWidth, int startHeight, int endWidth, int endHeight, int color, int direction, int speed) {
		super(size, x, y, startWidth, startHeight, endWidth, endHeight, color, direction, speed * SPEED_CONSTANT);
	}
	// Simple Constructor with random location
	public Alien(int startWidth, int startHeight, int endWidth, int endHeight) {
		super(R.nextInt(MIN_SIZE, MAX_SIZE),			 // Size
				startWidth, startHeight,				 // MapView Start Bounds
				endWidth, endHeight,					 // MapView End Bounds
				DEFAULT_COLOR,							 // Color
				R.nextInt(MIN_DIRECTION, MAX_DIRECTION), // Direction
				MIN_SPEED);								 // Speed
	}
	
	@Override
	// The speed of an alien never changes. Only allow it to be initially set
	public boolean setSpeed(int speed) {
		// If the size hasn't been set already, set it. Then prevent it from being set anymore
		if(!isSpeedSet) isSpeedSet = super.setSpeed(speed);
		// Speed is not settable after instantiation. Negate the status indicating that it was set.
		// As to indicate that it was successfully set this one and only time.
		return !isSpeedSet;
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
		
		g.setColor(this.getColor());
		g.drawArc(x, y, size, size, 0, 360);
	}
	
	public void handleCollision(ICollidable other) {
		// TODO Auto-generated method stub
		
	}
	
}
