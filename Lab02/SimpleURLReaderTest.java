import cs1.SimpleURLReader;
/**
 * Tests SimpleURLReader class and uses its methods.
 * @author Fatih Sevban Uyanýk
 * @version 28.02.2018
 */ 
public class SimpleURLReaderTest
{
   
   public static void main(String[] args)
   {
      // creating a SimpleURLReaderTest object and giving a URL to its constructor.
      MySimpleURLReader readerTest = new MySimpleURLReader( "http://www.cs.bilkent.edu.tr/%7Edavid/housman.txt" );
      
      // printing out the page contents
      System.out.println( "*************PAGE CONTENTS*************" );
      System.out.println( readerTest.getPageContents() );
      
      // printing out the number of lines.
      System.out.println( "*************NUMBER OF LINES*************" );
      System.out.println( readerTest.getLineCount() );
   }
   
}