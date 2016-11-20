/*
public class WorldObject {
    private int currentX = 0, currentY = 0 ;
    // the object's current location (relative to the origin of the component)
    private int incX = 3, incY = 3 ;
    // amount of movement on each move
    private int size = 35 ;
    // object size
    // create the image to be used for this object
    Image theImage = null;
    public WorldObject(){
        try {
            // you should copy happyFace.png directly under the src directory
            theImage = Image.createImage("/happyFace.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // move this object within the specified boundaries
    public void move (Dimension dCmpSize) {
        // update the object position
        currentX += incX ;
        currentY += incY ;
        // reverse the next movement direction if the location has reached an edge
        if ( (currentX+size >= dCmpSize.getWidth()) || (currentX < 0) ) 
        incX = -incX ;
        if ( (currentY+size >= dCmpSize.getHeight()) || (currentY < 0) ) {
            incY = -incY ;
        }
    }
}
*/