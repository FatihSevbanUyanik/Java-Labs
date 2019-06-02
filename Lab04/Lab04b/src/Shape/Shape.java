package Shape;

/**
 * demarcates the essential properties and methods for a shape.
 * @author Fatih Sevban Uyanik
 * @version 28,03,2018
 */
public abstract class Shape implements Locatable, Drawable
{
    // properties
    private double xCoordinate;
    private double yCoordinate;

    // constructor

    /**
     * Constructor
     */
    public Shape( double xCoordinate , double yCoordinate )
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    // methods

    /**
     * gets the Area of the shape.
     * @return the area of the shape.
     */
    public abstract double getArea();

    /**
     * gets the x-coordinate.
     * @return the x-coordinate.
     */
    @Override
    public double getX()
    {
        return xCoordinate;
    }

    /**
     * gets the y-coordinate.
     * @return the y-coordinate.
     */
    @Override
    public double getY()
    {
        return yCoordinate;
    }

    /**
     * sets the location of the shape.
     * @param x is the x coordinate that will be passed.
     * @param y is the y coordinate that will be passed.
     */
    @Override
    public void setLocation( double x, double y )
    {
        xCoordinate = x;
        yCoordinate = y;
    }

}