package com.mycompany.a2;

import java.util.Vector;

public class GameObjectCollection implements ICollection {
    private Vector<Object> gameObjects;
    
    public GameObjectCollection() {
        gameObjects = new Vector();
    }

    public void add(Object o) {
        gameObjects.addElement(o);
    }
    public boolean remove(Object o) {
        return false;
    }
    public IIterator getIterator() {
        return new GameObjectIterator();
    }
    private class GameObjectIterator implements IIterable {
        private int index;
        
        public GameObjectIterator() {
            index = -1;
        }
        
        public boolean hasNext() {
            if(gameObjects.size() <= 0) return false;
            if(index == gameObjects.size() - 1) return false;
            return true;
        }
        
        public Object getNext() {
            return(gameObjects.elementAt(++index));
        }
        
        public void remove() {
            gameObjects.remove(index);
        }
        
        public int getIndex() {
            return index;
        }
        
        public Object objectAt(int i) {
            return gameObjects.get(i);
        }
    }
}
