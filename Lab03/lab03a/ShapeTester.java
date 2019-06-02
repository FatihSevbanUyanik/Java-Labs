import java.util.Scanner;
/**
 * Tests the shape container class.
 * @author Fatih Sevban Uyanik
 * @version 14,03,2018
 */
public class ShapeTester
{
   public static void main( String[] args )
   {
      Scanner scanner = new Scanner( System.in );
      
      // Constants
      
      // Variables
      ShapeContainer shapeContainer;
      int selection;
      int width;
      int height;
      int radius;
      int side;
      double xCoordinate;
      double yCoordinate;
      
      // program code
      
      // declaring selection and shapeContainer
      shapeContainer = new ShapeContainer();
      selection = 0;
      
      // heading
      System.out.println( "SHAPE TESTER" );
      System.out.print( "************" );
      
      // menu
      do 
      {
         System.out.println( "\n" );
         System.out.println( "1. Create an empty shape container            ( Type 1 )" );
         System.out.println( "2. Add Rectangle                              ( Type 2 )" );
         System.out.println( "3. Add Circle                                 ( Type 3 )" );
         System.out.println( "4. Add Square                                 ( Type 4 )" );
         System.out.println( "5. Show Collection                            ( Type 5 )" );
         System.out.println( "6. Find First Shape through coordinates       ( Type 6 )" );
         System.out.println( "7. Delete selected Shapes from the collection ( Type 7 )" );
         System.out.println( "8. Exit                                       ( Type 8 )" );
         
         // requesting and reading selection
         System.out.print( "\nPlease make a selection : " );
         selection = scanner.nextInt();
         
         // creating an empty shape container
         if ( selection == 1 )
            shapeContainer = new ShapeContainer();
         
         // adding rectangle to the shape container.
         else if ( selection == 2 )
         {
            // requesting and reading width and height values from the user.
            System.out.print( "\nPlease enter the width value of the rectangle : " );
            width = scanner.nextInt();
            System.out.print( "Please enter the height value of the rectangle : " );
            height = scanner.nextInt();
            
            // requesting and reading x coordinate and y coordinate values from the user.
            System.out.print( "\nPlease enter the x coordinate of the rectangle : " );
            xCoordinate = scanner.nextDouble();
            System.out.print( "Please enter the y coordinate value of the rectangle : " );
            yCoordinate = scanner.nextDouble();
            
            shapeContainer.add( new Rectangle( width , height , xCoordinate , yCoordinate ) );
         }
         
         // adding circle to the shape container.
         else if ( selection == 3 )
         {
            // requesting and reading radius value from the user and adding them.
            System.out.print( "\nPlease enter the radius value of the circle : " );
            radius = scanner.nextInt();
            
            // requesting and reading x coordinate and y coordinate values from the user.
            System.out.print( "\nPlease enter the x coordinate of the circle : " );
            xCoordinate = scanner.nextDouble();
            System.out.print( "Please enter the y coordinate value of the circle : " );
            yCoordinate = scanner.nextDouble();
            
            shapeContainer.add( new Circle( radius, xCoordinate, yCoordinate ) );
         }
         
         // adding square to the shape container.
         else if ( selection == 4 )
         {
            // requesting and reading side value from the user.
            System.out.print( "\nPlease enter the side value of the square : " );
            side = scanner.nextInt();
            
            // requesting and reading x coordinate and y coordinate values from the user.
            System.out.print( "\nPlease enter the x coordinate of the rectangle : " );
            xCoordinate = scanner.nextDouble();
            System.out.print( "Please enter the y coordinate value of the rectangle : " );
            yCoordinate = scanner.nextDouble();
            
            shapeContainer.add( new Square( side , xCoordinate , yCoordinate ) );
         }
         
         // showing the collection
         else if ( selection == 5 )
            System.out.print( "\n" + shapeContainer.toString() );
         
         // finding first shape through coordinates.
         else if ( selection == 6 )
         {
            // requesting and reading x coordinate and y coordinate values from the user.
            System.out.print( "\nPlease enter the x coordinate of the shape that you want to find : " );
            xCoordinate = scanner.nextDouble();
            System.out.print( "Please enter the y coordinate of the shape that you want to find : " );
            yCoordinate = scanner.nextDouble();
            System.out.println( "\n" + shapeContainer.findFirstShapeThroughCoordinates( xCoordinate , yCoordinate ) );
         }
         
         // deleting selected Shapes from the collection
         else if ( selection == 7 )
            shapeContainer.removeSelectedShapesFromTheCollection();
         
      } while( selection != 8 );
      
      System.out.println( "\nBYE BYE" );
      
   }
   
}