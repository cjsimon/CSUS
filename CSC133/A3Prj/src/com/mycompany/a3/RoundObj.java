/**
 * This class defines an object which knows how to "move" and "draw" itself, and
 * how to determine whether it collides with another object, and provides a method
 * specifying what to if it is instructed to handle a collision with another object.
 * (In this case collision changes the color of the object.)
 */
/*
public class RoundObj implements IMovable, IDrawable, ICollider {
    private static Random worldRNG = new Random();
    // random number generator
    public void move() {}
    public void draw(Graphics g, Point pCmpRelPrnt) {}
    // Use bounding circles to determine whether this object has collided with another
    public boolean collidesWith(ICollider obj) {
        // Find Centers
        int thisCenterX =  this.xLoc  + (objSize/2); 
        int thisCenterY  = this.yLoc  + (objSize/2);
        int otherCenterX = obj.getX() + (objSize/2);
        int otherCenterY = obj.getY() + (objSize/2);
        
        // Get the distance between the two obj centers
        // Keep the centers as squared numbers,
        // to avoid having to take their square roots
        int dx = thisCenterX - otherCenterX;
        int dy = thisCenterY - otherCenterY;
        int distBetweenCentersSqr = (dx*dx + dy*dy);
        
        // Find the square of sum of radii
        int thisRadius  = objSize / 2;
        int otherRadius = objSize / 2;
        int radiiSqr    = (thisRadius*thisRadius + 2*thisRadius*otherRadius+ otherRadius*otherRadius);
        
        return (distBetweenCentersSqr <= radiiSqr);
    }
    
    // defines this object's response to a collision with otherObject
    public void handleCollision(ICollider otherObject) {
        // change my color by generating three random colors
        color = (ColorUtil.rgb(worldRnd.nextInt(256), worldRnd.nextInt(256), worldRnd.nextInt(256)));
    }
}
*/