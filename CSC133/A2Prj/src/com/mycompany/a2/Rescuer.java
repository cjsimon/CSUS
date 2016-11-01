package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

public abstract class Rescuer extends GameObject implements IGuided {
	public Rescuer(GameWorld gw) {
		super(gw);
	}
	public Rescuer(int size, GameWorld gw) {
		super(size, gw);
	}
	public abstract boolean moveUp(double amount);
	public abstract boolean moveDown(double amount);
	public abstract boolean moveLeft(double amount);
	public abstract boolean moveRight(double amount);
	public abstract boolean jumpToLocation(Point2D location);
}
