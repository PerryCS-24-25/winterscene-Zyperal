
import javax.swing.Timer;

/**
 * Draw a pretty picture composed of shape objects on a canvas
 * 
 * @author: (Your name)
 * @version: (Date)
 * 
 */
public class Picture
{
    // Private member (instance) variables
    private Canvas pic;
    private Circle[] snow = new Circle[100]; // Allocate space for 100 Circles
    private Rect ground;

    public Picture()
    {
        // Get a reference to the canvas for this drawing and set its title.
        pic = Canvas.getCanvas();
        pic.setTitle("Winter Scene");
        pic.setBackgroundColor("blue");
        
        // Turn off automatic redrawing
        pic.pause(true);
        
        // Show the initial picture
        pic.redraw();
    }
    
    /**
     * Update the screen to create a new frame for the animation
     */
    public void update() 
    {
        // Update the screen
        pic.redraw();

        //animates the flakes :)
        for (int i = 0; i < snow.length; i++) {
            snow[i] = new Circle(0, 0, 2, "white", true); // create flakes - small circles
        }

        new Rect(0, 700, width, height, color, visible)
    }
    
    /**
     * This main method prepares and regularly updates a picture.
     */
    public static void main(String[] args)
    {
        Picture pic = new Picture();
        
        // update the screen every 33ms (30 times / second)
        new Timer(33, e->pic.update()).start();        
    }
   
}