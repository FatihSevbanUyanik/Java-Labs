/**
 * Collects the first 100 prime numbers.
 * @author Fatih Sevban Uyanýk
 * @version 14,02,2018
 */ 
public class PrimeNumbers 
{
   public static void main( String[] args )
   {
      // constants
      
      // variables
      int num;
      
      // program code
      
      // Creating an IntBag object.
      IntBag intBag = new IntBag();
    
      // adding initially 2 to the collection.
      intBag.add(2);
      
      // adding prime numbers starting from 3.
      num = 3;
      
      while ( intBag.size() != 100 )
      {
         int indicator = 1;
         
         for ( int i = 0 ; i < intBag.size() ; i++ )
            if ( num % intBag.get( i ) == 0 )
              indicator = 0;
   
         if( indicator == 1 )
            intBag.add( num );
         
         num++;
      }
      
      // presenting the collection.
      System.out.println( intBag.toString() );
   }
  
}