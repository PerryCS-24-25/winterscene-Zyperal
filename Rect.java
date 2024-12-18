
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 * A rectangle that can be manipulated and that draws itself on a canvas.
 *
 * @author  Michael K�lling and David J. Barnes and Brian Dahlem
 * @version 2018.11.26
 */

public class Rect
{
    private int xPosition;
    private int yPosition;
    private int xSize;
    private int ySize;
    private int rotation;
    private Color color;
    private boolean isVisible;

    /**
     * Create a new rectangle at default position with default color.
     */
    public Rect()
    {
        xSize = 60;
        ySize = 60;
        xPosition = 310;
        yPosition = 120;
        rotation = 0;
        color = Canvas.getColor("red");
        isVisible = false;
    }

    /**
     * Create a new rectangle at a specified position and color.
     */
    public Rect(int x, int y, int width, int height, String color, boolean visible)
    {
        xSize = width;
        ySize = height;
        xPosition = x;
        yPosition = y;
        rotation = 0;
        this.color = Canvas.getColor(color);
                    
        if (visible) {
            makeVisible();
        }
    }

    /**
     * Make this rectangle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        if (!isVisible) {
            isVisible = true;
            add();
        }
    }

    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        if (isVisible){
            remove();
            isVisible = false;
        }
    }
    
    /**
     * Determine if the rectangle should be showing on the canvas
     * @return true if the shape is not hidden
     */
    public boolean isVisible()
    {
        return isVisible;
    }
    
    
    /**
     * Get the rectangle's X position
     */
    public int getX() {
        return xPosition;
    }
    
    /**
     * Set the rectangle's X position
     */
    public void setX(int x) {
        this.xPosition = x;
    }    
    
    /**
     * Get the rectangle's Y position
     */
    public int getY() {
        return yPosition;
    }
    
    /**
     * Set the rectangle's Y position
     */
    public void setY(int y) {
        this.yPosition = y;
    }
    
    /**
     * Set the rectangle's position on the screen
     */
    public void setPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }
    
    /**
     * Determine the rectangle's current width
     */
    public int getWidth() {
        return this.xSize;
    }
    
    /**
     * Determine the rectangle's current height
     */
    public int getHeight() {
        return this.ySize;
    }
    
    /**
     * Change the rectangle's width
     */
    public void setWidth(int width) {
        this.xSize = width;
    }
    
    /**
     * Change the rectangle's height
     */
    public void setHeight(int height) {
        this.ySize = height;
    }
    

    /**
     * Move the rectangle a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the rectangle a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the rectangle a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the rectangle a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the rectangle horizontally by 'distance' pixels.
     * @param distance the distance to move the rectangle along the x axis, 
     *                  positive to the right
     */
    public void moveHorizontal(int distance)
    {
        xPosition += distance;
    }

    /**
     * Move the rectangle vertically by 'distance' pixels.
     * @param distance the distance to move the rectangle along the y axis, 
     *                  positive down
     */
    public void moveVertical(int distance)
    {
        yPosition += distance;
    }

    /**
     * Change the size to the new size (in pixels). Size must be &gt;= 0.
     * @param newSize the new width and height of the square
     */
    public void changeSize(int newSize)
    {
        xSize = newSize;
        ySize = newSize;
    }

    /**
     * Change the size of the rectangle to a new, non-square size.  newHeight and newWidth must be &gt;= 0.
     * @param newHeight the new length of the rectangle along the y axis
     * @param newWidth the new width of the rectangle along the x axis
     */
    public void changeSize(int newHeight, int newWidth)
    {
        xSize = newWidth;
        ySize = newHeight;
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta", "cyan", "brown", "white", and "black", or rgb hex strings
     * "#rrggbb" where rr, gg, bb are 2-hexit values for red, green, and
     * blue levels.
     * @param newColor a string naming the new color for the rectangle
     */
    public void changeColor(String newColor)
    {
        color = Canvas.getColor(newColor);
    }

    /**
     * Rotate the rectangle to a given angle.
     * @param degrees the angle to turn the rectangle to.
     */
    public void setRotation(int degrees)
    {
        this.rotation = degrees;    
    }
        
    /**
     * Get the current rotation of this rectangle
     * @return degrees the rectangle is rotated by
     */
    public int getRotation()
    {
        return rotation;
    }

    /**
     * Draw a rectangle with current specifications on screen.
     */
    private void add()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.add(this, (g) -> {
                                        Graphics2D g2D = (Graphics2D)g;
                                        AffineTransform original = g2D.getTransform();
                                        
                                        g2D.translate(xPosition, yPosition);
                                        g2D.rotate(Math.toRadians(rotation));
                                        
                                        g2D.setColor(color);
                                        g2D.fillRect(0, 0, xSize, ySize);
                                        
                                        g2D.setTransform(original);
                                    });
        }
    }

    /**
     * Remove the rectangle from the screen.
     */
    private void remove()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.remove(this);
        }
    }
}
