import java.util.Scanner;
/**
 * counts the number of occurrences in a string.
 * @author Fatih Sevban Uyan?k
 * @version 18.04.2018
 */
public class Lab06a
{
   // properties
   private static String string;
   
   // program code
   
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner( System.in );
      
      // constants
      
      // variables
      Character   letter;
      int namOfOccurrence;
      
      // program code
      
      // heading
      System.out.println( "***COUNTING THE NUMBER OF OCCURRENCES IN A STRING***"   );
      System.out.println( "****************************************************\n" );
      
      // requesting and reading a string.
      System.out.print( "Please enter a string : " );
      string = scanner.nextLine();
      
      // requesting and reading a letter.
      System.out.print( "Please enter a letter : " );
      letter = scanner.nextLine().charAt(0);
      
      // calling method
      namOfOccurrence = countNumberOfOccurrences( letter );
      
      // printing out result
      System.out.println( "\nResult : " + namOfOccurrence );
   }
   
   /**
    * counts the number of occurrences in a string.
    * @param letter is the letter that occurs in string.
    * @return the number of the occurrences.
    */
   private static int countNumberOfOccurrences( char letter )
   {
      return countNumberOfOccurrences( 0 , letter );
   }
   
   /**
    * is a helper method which counts the number of occurrences in a string.
    * @param index is the index that will be checked.
    * @param letter is the letter that will be searched.
    * @return the number of occurrences os-f the letter in the string.
    */
   private static int countNumberOfOccurrences( int index , char letter )
   {
      if ( string.length() - 1 == index )
         return 0;
      
      int count = 0;
      
      if ( string.charAt(index) == letter )
         count++;
      
      return count + countNumberOfOccurrences( ++index , letter );
   }
   
}