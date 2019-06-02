import java.util.Iterator;
import java.util.ArrayList;
/**
 * implements iterator for IntBag class.
 * @author Fatih Sevban Uyanik
 * @version 14,03,2018
 */
public class IntBagIterator implements Iterator
{
    // properties
    IntBag aBag;
    int index;
    ArrayList<Integer> iteratedValues = new ArrayList<Integer>();

    // constructors
    public IntBagIterator(IntBag aBag) {
        this.aBag = aBag;
        index = 0;
    }

    // methods

    /**
     * checks whether there is an object to iterate.
     * @return the boolean type of the result.
     */
    @Override
    public boolean hasNext()
    {
       if ( index < aBag.size() )
          return true;
       
       else
       {
          index = 0;
          return false;
       }
    }

    /**
     * iterates the next object.
     * @return the next object in the sequence.
     */
    @Override
    public Object next()
    {
         while ( iteratedValues.size() != aBag.size() )
          {
             Integer integer = aBag.get( ( int ) ( Math.random() * aBag.size() ) );
             boolean indicator = true;
             
             for ( int i = 0 ; i < iteratedValues.size() ; i++ )
                if ( integer == iteratedValues.get( i ) ) 
                indicator = false;
             
             if ( indicator )
             {
                iteratedValues.add( integer );
                index++;
                return integer;
             }
             
          }
          return null;
    }
    
    
}