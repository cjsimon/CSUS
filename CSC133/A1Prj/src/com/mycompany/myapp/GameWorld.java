package com.mycompany.myapp;

import java.util.AbstractList;
import java.util.StringTokenizer;
import java.util.Vector;

public class GameWorld {
	// Helper Objects
	static final Random R = Random.getInstance();
	
	// Using a static reference to the spaceship we can reference it without having to search for it in the GameObjects
	private Spaceship spaceship;

	// Attributes
	// The origin of the "world" (location (0,0)) is at the lower left hand corner.
	public static final int WIDTH  = 1024;
	public static final int HEIGHT = 768;
	// The score of the game
	private int score = 0;
	
	private static AbstractList<GameObject> GameObjects = new Vector<GameObject>();
	
	// Constructors
	public GameWorld() {}
	
	public void init() {
		// Creates the initial game objects and layout
		int initialAstronauts = 4;
		int initialAliens	  = 3;
		
		spaceship = Spaceship.getInstance();
		this.addObject(spaceship);
		
		for(int a = 0; a < initialAstronauts; a++) {
			this.addObject(new Astronaut());
		}
		for(int a = 0; a < initialAliens; a++) {
			this.addObject(new Alien());
		}
		
	}
	
	/**
	 * Update function that runs on every iteration of the game
	 */
	public void update() {
		// Apply properties to all GameObjects in the world
		// @TODO As per the assignment specification, create a custom iterator class
		// @TODO to loop through each object. See moveTo(String filter) for duplicate code
		if(GameObjects != null && !GameObjects.isEmpty()) {
			for(Object obj : GameObjects) {
				// Move all objects that can move.
				// Some game objects are moving, meaning that they provide an interface that allows other
				// objects to tell them to move. Telling a moving object to move() causes the object to update
				// its location.
				if(obj instanceof IMovable) {
					IMovable mObj = (IMovable)obj;
					mObj.move();
				}
			}
		}
	}
	
	/**
	 * Adds a new GameObject to the world
	 * @return boolean
	 */
	public final boolean addObject(GameObject o) {
		return GameObjects.add(o);
	}
	
	// MoveTo another destination GameObject
	public final boolean moveTo(GameObject o, GameObject destination) {
		// Exit prematurely if the destination object is null
		if(destination == null) return false;
		
		// Set the location of GameObject o to the location of the destination object
		o.setLocation(destination.getLocation());
		// o was successfully moved
		return true;
	}
	// MoveTo using GameObject filter
	public final boolean moveTo(GameObject o, String filter) {
		// Generate a list of the candidate objects according to the given filter
		AbstractList<GameObject> foundObjects = GameWorld.find(filter);
		
		// Exit prematurely if no objects are found
		if(foundObjects == null || foundObjects.size() == 0) return false;
		
		// Set the location of GameObject o to the location of the randomly chosen object
		int randomIndex = R.nextInt(0, foundObjects.size());
		GameObject randomObject = ((AbstractList<GameObject>)foundObjects).get(randomIndex);
		o.setLocation(randomObject.getLocation());
		// o was successfully moved
		return true;
	}

	// Find multiple objects given a GameObject filter
	// @todo: Create filter parser to create more advanced queries with multiple GameObject type support
	// @todo: Abstract code by using a custom iterable class, as per assignment request	
	// @link: http://stackoverflow.com/q/12203003/2104168
	public static final AbstractList<GameObject> find(String filter) {
		// Find and return multiple GamoeObjects from the list if applicable
		return GameWorld.find(filter, true);
	}
	public static final GameObject findOne(String filter) {
		// Find and return one object from the list
		return ((AbstractList<GameObject>)GameWorld.find(filter, false)).get(0);
	}
	
	private static final AbstractList<GameObject> find(String filter, boolean multiple) {
		AbstractList<GameObject> foundObjects = new Vector<GameObject>();
		
		if(GameObjects != null && !GameObjects.isEmpty()) {	
			// Iterate through each object
			for(GameObject obj : GameObjects) {
				// Check for each filter in each object
				for(String objectFilter : split(filter, "|")) {
					if(obj.getType().equals(objectFilter)) {
						foundObjects.add(obj);
						if(!multiple) return foundObjects;
					}
				}
			}
		}
		// No GameObject was found
		return null;
	}
	
	public void moveSpaceshipToAstronaut() {
		// Assuming that we only have one and only one spaceship,
		// Transfer that spaceship to the location of a randomly selected astronaut
		this.moveTo(spaceship, "Astronaut");
	}

	public void moveSpaceshipToAlien() {
		// Transfer that spaceship to the location of a randomly selected alien
		this.moveTo(spaceship, "Alien");
	}

	public void expand(int size) {
		// Increase the size of the spaceship
		spaceship.setSize(spaceship.getSize() + size);
	}

	public void contract(int size) {
		// Shrink the size of the spaceship
		spaceship.setSize(spaceship.getSize() - size);
	}

	public void openDoor() {
		// TODO Auto-generated method stub
		
	}

	public void colAlien() {
		// TODO Auto-generated method stub
		
	}

	public void colAstronautAlien() {
		// TODO Auto-generated method stub
		
	}

	public void printObjects() {
		// TODO Auto-generated method stub
		
	}

	public void printMap() {
		// TODO Auto-generated method stub
	}
	
	public void moveSpaceshipUp(int amount) {
		spaceship.moveUp(amount);
	}

	public void moveSpaceshipDown(int amount) {
		spaceship.moveDown(amount);
	}

	public void moveSpaceshipLeft(int amount) {
		spaceship.moveLeft(amount);
	}

	public void moveSpaceshipRight(int amount) {
		spaceship.moveRight(amount);
	}
	
	// Helper Methods
	/**
	 * String.split() doesn't seem to be defined in some versions of J2ME
	 * @see http://stackoverflow.com/q/2724745/2104168
	 * @param str
	 * @param delim
	 * @return String[]
	 */
	private final static String[] split(String str, String delim) {
        StringTokenizer stringTokenizer = new StringTokenizer( str, delim );
        String[] strArr = new String[stringTokenizer.countTokens()];
        int i = 0;
        while( stringTokenizer.hasMoreTokens() ) {
            strArr[i] = stringTokenizer.nextToken();
        }
        return strArr;
    }
}
