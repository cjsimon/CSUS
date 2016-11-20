package com.mycompany.a3.objects;

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;

/** 
 * This interface defines the services (methods) provided 
 * by an object which is Selectable on the screen
 */
public interface ISelectable {
	// Mark an object as "selected" or not
	public void setSelected(boolean isSelected);
	
	// Check whether the object is selected or not
	public boolean isSelected();
	
	// Determine if a pointer is "in" an object
	// pPtrRelPrnt is pointer position relative to the parent origin
	// pCmpRelPrnt is the component position relative to the parent origin
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt);
	
	// Draw the object that knows about drawing
	// different ways depending on if its selected or not
	public void draw(Graphics g, Point pCmpRelPrnt);
}