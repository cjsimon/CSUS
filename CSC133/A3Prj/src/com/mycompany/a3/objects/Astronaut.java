package com.mycompany.a3.objects;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.mycompany.a3.sound.Sound;
import com.mycompany.a3.sound.Sound;

public class Astronaut extends Opponent {
	// Properties
	// Create a new sound instance for each object.
	// This is an expensive way to allow each object
	// to be able to emit its own sound so that the
	// same sample can be played overlapping.
	Sound sound = new Sound("astronaut.wav");
	
	// Attributes
	private int health;
	private int color = ColorUtil.WHITE;
	private boolean dead = false;
	// Attribute Bounds
	// The health of the astronaut starts at 5
	static final int DEFAULT_HEALTH = 5;
	// To calculate the speed, use the formula, speed = health x constant.
	// For now, we assume that constant is equal to 1.
	static final int SPEED_CONSTANT = 1;
	
	// Constructors
	public Astronaut(int size, int x, int y, int startWidth, int startHeight, int endWidth, int endHeight, int color, int direction, int speed) {
		super(size, x, y, startWidth, startHeight, endWidth, endHeight, color, direction, speed);
		this.setHealth(DEFAULT_HEALTH);
	}
	// Simple Constructor with random location
	public Astronaut(int startWidth, int startHeight, int endWidth, int endHeight) {
		super(R.nextInt(MIN_SIZE, MAX_SIZE),			 // Size
				startWidth, startHeight,				 // MapView Start Bounds
				endWidth, endHeight,					 // MapView End Bounds
				DEFAULT_COLOR,							 // Color
				R.nextInt(MIN_DIRECTION, MAX_DIRECTION), // Direction
				R.nextInt(MIN_SPEED, MAX_SPEED));		 // Speed
		this.setHealth(DEFAULT_HEALTH);					 // Health
	}

	
	// Accessors
	public int getHealth() {
		return health;
	}
	public boolean isDead() {
		return dead;
	}
	
	// Mutators
	public boolean setHealth(int health) {
		// The health of the astronaut is in the range 0-5
		boolean withinBounds = 0 < health && health < 5;
		if(!withinBounds) return false;
		this.health = health;
		// Speed is dependent on health. Reset the speed now that the health has changed
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
		
		// Is the astronaut now dead?
		this.checkIsDead();
		
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
	private boolean checkIsDead() {
		return this.dead = (health <= 0);
	}
	
	// Helper Methods
	@Override
	public String toString() {
		String s = super.toString() + "\n";
		s += "Health:    " + this.getHealth();
		return s;
	}
	
	/**
	 * @TODO Use fillTriangle / drawPolygon
	 * @link https://www.codenameone.com/javadoc/com/codename1/ui/Graphics.html#fillTriangle-int-int-int-int-int-int-
	 */
	public void draw(Graphics g) {
		
	}
	
	public void handleCollision(ICollidable other) {
		if(((GameObject)other).getType().equals("Alien")) {
			// The astronaut was hit
			//hit();
			// Play the hit sound
			//if(!sound.play()) System.err.print("Hit cannot be played!");
		}
	}
	public void run() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected String[] getSpriteSheet() {
		// TODO Auto-generated method stub
		return null;
	}
}
