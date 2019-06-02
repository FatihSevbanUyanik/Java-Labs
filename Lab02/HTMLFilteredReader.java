/**
 * extends SimpleURLReader class and filters page contents.
 * @author Fatih Sevban Uyanýk
 * @version 28.02.2018
 */ 
public class HTMLFilteredReader extends MySimpleURLReader
{
   // constructor
   public HTMLFilteredReader( String URL ) 
   {
      super(URL);
   }
   
   // methods
   
   /**
    * gets the page contents without filtering.
    * @return the unfiltered page contents.
    */
   public String getUnfilteredPageContents()
   {
      return super.getPageContents();
   }
   
   /**
    * gets the page contents after filtering.
    * @return the filtered page contents.
    */
   @Override
   public String getPageContents() 
   {   
      // declaring variables and initializing them.
      String filteredPageContents = "";
      boolean indicator = false ;
      
      // constructing a String that doesn't contain any html code.  
      for ( int i = 0 ; i < getUnfilteredPageContents().length() ; i++ )
      {
         if ( getUnfilteredPageContents().charAt( i ) == '>' )
            indicator = true;
         
         else if ( getUnfilteredPageContents().charAt( i ) == '<' || getUnfilteredPageContents().charAt( i ) == '&' )
            indicator = false;
         
         if ( indicator == true && getUnfilteredPageContents().charAt( i ) != '>' )
         {
            if ( getUnfilteredPageContents().charAt( i ) == '\n' && getUnfilteredPageContents().charAt( i - 1 ) == '\n' ) 
            {
            }
            if ( getUnfilteredPageContents().charAt( i ) == '\n' && getUnfilteredPageContents().charAt( i - 1 ) == '>' ) 
            {  
            }
            else
               filteredPageContents += getUnfilteredPageContents().charAt( i );
            
            /*if ( !( getUnfilteredPageContents().charAt( i ) == '\n' && getUnfilteredPageContents().charAt( i - 1 ) == '\n' ) 
                   && !( getUnfilteredPageContents().charAt( i ) == '\n' && getUnfilteredPageContents().charAt( i - 1 ) == '>' ) ) 
            {
               filteredPageContents += getUnfilteredPageContents().charAt( i );
            }*/
         }
            
      }
      return filteredPageContents;
   }
   
}