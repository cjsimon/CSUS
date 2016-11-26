package com.mycompany.a3.objects;

import java.io.IOException;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.util.UITimer;
import com.mycompany.a3.sound.Sound;

public class Astronaut extends Opponent {
	/* Attributes */
	private int health;
	private int color = ColorUtil.WHITE;
	private boolean dead = false;
	// Attribute Bounds
	// The health of the astronaut starts at 5
	static final int DEFAULT_HEALTH = 5;
	// To calculate the speed, use the formula, speed = health x constant.
	// For now, we assume that constant is equal to 1.
	static final int SPEED_CONSTANT = 1;
	
	/* Properties */
	// Create a new sound instance for each object.
	// This is an expensive way to allow each object
	// to be able to emit its own sound so that the
	// same sample can be played overlapping.
	//
	// The assignment requires that one sound be
	// created in the gameworld.
	//Sound sound = new Sound("astronaut.wav");
	
	// Animation
	private String[] spriteSheet = {
		"astronaut_01.png",
		"astronaut_02.png",
		"astronaut_03.png",
		"astronaut_04.png",
		"astronaut_05.png",
		"astronaut_06.png",
		"astronaut_07.png",
		"astronaut_08.png",
		"astronaut_09.png",
		"astronaut_10.png",
		"astronaut_11.png",
		"astronaut_12.png"
	};
	
	/* Constructors */
	public Astronaut(int size, int x, int y, int startWidth, int startHeight, int endWidth, int endHeight, int color, int direction, int speed) {
		super(size, x, y, startWidth, startHeight, endWidth, endHeight, color, direction, speed);
		this.setHealth(DEFAULT_HEALTH);
	}
	/* Simple Constructor with random location */
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
	 * @return boolean
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
		int x    = (int)this.getLocation().getX();
		int y    = (int)this.getLocation().getY();
		int size = (int)this.getSize();
		
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
			g.fillTriangle(x, y, size, size, size, size);
		}
	}
	
	/**
	 * Heal the astronaut
	 */
	public boolean heal() {
		// Don't heal above the default (max) health.
		if(this.getHealth() > DEFAULT_HEALTH) return false;
		
		// Change the color
		int currentColor = this.getColor();
		// Get the existing color and decrease the red component
		int newColor = ColorUtil.rgb(
				ColorUtil.red(currentColor)   - 20,
				ColorUtil.green(currentColor) + 0,
				ColorUtil.blue(currentColor)) + 0;
		this.setColor(newColor);
		
		// Increase health by one
		return this.setHealth(this.getHealth() + 1);
	}
	
	public void handleCollision(ICollidable other) {
		if(((GameObject)other).getType().equals("Alien")) {
			// The astronaut was hit
			hit();
			// Play the hit sound
			//if(!sound.play()) System.err.print("Hit cannot be played!");
		}
	}
	
	@Override
	protected String[] getSpriteSheet() {
		return spriteSheet;
	}
}
