/**
 * A form with self drawing objects.
 * A Timer instructs the objects to move and a container to redraw the objects.
 * On collision, an object changes color.
 */
/*
public class CollisionForm extends Form implements Runnable {
	private CollisionContainer myContainer; 
	private Vector<WorldObject> theWorld ;
	public CollisionForm() {
		// code here to initialize the form...
		theWorld = new Vector<RoundObj>();
		// create a container on which the world objects will be drawn
		myContainer = CollisionContainer(theWorld) ;
		this.add(BorderLayout.CENTER,myContainer); 
		// create a Timer to invoke move and repaint operations
		UITimer timer = new UITimer(this);
		timer.schedule(15, true, this);
		// create a world containing objects
		Dimension worldSize = new Dimension(myContainer.getWidth(), myContainer.getHeight());
		addObjects(worldSize);
	}
	
	private void addObjects(Dimension worldSize) {
		theWorld.addElement(new RoundObj(Color.red, worldSize));
		theWorld.addElement(new RoundObj(Color.blue, worldSize));
		// TODO: Code here to add additional world objects...
	}
		
	// This method is entered on each Timer tick; it moves the objects,
	// checks for collisions and invokes the collision handler, 
	// then repaints the display panel.
	public void run () {
		// move all the world objects
		Iterator iter = theWorld.iterator();
		while(iter.hasNext()){
			((IMovable)iter.next()).move();
		}
		
		// check if moving caused any collisions
		iter = theWorld.iterator();
		
		while(iter.hasNext()) {
			ICollider curObj = (ICollider)iter.next(); 
			// get a collidable object
			// check if this object collides with any OTHER object
			Iterator iter2 = theWorld.iterator();
			while(iter2.hasNext()) {
				ICollider otherObj = (ICollider) iter2.next();
				// get a collidable object
				// check for collision
				if(otherObj!=curObj) {
					// make sure it's not the SAME object
					if(curObj.collidesWith(otherObj)){
						curObj.handleCollision(otherObj);
					}
				}
			}
		}
		
		myContainer.repaint();
		// redraw the world
	}
}*/