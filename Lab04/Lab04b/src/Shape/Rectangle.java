package Shape;

import java.awt.*;

/**
 * Rectangle a circle.
 * @author Fatih Sevban Uyanik
 * @version 28,03,2018
 */
public class Rectangle extends Shape implements Selectable , Drawable
{
    // properties
    private int width;
    private int height;
    private boolean isSelected;

    // constructor

    /**
     * Constructor
     */
    public Rectangle(int width, int height , double xCoordinate, double yCoordinate )
    {
        super( xCoordinate , yCoordinate );
        this.width = width;
        this.height = height;
        isSelected = false;
    }

    // methods

    /**
     * gets the Area of the shape.
     * @return the area of the shape.
     */
    @Override
    public double getArea()
    {
        return width * height;
    }

    /**
     * indicates whether the shape is selected or not.
     * @return the boolean type according to the result.
     */
    @Override
    public boolean getSelected()
    {
        return isSelected;
    }

    /**
     * sets the indicator of being selected.
     * @param b will select the shape or not.
     */
    @Override
    public void setSelected( boolean b )
    {
        isSelected = b;
    }

    /**
     * checks whether the shape contains the passed point.
     * @param x is the x coordinate that is passed.
     * @param y is the y coordinate that is passed.
     * @return the shape that contains the passed point.
     */
    @Override
    public Shape contains( double x, double y )
    {
        if ( ( x - getX() ) <= width && ( x - getX() ) >= 0 &&
                ( y - getY() ) >= 0 && ( y - getY() ) <= height )
            return this;
        else
            return null;
    }

    /**
     * draws the shape on a panel or frame.
     * @param g is the object that will draw the shape.
     */
    @Override
    public void draw(Graphics g)
    {
        g.drawRect( (int) getX() , (int) getY() , width , height );
    }

}