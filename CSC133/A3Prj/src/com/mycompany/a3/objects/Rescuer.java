package com.mycompany.a3.objects;

import com.codename1.ui.geom.Point2D;

public abstract class Rescuer extends GameObject implements IGuided {
	public Rescuer(int size, int x, int y, int startWidth, int startHeight, int endWidth, int endHeight, int color) {
		super(size, x, y, startWidth, startHeight, endWidth, endHeight, color);
	}
	public Rescuer(int size, int startWidth, int startHeight, int endWidth, int endHeight, int color) {
		super(size, startWidth, startHeight, endWidth, endHeight, color);
	}
	
	public abstract boolean moveUp(double amount);
	public abstract boolean moveDown(double amount);
	public abstract boolean moveLeft(double amount);
	public abstract boolean moveRight(double amount);
	public abstract boolean jumpToLocation(Point2D location);
}
