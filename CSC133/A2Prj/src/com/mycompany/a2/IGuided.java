package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

/**
 * Some game objects are guided, meaning that they provide an interface that allows other
 * objects to tell them to move left, right, up, down or to jump to a location of a randomly
 * selected astronaut or alien.
 * 
 * The interface must declare five separate methods:
 * moveLeft, moveRight, moveUp, moveDown, and jumpToLocation.
 * All rescuers are guided and they are all guided the same way.
 */
public interface IGuided {
	public boolean moveUp(double amount);
	public boolean moveDown(double amount);
	public boolean moveLeft(double amount);
	public boolean moveRight(double amount);
	public boolean jumpToLocation(Point2D location);
}