/**
 * Rectangle a circle.
 * @author Fatih Sevban Uyanik
 * @version 14,03,2018
 */
public class Rectangle extends Shape implements Selectable
{
    // properties
    private int width;
    private int height;
    private double xCoordinate;
    private double yCoordinate;
    private boolean isSelected;

    // constructor
    public Rectangle(int width, int height , double xCoordinate, double yCoordinate )
    {
        super( xCoordinate , yCoordinate );
        this.width = width;
        this.height = height;
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
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public Shape contains( double x, double y )
    {
        if ( ( x - xCoordinate ) <= width && ( x - xCoordinate ) >= 0 &&
                ( y - yCoordinate ) >= 0 && ( y - yCoordinate ) <= height )
            return this;
        else
            return null;
    }

}