/**
 * Tests HTMLFilteredReader class and uses its methods.
 * @author Fatih Sevban Uyan�k
 * @version 28.02.2018
 */ 
public class HTMLFilteredReaderTest 
{
   public static void main(String[] args) 
   { 
      HTMLFilteredReader htmlFilteredReader = new HTMLFilteredReader( "http://www.cs.bilkent.edu.tr/%7Edavid/housman.htm" );
      
      // printing out unfiltered page contents.
      System.out.println( "**************UNFILTERED PAGE CONTENTS**************" );
      System.out.println( htmlFilteredReader.getUnfilteredPageContents() );
      
      // printing out filtered page contents.
      System.out.println( "**************FILTERED PAGE CONTENTS**************" );
      System.out.println( htmlFilteredReader.getPageContents() );
   }
}
