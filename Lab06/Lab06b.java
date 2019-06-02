import java.util.Scanner;
/**
 * converts the decimal number to binary number.
 * @author Fatih Sevban Uyan?k
 * @version 18.04.2018
 */
public class Lab06b
{
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner( System.in );
      
      // constants
      
      // variables
      int decimalNumber;
      int  binaryNumber;
      
      // program code
      
      // heading
      System.out.println( "\n***CONVERTING DECIMAL TO BINARY FORM***" );
      System.out.println( "***************************************\n" );
      
      // requesting and reading a string.
      System.out.print( "Please enter a decimal number : " );
      decimalNumber = scanner.nextInt();
      
      // calling method
      binaryNumber = changeToBinary( decimalNumber );
      
      // printing out result
      System.out.println( "\nResult : " + binaryNumber );
   }
   
   /**
    * changes a decimal number to base 2.
    * @param decimalNumber is the decimalNumber.
    * @return the binary form of the decimalNumber.
    */
   private static int changeToBinary( int decimalNumber )
   {
      if ( decimalNumber < 2 )
         return decimalNumber;
      
      int binaryForm       = decimalNumber % 2;
      int numberWillPassed = decimalNumber / 2;
      
      return Integer.valueOf( changeToBinary( numberWillPassed ) + "" + binaryForm ) ;
   }
   
}