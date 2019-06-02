import cs1.SimpleURLReader;
/**
 * extends SimpleURLReader class and adds methods like getName() and getURL().
 * @author Fatih Sevban Uyanık
 * @version 28.02.2018
 */ 
public class MySimpleURLReader extends SimpleURLReader
{
   // properties
   String URL;
   
   // constructor
   public MySimpleURLReader(String URL) 
   {
      super( URL );
      this.URL = URL;
   }
   
   // methods
   
   /**
    * gets the URL String.
    * @return URL String.
    */
   public String getURL() 
   {
      return URL;
   }
   
   /**
    * gets the filename part of the URL.
    * @return the filename part of the URL.
    */
   public String getName() 
   {
      // declaring variables
      String reversedName = "";
      String name = "";
      
      // storing data reversely
      for( int i = ( getURL().length() - 1 ) ; getURL().charAt( i ) != '/' ; i-- )
         reversedName =  getURL().charAt( i ) + reversedName;
      
      /*// arranging it normally.
      for ( int i = ( reversedName.length() - 1 ) ; i >= 0 ; i-- )
         name += reversedName.charAt( i );*/
      
      return reversedName;
   }
   
   /**
    * gets Page contents from a URL without at the beginning null.
    * @return the page contents prominently.
    */
   @Override
   public String getPageContents() 
   {  
      return super.getPageContents().substring( 4 );
   }
   
}