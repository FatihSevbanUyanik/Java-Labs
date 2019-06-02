package Shape;
/**
 * Creates a square.
 * @author Fatih Sevban Uyanik
 * @version 28,03,2018
 */
public class Square extends Rectangle
{
    // properties

    // constructors

    /**
     * Constructor
     */
    public Square( int side ,double xCoordinate, double yCoordinate )
    {
        super( side, side, xCoordinate, yCoordinate );
    }

    // methods

    /**
     * gets the Area of the shape.
     * @return the area of the shape.
     */
    @Override
    public double getArea()
    {
        return super.getArea();
    }

}