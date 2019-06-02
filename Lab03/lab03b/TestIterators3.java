import java.util.Iterator;
import java.util.ArrayList;
/**
 * included class.
 * @author Fatih Sevban Uyanik
 * @version 14,03,2018
 */
public class TestIterators3
{
    public static void main(String[] args)
    {
        // variables
        Iterator i, j;
        IntBag bag = new IntBag();

        // adding numbers
        for ( int k = 0 ; k < 4 ; k++ )
            bag.add( k );

        i = new IntBagIterator( bag);

        // included code
        while ( i.hasNext() )
        {
            System.out.println( i.next() );

            j = new IntBagIterator( bag);
            //j = bag.iterator();

            while ( j.hasNext() )
            {
               Integer inte = (Integer) j.next();
               if ( inte != null ) 
                System.out.println( "--" + inte );
            }
               
        }
    }
}