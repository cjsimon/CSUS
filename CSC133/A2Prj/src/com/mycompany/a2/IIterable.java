package com.mycompany.a2;

public interface IIterable {
    public boolean     hasNext();
    public GameObject  getNext();
    public int         getIndex();
    public GameObject  get(int location);
    public GameObject  remove();
}