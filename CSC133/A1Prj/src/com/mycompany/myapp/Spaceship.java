package com.mycompany.myapp;

//The size attribute of the spaceship which indicates the size of its door is constrained to be a
// positive integer between 50 and 1024 (inclusive), and set to 100 when the object is created.
public class Spaceship extends Rescuer {
	public Spaceship() {
		super.setSize(100);
	}
	
	@Override
	public boolean setSize(int size) {
		boolean withinBounds = (50 <= size && size <= 1024);
		if(withinBounds) this.setSize(size);
		return withinBounds;
	}
}
