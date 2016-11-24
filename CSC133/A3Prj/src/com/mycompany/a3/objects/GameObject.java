package com.mycompany.a3.objects;

import com.codename1.maps.BoundingBox;
import com.codename1.maps.Coord;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.codename1.ui.util.UITimer;
import com.mycompany.a3.Random;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.codename1.charts.util.ColorUtil;

/**
 * GameObject that defines all objects drawn on the GameWorld
 * 
 * Animations are incorporated by extending the TimerTask, which
 * implements a {@link #run()} method used to handle switching between
 * animation frames in the sprite sheet.
 * @see java.util.TimerTask#run()
 * 
 * In the future, if any other classes need to be extended for more functionality,
 * they can extend the TimerTask class and have the GameObject be an extension of
 * that new parent class instead.
 * 
 * Later we may add other kinds of game objects to the game,
 * such as robots that are helpers that aid both astronauts and aliens.
 * These new objects may be only moving, only guided, both moving and guided, or neither moving nor guided.
 * 
 */
public abstract class GameObject extends TimerTask implements IDrawable, ICollidable {
	/* Helper attributes */
	static final Random R = Random.getInstance();
	
	/* Attributes */
	// The type of GameObject used for filtering search queries
	@SuppressWarnings("deprecation")
	private final String type = this.getClass().getSimpleName().toString();
	private int size;
	// The point (X, Y) is the center of the object.
	// The location is protected, because a child class can modify how the location is to be set.
	protected Point2D location;
	private int color;
	BoundingBox collisionMask;
	// Attribute Bounds
	// All game objects have a location, defined by floating point non-negative values X and Y,
	// within the range 0.0 to GameWorld.width and 0.0 to GameWorld.height respectively.
	private double minXLocation;
	private double minYLocation;
	private double maxXLocation;
	private double maxYLocation;
	// The default color
	static final int DEFAULT_COLOR = ColorUtil.BLACK;
	
	/* Properties */
	// TODO: All properties should eventually go under separate extendible classes
	// 		 These properties are unrelated, and do not change how an object should
	//		 interact within the Game, meaning that these are extra, extendable features
	// 		 that could be applied to objects. These include sound, animation, rendering
	//		 and so on.
	//
	// Animation
	// The current sprite being drawn from the spritesheet
    protected Image sprite;
    // The spritesheet containing all sprites for the animation
    // To be populated in the child class.
    // Currently, if sprites are populated into the spriteSheet,
    // the animation is set to be initialized and to play for that object.
    //protected String[] spriteSheet;
    //private String[] spriteSheet;
    // Timer for changing between sprites
    Timer animationTimer = new Timer();
	// The speed at which the animation plays, or moves from frame to frame.
    // TODO: Ideally, this attribute would be made override-able
    //		 using an accessor and mutator method included in a
    // 		 separate IAnimatable or extendible Animator class.
    private int frameSpeed = 50;
    // The current frame being drawn
    int frameIndex = 0;
    
    /**
     * Constructor with all object specifications
     * @param size
     * @param x
     * @param y
     * @param startWidth
     * @param startHeight
     * @param endWidth
     * @param endHeight
     * @param color
     */
	public GameObject(int size, int x, int y, int startWidth, int startHeight, int endWidth, int endHeight, int color) {
		// Location Bounds
		// The location of the object needs to be set before it's size can be calculated
		if(!this.setLocationBounds(startWidth, startHeight, endWidth, endWidth)) {
			System.err.println("Could not set location bounds!");
		}
		// Location
		if(!this.setLocation(new Point2D(startWidth+x, startHeight+y))) {
			System.err.println("Could not set initial location!");
		}
		// Size
		if(!this.setSize(size)) {
			System.err.println("Could not set initial size!");
		}
		// Color
		if(!this.setColor(color)) {
			System.err.println("Could not set initial color!");
		}
		
		// Initialize the non-attribute properties associated with the GameObject
		//if(initProperties()) {
			//System.err.println("Some properties could not be set!");
		//}
	}
	/**
	 * Simple Constructor with random location
	 * @param size
	 * @param startWidth
	 * @param startHeight
	 * @param endWidth
	 * @param endHeight
	 * @param color
	 */
	public GameObject(int size, int startWidth, int startHeight, int endWidth, int endHeight, int color) {
		// Location Bounds
		if(!this.setLocationBounds(startWidth, startHeight, endWidth, endWidth)) {
			System.err.println("Could not set location bounds!");
		}
		// Location
		// Create a random location within the bounds since one wasn't specified
		Point2D randomLocation = this.randomLocation();
		int x = (int)randomLocation.getX();
		int y = (int)randomLocation.getY();
		if(!this.setLocation(new Point2D(x, y))) {
			System.err.println("Could not set initial location!");
		}
		// Size
		if(!this.setSize(size)) {
			System.err.println("Could not set initial size!");
		}
		// Color
		if(!this.setColor(color)) {
			System.err.println("Could not set initial color!");
		}
		
		// Properties
		//if(!initProperties()) {
			//System.err.println("Some properties could not be set!");
		//}
	}
	
	/* Accessors */
	public String getType() {
		return this.type;
	}
	public int getSize() {
		return this.size;
	}
	public Point2D getLocation() {
		return this.location;
	}
	public int getColor() {
		return this.color;
	}
	public BoundingBox getCollisionMask() {
		return collisionMask;
	}
	public double getMinXLocation() {
		return minXLocation;
	}
	public double getMinYLocation() {
		return minYLocation;
	}
	public double getMaxXLocation() {
		return maxXLocation;
	}
	public double getMaxYLocation() {
		return maxYLocation;
	}
	/* Child Accessors */
	/**
	 * Use the protected getSpriteSheet() method to have this parent call the child's getSpriteSheet() method.
	 * If the child object does not have it's spiteSheet set, this method should return null.
	 * @see com.mycompany.a3.objects#getSpriteSheet()
	 * @return String[] The child spriteSheet
	 */
	protected abstract String[] getSpriteSheet();
	
	/* Mutators */
	public boolean setSize(int size) {
		this.size = size;
		// Recalculate the bounding box according to the new size
		calculateCollisionMask();
		return true;
	}
	public boolean setLocationBounds(double minX, double minY, double maxX, double maxY) {
		boolean withinBounds = (maxX - minX > 0) && (maxY - minY > 0);
		if(withinBounds) {
			this.minXLocation = minX;
			this.minYLocation = minY;
			this.maxXLocation = maxX;
			this.maxYLocation = maxY;
		}
		return withinBounds;
	}
	/**
	 * All GameObjects provide the ability for external code to obtain and change their location.
	 * @param location The new location of the GameObject
	 * @return The status of setting the new location
	 */
	public boolean setLocation(Point2D location) {
		double minXLocation = this.getMinXLocation();
		double minYLocation = this.getMinYLocation();
		double maxXLocation = this.getMaxXLocation();
		double maxYLocation = this.getMaxYLocation();
		boolean withinBounds = (
				(minXLocation <= location.getX() && location.getX() <= maxXLocation)
				&& (minYLocation <= location.getY() && location.getY() <= maxYLocation));
		if(withinBounds) this.location = location;
		return withinBounds;
	}
	public boolean setColor(int color) {
		this.color = color;
		return true;
	}
	
	// Helper Methods
	/**
	 * Calculate a random location within the object bounds
	 * @return Point2D
	 */
	private Point2D randomLocation() {
		double minXLocation = this.getMinXLocation();
		double minYLocation = this.getMinYLocation();
		double maxXLocation = this.getMaxXLocation();
		double maxYLocation = this.getMaxYLocation();
		return new Point2D(
				R.nextDouble(minXLocation, maxXLocation),
				R.nextDouble(minYLocation, maxYLocation));
	}
	
	/**
	 * Calculate the bounding box of the object according to it's current size
	 * @return BoundingBox
	 */
	private boolean calculateCollisionMask() {
		double size = this.getSize();
		double diagonalSize = size/2;
		
		Point2D swPoint = new Point2D(location.getX() - diagonalSize, location.getY() - diagonalSize);
		Point2D nePoint = new Point2D(location.getX() + diagonalSize, location.getY() + diagonalSize);
		
		//		                    logitude         latitude
		Coord swCoord = new Coord(swPoint.getY(), swPoint.getX());	
		Coord neCoord = new Coord(nePoint.getY(), nePoint.getX());
		
		collisionMask = new BoundingBox(swCoord, neCoord);
		return true;
	}
	
	/**
	 * Initialize the properties that aren't attributes of the GameObject.
	 * These properties are comprised up of the attributes that do not
	 * modify how the GameObject interacts in the Game itself.
	 * 
	 * In the future, other properties that need to be initialized will be added here.
	 * 
	 * @TODO Create an abstraction class to hold these separate properties.
	 * @return boolean The status of all the properties being initialized
	 */
	// The issue with this method is that since 
	/*
	private boolean initProperties() {
		// Get the spriteSheet set by the child object
		// @see com.mycompany.a3.objects.Alien#getSpriteSheet()
		String[] spriteSheet = this.getSpriteSheet();
		// If the spriteSheet has sprites, initialize the animator and use the sprites
		return initAnimation(spriteSheet); // Animation is the only property at this time.
	}
	*/
	
	/**
	 * Initialize the animation of sprites if any sprites exist in the spriteSheet.
	 * This is to be invoked by the child that wants to initialize animation
	 * @param String[] The spriteSheet from the child being initialized
	 * @return boolean The status of initializing the animation
	 */
	protected boolean initAnimation(String[] spriteSheet) {
		// Only initialize the animation if sprites exist in the spritesheet.
		// Get the child value of the spritesheet
		if(spriteSheet == null || spriteSheet.length <= 0) return false;
		// Schedule the animation to start now and to tick every frame
		animationTimer.scheduleAtFixedRate(this, 0, frameSpeed);
		return true;
	}
	
	/**
	 * Run method implemented from TimerTask used to switch between animation frames in the spriteSheet.
	 * 
	 * Run will only be invoked if the child has chosen to initialize animation.
	 * This is because the timer will not be set until it is initialized by the child,
	 * which uses it's parent's {@link #initAnimation()} method to activate animation.
	 * Only then will the 
	 * 
	 * The spriteSheet used for animation is retrieved from the child, through the protected
	 * {@link #getSpriteSheet()} method. If the child object does not have it's spiteSheet set,
	 * it should return null.
	 * 
	 * If the child spriteSheet is null, the animationTimer will not be set to go off; however,
	 * as a failsafe, or in the event that the child spriteSheet is modified after it is initialized,
	 * a check is made to see if the spriteSheet is null before loading an image. If it is, no attempt
	 * is made to load an image.
	 * 
	 * Further, if the sprite cannot be loaded, it will be null. The {@link #draw()} method implements
	 * a check to see if the sprite was set, and doesn't display the sprite if it isn't set for that frame.
	 * 
	 * @see java.util.TimerTask#run()
	 * @see com.mycompany.a3.objects.GameObject#getSpriteSheet()
	 * @see com.mycompany.a3.objects.GameObject#draw()
	 */
	public void run() {
		// Get the child's spriteSheet
		String[] spriteSheet = this.getSpriteSheet();
        frameIndex %= spriteSheet.length;
        // Because the draw call is being run on a different thread,
        // it is possible that the null image will be drawn before
        // the next image is assigned to the sprite in the next line below
        //sprite = null;
        try {
			sprite = Image.createImage("/" + spriteSheet[frameIndex++]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  Check if this object is colliding with another object
	 *  All GameObjects use circular collider checking
	 *  @param ICollidable The other object colliding
	 *  @return boolean Are the objects colliding
	 */
	public boolean collidesWith(ICollidable other) {
		// Find Centers
		double thisX = location.getX();
		double thisY = location.getY();
		double thisR = this.getSize()/2;
	    double thisCenterX = thisX + thisR;
	    double thisCenterY = thisY + thisR;
	    // Other Center
		double otherX = location.getX();
		double otherY = location.getY();
		double otherR = ((GameObject) other).getSize()/2;
	    double otherCenterX = otherX + otherR;
	    double otherCenterY = otherY + otherR;
	    
	    // Get the distance between the two obj centers
	    // Keep the centers as squared numbers,
	    // to avoid having to take their square roots
	    double dx = thisCenterX - otherCenterX;
	    double dy = thisCenterY - otherCenterY;
	    double centerDistance = (dx*dx + dy*dy);
	    
	    // Find the square of sum of radii
	    double radiiSqr = (thisR*thisR + 2*thisR*otherR + otherR*otherR);
    
	    return (centerDistance <= radiiSqr);
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Point2D location = this.getLocation();
		double x = Math.round(location.getX());
		double y = Math.round(location.getY());
		double sW = this.minXLocation;
		double sH = this.minYLocation;
		double eW = this.maxXLocation;
		double eH = this.maxYLocation;
		
		String s = "";
		s += "Name:      " + this.getType() 		     + "\n";
		s += "Location:  " + "(" + x   + ", " + y  + ")" + "\n";
		s += "Start W/H: " + "(" + sW  + ", " + sH + ")" + "\n";
		s += "End   W/H: " + "(" + eW  + ", " + eH + ")" + "\n";
		s += "Size:      " + this.getSize()			     + "\n";
		s += "Color:     " + this.getColor();
		return s;
	}
}