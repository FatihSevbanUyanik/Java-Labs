import java.util.ArrayList;
/**
 * gets currency values of a currency. 
 * @author Fatih Sevban Uyanýk
 * @version 28.02.2018
 */ 
public class Test
{

   public static void main( String[] args )
   {
      // conecting web site
      HTMLFilteredReader htmlFilteredReader = new HTMLFilteredReader ( "https://www.turkiye.gov.tr/doviz-kurlari" );
      
      // printing euro and kanada dolarý
      System.out.println( getCurrencyValues( htmlFilteredReader , "EURO" ) );     
      System.out.println( getCurrencyValues( htmlFilteredReader , "KANADA DOLARI" ) );
   }
   
   /**
    * gets the values of euro currency.
    * @param htmlFilteredReader is the connection.
    * @param currency is the currency type.
    * @return the values of euro.
    */
   public static ArrayList<String> getCurrencyValues(  HTMLFilteredReader htmlFilteredReader , String currency )
   {
      // declaring variables and setting values.
      ArrayList<String> euroInformation = new ArrayList<>();
      euroInformation.add( "***" + currency + "***" );
      int startingIndex = htmlFilteredReader.getUnfilteredPageContents().indexOf( "1 " + currency , 0 ) + 9;
      int endingIndex = 0;
      
      // getting values
      while( startingIndex != -1 )
      {         
         if ( startingIndex != -1 )
         {
            startingIndex = htmlFilteredReader.getUnfilteredPageContents().indexOf( "<td>" , startingIndex ) + 4;
            endingIndex = htmlFilteredReader.getUnfilteredPageContents().indexOf( "</td>" , startingIndex );
            euroInformation.add(  htmlFilteredReader.getUnfilteredPageContents().substring( startingIndex  , endingIndex ) );
            startingIndex = endingIndex;
         }
         
         if ( htmlFilteredReader.getUnfilteredPageContents().indexOf( "<td>" ,endingIndex ) > htmlFilteredReader.getUnfilteredPageContents().indexOf( "</tr>" ,endingIndex ) )
            break;
      }
      return euroInformation;
   }
   
}