package com.mycompany.a3;

import java.util.Observer;
import java.util.Observable;
import com.codename1.ui.plaf.Border;
import com.mycompany.a3.objects.GameObject;
import com.mycompany.a3.objects.GameObjectCollection;
import com.mycompany.a3.objects.IDrawable;
import com.mycompany.a3.objects.IIterable;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;

public class MapView extends Container implements Observer {
    private GameWorld gw;
    private GameObjectCollection GameObjects;
    private Container mvContainer;
    private Point point;
    
    public MapView(GameWorld gw) {
    	//this.setLayout(new BorderLayout(CENTER));
    	this.setLayout(new FlowLayout());
    	this.getAllStyles().setBgTransparency(255);
        this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
    	
        mvContainer = new Container();
        
        // DEBUG
        System.out.print("MapView:  ");
        System.out.println("(" + this.getWidth() + ", " + this.getHeight() + ")");
        System.out.println();
        
        gw.setEndWidth(this.getWidth());
        gw.setEndHeight(this.getHeight());
        
        // Attach the given GameWorld to this MapView
        // TODO: Implement proxy design pattern 
        this.gw = gw;
    }

	public void update(Observable observable, Object data) {
        // iterate over it and call paint() for each object
		GameObjects = (GameObjectCollection)data;
		
        this.repaint();
    }
    
	// Invoke the draw method of each object
	@Override
    public void paint(Graphics g) {	
		// Implement draw methods to display graphics here
		super.paint(g);
		
		// Test if drawing to the canvas works
		//testDraw(g);
    	
    	// Iterate through each object
    	IIterable i = GameWorld.find("*").getIterator();
        while(i.hasNext()) {
        	GameObject obj = i.getNext();
            if(obj instanceof IDrawable) obj.draw(g);
            //System.out.println(obj);
        }
    }
	
	private boolean testDraw(Graphics g) {
		int width  = getWidth();
		int height = getHeight();
		int x      = getX();
		int y      = getY();
		point      = new Point(x, y);
		g.setColor(ColorUtil.BLACK);
    	g.drawRect(x, y, 100, 100);
    	return true;
	}
}
