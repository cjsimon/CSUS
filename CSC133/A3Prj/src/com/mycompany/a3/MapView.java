package com.mycompany.a3;

import java.util.Observer;
import java.io.IOException;
import java.util.Observable;
import com.codename1.ui.plaf.Border;
import com.mycompany.a3.objects.Alien;
import com.mycompany.a3.objects.Astronaut;
import com.mycompany.a3.objects.GameObject;
import com.mycompany.a3.objects.GameObjectCollection;
import com.mycompany.a3.objects.IDrawable;
import com.mycompany.a3.objects.IIterable;
import com.mycompany.a3.objects.Spaceship;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.a3.Random;

public class MapView extends Container implements Observer {
	private static final Random R = Random.getInstance();
	
	private GameWorld gw;
    private GameObjectCollection GameObjects;
    private Container mvContainer;
    //private Point point;
    
    // Background images to select from
    private Image bgImage;
    private String[] bgImages = {
		"galaxy.png",
		"earth.png",
		"horizon.png",
		"nebula.png",
		"stars.png"
    };
    
    public MapView(GameWorld gw) {
    	//this.setLayout(new BorderLayout(CENTER));
    	this.setLayout(new FlowLayout());
    	this.getAllStyles().setBgTransparency(255);
        this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
    	
        // Pick a random background image to display
        bgImage = null;
		try {
			bgImage = Image.createImage("/" + bgImages[R.nextInt(0, bgImages.length-1)]);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        mvContainer = new Container();
        
        gw.setEndWidth(this.getWidth());
        gw.setEndHeight(this.getHeight());
        
        // Attach the given GameWorld to this MapView
        // TODO: Implement proxy design pattern 
        this.gw = gw;
    }

	public void update(Observable observable, Object data) {
		//GameObjects = (GameObjectCollection)data;
        // Only repaint if the gameworld isn't paused
		if(gw.isPlaying) this.repaint();
    }
    
	// Invoke the draw method of each object
	@Override
    public void paint(Graphics g) {
		// Implement draw methods to display graphics here
		super.paint(g);
		
		// Draw the background
		if(bgImage != null) {
			g.drawImage(bgImage, getX(), getY(), getWidth(), getHeight());
		} else {
			System.err.println("Cannot display background");
		}
		
		// Test if drawing to the canvas works
		//testDraw(g);
    	
    	// Iterate through each object
    	IIterable i = GameWorld.find("*").getIterator();
        while(i.hasNext()) {
        	GameObject obj = i.getNext();
            if(obj instanceof IDrawable) obj.draw(g);
            //if(obj instanceof Spaceship) System.out.println(obj);
            //if(obj instanceof Alien)	   System.out.println(obj);
            //if(obj instanceof Astronaut) System.out.println(obj);
            //System.out.println(obj);
        }
    }
	
	private boolean testDraw(Graphics g) {
		int width  = getWidth();
		int height = getHeight();
		int x      = getX();
		int y      = getY();
		
		g.setColor(ColorUtil.BLACK);
    	g.drawRect(x, y, 100, 100);
    	return true;
	}
}
