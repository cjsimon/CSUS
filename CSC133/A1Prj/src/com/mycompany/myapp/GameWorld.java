package com.mycompany.myapp;

import java.util.Vector;

public class GameWorld {
	// The origin of the "world" (location (0,0)) is at the lower left hand corner.
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	
	private Vector<GameObject> GameObjects;

	// Constructors
	public GameWorld() {}
	
	public void init() {
		// TODO
		// Create the initial game objects and layout
	}
	
	public void play() {
		// Apply properties to all GameObjects in the world
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
	
	// TODO
	// Additional methods here to manipulate world objects and related game state data
	public void expand() {
		// TODO Auto-generated method stub
		
	}

	public void contract() {
		// TODO Auto-generated method stub
		
	}
}
