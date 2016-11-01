package com.mycompany.a2;

public interface ICollection {
    IIterable getIterator();
    public GameObject get(int location);
    public int        size();
    public boolean    add(GameObject o);
    public GameObject remove(int i);
}