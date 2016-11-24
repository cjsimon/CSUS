package com.mycompany.a3.objects;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class Spaceship extends Rescuer implements IGuided {
	private static Spaceship instance;
	
	/* Attribute Bounds */
	// The size attribute of the spaceship which indicates the size of its door is constrained to be a
	// positive integer between 50 and 250 (inclusive), and set to 100 when the object is created.
	private static final int START_SIZE = 100;
	private static final int MIN_SIZE	= 50;
	private static final int MAX_SIZE	= 250;
	// The spaceship default color is black
	private static final int DEFAULT_COLOR = ColorUtil.BLACK;
	
	// Animation
	// TODO: Since the frameSpeed can't be changed from a child class, a workaround
	// 		 to make the animation slower is to render duplicate frames.
	private String[] spriteSheet = {
		"spaceship0.png", "spaceship0.png", "spaceship0.png", "spaceship0.png",
		"spaceship1.png", "spaceship1.png", "spaceship1.png", "spaceship1.png",
		"spaceship2.png", "spaceship2.png", "spaceship2.png", "spaceship2.png",
		"spaceship3.png", "spaceship3.png", "spaceship3.png", "spaceship3.png",
		"spaceship4.png", "spaceship4.png", "spaceship4.png", "spaceship4.png",
		"spaceship5.png", "spaceship5.png", "spaceship5.png", "spaceship5.png"
	};
	
	/* Constructor */
	private Spaceship(int size, int x, int y, int startWidth, int startHeight, int endWidth, int endHeight, int color) {
		super(size, x, y, startWidth, startHeight, endWidth, endHeight, color);
		super.initAnimation(spriteSheet);
	}
	/* Simple Constructor */
	private Spaceship(int startWidth, int startHeight, int endWidth, int endHeight) {
		super(START_SIZE,				 // Size
				startWidth, startHeight, // MapView Start Bounds
				endWidth, endHeight,	 // MapView End Bounds
				DEFAULT_COLOR);			 // Color
		super.initAnimation(spriteSheet);
	}
	// Get the singleton instance by supplying all parameters
	public static Spaceship getInstance(int size, int x, int y, int startWidth, int startHeight, int endWidth, int endHeight, int color) {
		if(instance == null) {
			return instance = new Spaceship(size, x, y, startWidth, startHeight, endWidth, endHeight, color);
		}
		return instance;
	}
	// Simple getInstance with unspecified location
	public static Spaceship getInstance(int startWidth, int startHeight, int endWidth, int endHeight) {
		if(instance == null) {
			return instance = new Spaceship(startWidth, startHeight, endWidth, endHeight);
		}
		return instance;
	}
	
	/* Mutators */
	@Override
	public boolean setSize(int size) {
		boolean withinBounds = (MIN_SIZE <= size && size <= MAX_SIZE);
		if(withinBounds) super.setSize(size);
		return withinBounds;
	}

	/* Actions */
	@Override
	public boolean moveUp(double amount) {
		double y = this.getLocation().getY();
		double dy = amount;
		double newY = y + dy;
		double x = this.getLocation().getX();
		
		boolean withinBounds = super.getMinYLocation() < newY && newY < super.getMaxYLocation();
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
		
		boolean withinBounds = super.getMinXLocation() < newX && newX < super.getMaxXLocation();
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
		int size   = super.getSize();
		byte alpha = (byte)200;
		
		// Draw the sprite if it is set, otherwise draw a shape in it's place
		if(this.sprite != null) {
			// Modify the sprite so that the color black is made fully transparent.
			// This removes the boarder around each sprite.
			// TODO: Modifying the sprite every frame before it gets rendered could possibly be expensive.
			//		 A better approach might be to load a static version of all the frames for each of the
			//		 instances to use, that way they wouldn't have to be reloaded and recreated every frame
			//		 for each object.
			sprite = sprite.modifyAlpha((byte)255, ColorUtil.BLACK);
			g.drawImage(this.sprite, x, y, size, size);
		} else {
			g.setColor(this.getColor());
			// The requirement states that a rectangle outline should represent the ship;
			// however, this is too difficult to see due to the backgrounds used in the game.
			// A semitransparent filled rectangle is rendered instead.
	    	//g.drawRect(x, y, size, size, 5);
	    	g.fillRect(x, y, size, size, alpha);
		}
	}
	
	public void handleCollision(ICollidable other) {
		// TODO Auto-generated method stub
		
	}
	
	/* Helper Methods */
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	protected String[] getSpriteSheet() {
		return spriteSheet;
	}
}