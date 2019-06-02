/**
 * Creates a circle.
 * @author Fatih Sevban Uyanik
 * @version 14,03,2018
 */
public class Circle extends Shape implements Selectable
{
    // properties
    private int radius;
    private double xCoordinate;
    private double yCoordinate;
    private boolean isSelected;

    // constructors
    public Circle( int radius, double xCoordinate, double yCoordinate )
    {
        super( xCoordinate, yCoordinate );
        this.radius = radius;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
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

    @Override
    public boolean getSelected()
    {
        return isSelected;
    }

    @Override
    public void setSelected( boolean b )
    {
        isSelected = b;
    }

    @Override
    public Shape contains( double x, double y )
    {
        if (  Math.sqrt( Math.pow( x - xCoordinate , 2) + Math.pow( y - yCoordinate , 2 ) ) < radius )
            return this;
        else
            return null;
    }

}
