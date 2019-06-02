/**
 * Tests SimpleURLReader class and uses its methods.
 * @author Fatih Sevban Uyanýk
 * @version 28.02.2018
 */ 
public class SuperHTMLFilteredReaderTest
{
   public static void main(String[] args)
   {
      // creating a SuperHTMLFilteredReader object and giving a URL to its constructor
      SuperHTMLFilteredReader superHTMLFilteredReader = new SuperHTMLFilteredReader( "http://www.cs.bilkent.edu.tr/%7Edavid/index.html" );
      
      // printing out the unfiltered page contents
      System.out.println( "**************UNFILTERED PAGE CONTENTS**************" );
      System.out.println( superHTMLFilteredReader.getUnfilteredPageContents() );
      
      // getting the links of the URL's.
      System.out.println( "**************LINKS**************" );
      System.out.println( superHTMLFilteredReader.getLinks() );
      
      // printing out overhead (the percentage increase in size between the html and no-html contents.)
      System.out.println( "**************OVERHEAD**************" );
      superHTMLFilteredReader.calculateOverhead();
   }

}
