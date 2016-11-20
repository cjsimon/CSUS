package com.mycompany.a3.objects;

public interface ICollidable {
    // Apply appropriate response algorithms for detecting and handling collision
	public boolean collidesWith(ICollidable other);
	public void handleCollision(ICollidable other);
}
