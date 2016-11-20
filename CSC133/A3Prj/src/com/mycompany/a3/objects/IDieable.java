package com.mycompany.a3.objects;

public interface IDieable {
	// TODO: Switch to Java 8 to use full body methods in Interfaces.
	// 		 Implement accessor for isDead method using boolean dead.
	// boolean dead = false;
	// Conditions to check if the object has died.
	// This will update death status for boolean isDead.
	public boolean checkIsDead();
	// Public accessor method to check the current status of death
	public boolean isDead(); // { return dead; }
}
