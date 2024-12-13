
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
    private Circle ball; // The sample ball to animate
    private int dx = 5; // Speed in x direction for the sample ball
    private int dy = -5; // Speed in y direction for the sample ball
    
    public Picture()
    {
        // Get a reference to the canvas for this drawing and set its title.
        pic = Canvas.getCanvas();
        pic.setTitle("Winter Scene");
        pic.setBackgroundColor("blue");
        
        // Turn off automatic redrawing
        pic.pause(true);
        
        ball = new Circle();
        ball.makeVisible();
        
        // Show the initial picture
        pic.redraw();
    }
    
    /**
     * Update the screen to create a new frame for the animation
     */
    public void update() 
    {
        int x = ball.getX();
        int y = ball.getY();
        
        // Calculate a new position for the ball
        x = x + dx;
        y = y + dy;        
        
        // Bounce off the edges
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        else if (x + ball.getDiameter() > pic.getWidth()) {
            dx = -dx;
            x = pic.getWidth() - ball.getDiameter();
        }
        
        if (y < 0) {
            y = 0;
            dy = -dy;
        }        
        else if (y + ball.getDiameter() > pic.getHeight()) {
            y = pic.getHeight() - ball.getDiameter();
            dy = -dy;
        }
        
        // Move the ball
        ball.setPosition(x, y);
        
        // Update the screen
        pic.redraw();
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