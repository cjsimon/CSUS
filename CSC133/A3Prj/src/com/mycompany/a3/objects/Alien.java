package com.mycompany.a3.objects;

import java.io.IOException;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.util.UITimer;

public class Alien extends Opponent {
	/* Attributes */
	// All aliens have a speed which cannot be changed once it is set on instantiation
	private boolean isSpeedSet = false;
	// Attribute Bounds
	// To calculate the speed, use the formula, speed = 5 x constant.
	// For now, we assume that constant is equal to 1.
	private static final int SPEED_CONSTANT = 1;
	private static final int DEFAULT_SPEED  = 5;
	// All objects of the same class have the same initial color
	private static final int DEFAULT_COLOR = ColorUtil.GREEN;
    
	/* Properties */
	// Animation
	private String[] spriteSheet = {
		"alien0.png",
		"alien1.png",
		"alien2.png",
		"alien3.png",
		"alien4.png",
		"alien5.png"
	};
	
	/* Constructors */
	public Alien(int size, int x, int y, int startWidth, int startHeight, int endWidth, int endHeight, int color, int direction, int speed) {
		super(size, x, y, startWidth, startHeight, endWidth, endHeight, color, direction, speed * SPEED_CONSTANT);
		super.initAnimation(spriteSheet);
	}
	/* Simple Constructor with random location */
	public Alien(int startWidth, int startHeight, int endWidth, int endHeight) {
		super(R.nextInt(MIN_SIZE, MAX_SIZE),			 // Size
				startWidth, startHeight,				 // MapView Start Bounds
				endWidth, endHeight,					 // MapView End Bounds
				DEFAULT_COLOR,							 // Color
				R.nextInt(MIN_DIRECTION, MAX_DIRECTION), // Direction
				R.nextInt(MIN_SPEED, MAX_SPEED));		 // Speed
		super.initAnimation(spriteSheet);
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
		String s = super.toString() + "\n";
		return s;
	}
	
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
			g.drawArc(x, y, size, size, 0, 360);
		}
	}
	
	public void handleCollision(ICollidable other) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected String[] getSpriteSheet() {
		return spriteSheet;
	}
}
