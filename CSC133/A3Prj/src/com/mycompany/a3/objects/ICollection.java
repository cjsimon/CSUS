package com.mycompany.a3.objects;

public interface ICollection {
    IIterable getIterator();
    public GameObject get(int location);
    public int        size();
    public boolean    add(GameObject o);
    public GameObject remove(int i);
}