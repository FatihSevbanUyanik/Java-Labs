import java.util.ArrayList;
/**
 * extends HTMLFilteredReader class and gets links from page contents.
 * @author Fatih Sevban Uyanýk
 * @version 28.02.2018
 */ 
public class SuperHTMLFilteredReader extends HTMLFilteredReader 
{
   // constructor
   public SuperHTMLFilteredReader( String URL ) 
   {
      super(URL);
   }
   
   // methods
   
   /**
    * get Links from a websites source code.
    * @return the relevant URL links.
    */
   public ArrayList<String> getLinks() 
   {
      // declaring variables
      ArrayList<String> links = new ArrayList<>();
      int startingIndex = 0;
      int endingIndex;
      
      // getting URL's.
      while( startingIndex != -1 )
      {
         startingIndex = getUnfilteredPageContents().indexOf( "href" , startingIndex );
         
         if ( startingIndex != -1 )
         {
            endingIndex = getUnfilteredPageContents().indexOf( "\"" , startingIndex + 6 );
            links.add(  getUnfilteredPageContents().substring( startingIndex + 6 , endingIndex ) );
            startingIndex = endingIndex;
         }
      }
      
      return links;
   }
   
   /**
    * calculates overhead (the percentage increase in size between the html and no-html contents.).
    */
   public void calculateOverhead()
   {
      // getting letter count of html version and non html version.
      double numberOfCharactersInUnfilteredVersion = getUnfilteredPageContents().length();
      double numberOfCharactersInFilteredVersion = getPageContents().length();
      
      // calculating overhead and printing it out. 
      double overhead = ( numberOfCharactersInFilteredVersion / numberOfCharactersInUnfilteredVersion ) * 100 ; 
      System.out.println( " Overhead (the percentage increase in size between the html and no-html contents.) : " + overhead );
   }
   
}