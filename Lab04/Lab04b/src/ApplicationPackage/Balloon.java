package ApplicationPackage;

import Shape.Circle;
/**
 * enables the balloon to grow.
 * @author Fatih Sevban Uyanik
 * @version 28,03,2018
 */
public class Balloon extends Circle
{
    // constants
    private final int INCREASE_RATE_OF_RADIUS = 2;
    private final int MAXIMUM_RADIUS_VALUE = 100;

    // properties

    // constructors

    public Balloon( double xCoordinate , double yCoordinate )
    {
        super( 25 , xCoordinate, yCoordinate);
    }

    // methods

    /**
     * enables the radius to grow to a certain value.
     */
    public void grow()
    {
        // exceeding maximum radius value, setting radius to 0.
        if ( getRadius() >= MAXIMUM_RADIUS_VALUE )
        {
            setSelected( true );
            setRadius( 0 );
        }

        // increasing radius
        else
        {
            setRadius( getRadius() + INCREASE_RATE_OF_RADIUS );
            setLocation(
                    getX() - ( INCREASE_RATE_OF_RADIUS / 2 ) ,
                    getY() - ( INCREASE_RATE_OF_RADIUS / 2 )
            );
        }
    }

}