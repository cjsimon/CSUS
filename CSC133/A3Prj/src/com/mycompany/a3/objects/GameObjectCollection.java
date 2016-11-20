package com.mycompany.a3.objects;

import java.util.Vector;

public class GameObjectCollection implements ICollection {
    private Vector<GameObject> gameObjects;
    
    public GameObjectCollection() {
        gameObjects = new Vector<GameObject>();
    }

    public GameObject get(int location) {
    	return gameObjects.get(location);
    }
    
    public boolean add(GameObject o) {
        gameObjects.addElement(o);
		return true;
    }
    
    public GameObject remove(int i) {
    	return gameObjects.remove(i);
    }
    
    public int size() {
    	return gameObjects.size();
	}
    
    public IIterable getIterator() {
        return new GameObjectIterator();
    }
    
    private class GameObjectIterator implements IIterable {
        // The current index or size of the collection
    	private int index;
        
        public GameObjectIterator() {
            index = -1;
        }
        
        public boolean hasNext() {
            if(gameObjects.size() <= 0) return false;
            if(index == gameObjects.size() - 1) return false;
            return true;
        }
        
        public GameObject getNext() {
        	// Get the next GameObject and increment the index
        	return(gameObjects.elementAt(++index));
        }
        
        public GameObject remove() {
            // Remove the GameObject at the current index
        	return gameObjects.remove(index);
        }
        
        public int getIndex() {
            return index;
        }
        
        public GameObject get(int location) {
            return gameObjects.get(location);
        }
    }
}
