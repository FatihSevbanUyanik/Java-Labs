import java.util.ArrayList;
/**
 * collects shapes and contains method for representing them.
 * @author Fatih Sevban Uyanik
 * @version 14,03,2018
 */
public class ShapeContainer
{
    // properties
    private ArrayList<Shape> collectionOfShapes;

    // constructor
    public ShapeContainer()
    {
        collectionOfShapes = new ArrayList<>();
    }

    // methods

    /**
     * adds a new shape into the collection.
     * @param s is the shape that will be passed.
     */
    public void add( Shape s )
    {
        collectionOfShapes.add( s );
    }

    /**
     * gets the total area of the shapes in the collection.
     * @return the total area of the shapes in the collection.
     */
    public double getArea()
    {
        // defining variable
        double areaOfAllShapesInCollection = 0;

        // summing the areas of the shapes in the collection.
        for ( Shape s : collectionOfShapes )
            areaOfAllShapesInCollection += s.getArea();

        return areaOfAllShapesInCollection;
    }

    /**
     * Shows the Collection of shapes each of them with their Areas.
     * @return the Collection of shapes each of them with their Areas.
     */
    public String toString()
    {
        // heading
        String representationOfCollection = "Collection Of Shapes\n********************\n";

        // adding all of the shapes representations to the collection.
        for ( Shape s : collectionOfShapes )
        {
           if ( s instanceof Square )
              representationOfCollection += "Square( Area : " + s.getArea() + ",  Is Selected : " + 
                   ((Square) s).getSelected() + ",  Location : ( " + ((Square) s).getX() + " , " + ((Square) s).getY() +" ) )\n";
              
           else if ( s instanceof Rectangle )
              representationOfCollection += "Rectangle( Area : " + s.getArea() + ",  Is Selected : " + 
                   ((Rectangle) s).getSelected() + ",  Location : ( " + ((Rectangle) s).getX() + " , " + ((Rectangle) s).getY() +" ) )\n";
           
           else if ( s instanceof Circle )
              representationOfCollection += "Circle( Area : " + s.getArea() + " Is Selected : " + 
                   ((Circle) s).getSelected() + " Location : ( " + ((Circle) s).getX() + " , " + ((Circle) s).getY() +" ) )\n";
        }

        return representationOfCollection;
    }

    /**
     * Finds first shape through coordinates and toggles it selection state.
     * @param xCoordinate is the x coordinate that is passed.
     * @param yCoordinate is the y coordinate that is passed.
     * @return the representation of the found object.
     */
    public String findFirstShapeThroughCoordinates( double xCoordinate , double yCoordinate )
    {
        for ( Shape s : collectionOfShapes )
        {
            if ( s instanceof Square && ((Square) s).contains( xCoordinate , yCoordinate ) != null )
            {
                ((Square) s).setSelected( !((Square) s).getSelected() );
                return "Square( Area : " + s.getArea() + ",  Is Selected : " + 
                   ((Square) s).getSelected() + ",  Location : ( " + ((Square) s).getX() + " , " + ((Square) s).getY() +" ) )\n";
            }

            else if ( s instanceof Circle && ((Circle) s).contains( xCoordinate , yCoordinate ) != null )
            {
                ((Circle) s).setSelected( !((Circle) s).getSelected() );
                return "Circle( Area : " + s.getArea() + ",  Is Selected : " + 
                   ((Circle) s).getSelected() + ",  Location : ( " + ((Circle) s).getX() + " , " + ((Circle) s).getY() +" ) )\n";
            }

            else if ( s instanceof Rectangle && ((Rectangle) s).contains( xCoordinate , yCoordinate ) != null )
            {
                ((Rectangle) s).setSelected( !((Rectangle) s).getSelected() );
                return "Rectangle( Area : " + s.getArea() + ",  Is Selected : " + 
                   ((Rectangle) s).getSelected() + ",  Location : ( " + ((Rectangle) s).getX() + " , " + ((Rectangle) s).getY() +" ) )\n";
            }
        }
        return null;
    }

    /**
     * removes selected shapes from the collection.
     */
    public void removeSelectedShapesFromTheCollection()
    {
        for ( int i = 0 ; i < collectionOfShapes.size() ; i++ )
        {
            if ( collectionOfShapes.get( i ) instanceof Square && ((Square) collectionOfShapes.get( i )).getSelected() )
                collectionOfShapes.remove( i );

            else if ( collectionOfShapes.get( i ) instanceof Circle && ((Circle) collectionOfShapes.get( i )).getSelected() )
                collectionOfShapes.remove( i );

            else if ( collectionOfShapes.get( i ) instanceof Rectangle && ((Rectangle) collectionOfShapes.get( i )).getSelected() )
                collectionOfShapes.remove( i );
        }
    }
}