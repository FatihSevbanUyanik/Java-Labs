import java.util.ArrayList;
/**
 * checks whether the collection is in alphabetical order.
 * @author Fatih Sevban Uyan?k
 * @version 18.04.2018
 */
public class Lab06c
{
    // properties
    private static ArrayList<String> stringsGlobal;

    // program code
    
    public static void main(String[] args)
    {
       // constructing an ArrayList that takes strings in alphabetical order.
       ArrayList<String> strings1 = new ArrayList<>();
       strings1.add( "Ahmed"  );
       strings1.add( "Arif"   );
       strings1.add( "Atiye"  );
       strings1.add( "Esma"   );
       strings1.add( "Fatih"  );
       strings1.add( "Mehmed" );
       
       // printing out the result.
       System.out.println( "result : " + isInLexicographicOrder(strings1) );
       
       // constructing an ArrayList that takes strings not in alphabetical order.
       ArrayList<String> strings2 = new ArrayList<>();
       strings2.add( "Fatih"  );
       strings2.add( "Ahmed"  );
       strings2.add( "Arif"   );
       strings2.add( "Atiye"  );
       strings2.add( "Esma"   );
       strings2.add( "Mehmed" );
       
       // printing out the result.
       System.out.println( "result : " + isInLexicographicOrder(strings2) );
    }

    /**
     * checks whether an ArrayList is in alphabetical order.
     * @param strings is the ArrayList containing strings.
     * @return the boolean type according to the result.
     */
    private static boolean isInLexicographicOrder(ArrayList<String> strings)
    {
       stringsGlobal = strings;
       return isInLexicographicOrder(0);
    }
    
    /**
     * helper method checks whether an ArrayList is in alphabetical order.
     * @param index is the index that  will check the arrayList.
     * @return the boolean type according to the result.
     */
    private static boolean isInLexicographicOrder( int index )
    {
       if ( stringsGlobal.size() - 1 == index )
          return true;
       
       if ( stringsGlobal.get(index).compareTo( stringsGlobal.get(index + 1) ) > 0 )
          return false;
       
       return  isInLexicographicOrder( ++index );
    }
    
}