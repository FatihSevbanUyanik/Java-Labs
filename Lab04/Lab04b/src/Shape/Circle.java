package Shape;

import java.awt.*;

/**
 * Creates a circle.
 * @author Fatih Sevban Uyanik
 * @version 28,03,2018
 */
public class Circle extends Shape implements Selectable
{
    // properties
    private double radius;
    private boolean isSelected;

    // constructors

    /**
     * Constructor
     */
    public Circle( int radius, double xCoordinate, double yCoordinate )
    {
        super( xCoordinate , yCoordinate );
        this.radius = radius;
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
        return Math.PI * radius * radius;
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
        if (  Math.sqrt( Math.pow( x - getX() - getRadius() , 2)
                + Math.pow( y - getY() - getRadius() , 2 ) ) <= getRadius() )
            return this;
        else
            return null;
    }

    /**
     * gets the radius of the circle.
     * @return radius of the circle.
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * sets the radius of the circle.
     * @param radius is radius that will be substituted.
     */
    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    /**
     * draws the shape on a panel or frame.
     * @param g is the object that will draw the shape.
     */
    @Override
    public void draw( Graphics g )
    {
        g.drawOval( (int) getX() , (int) getY() , (int) getRadius() * 2 , (int) getRadius() * 2 );
    }

}