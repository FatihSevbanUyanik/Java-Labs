public class Lab07a
{
    public static void main(String[] args)
    {
        // declaring list object
        List list = new List();

        // checking whether the list is empty or not.
        System.out.println("\n*****************************");
        System.out.println( "Expected : true" );
        System.out.println( "Result   : " + list.isEmpty() );
        System.out.println("*****************************\n");

        // adding an item to head.
        System.out.println("*****************************");
        list.addToHead( "A" );
        System.out.println( "Expected : A" );
        System.out.println( "Result   : " + list.printList() );
        System.out.println("*****************************\n");

        // adding an item to head.
        list.addToHead( "B" );
        list.addToHead( "C" );
        list.addToHead( "D" );
        list.addToHead( "E" );
        list.addToHead( "F" );
        System.out.println("*****************************");
        System.out.println( "Expected : F  E  D  C  B  A" );
        System.out.println( "Result   : " + list.printList() );
        System.out.println("*****************************\n");

        // printing the list reversely.
        System.out.println("*****************************");
        System.out.println( "Expected : A  B  C  D  E  F" );
        System.out.print  ( "Result   : " );
        list.printReverse();
        System.out.println("\n*****************************\n");

        // adding items to the tail.
        list.addToTail( "G" );
        list.addToTail( "H" );
        list.addToTail( "I" );
        System.out.println("*****************************");
        System.out.println( "Expected : F  E  D  C  B  A  G  H  I" );
        System.out.println( "Result   : " + list.printList() );
        System.out.println("*****************************\n");

        // removing from head to nodes.
        list.removeFromHead();
        list.removeFromHead();
        System.out.println("*****************************");
        System.out.println( "Expected : D  C  B  A  G  H  I" );
        System.out.println( "Result   : " + list.printList() );
        System.out.println("*****************************\n");

        // getting an item from a specific index.
        System.out.println("*****************************");
        System.out.println( "Expected : A" );
        System.out.println( "Result   : " + list.getData( 3 ) );
        System.out.println("*****************************\n");

        // getting an item from a specific index.
        System.out.println("*****************************");
        System.out.println( "Expected : H" );
        System.out.println( "Result   : " + list.getData( 5 ) );
        System.out.println("*****************************\n");

        // checking whether the list is empty or not.
        System.out.println("*****************************");
        System.out.println( "Expected : false" );
        System.out.println( "Result   : " + list.isEmpty() );
        System.out.println("*****************************\n");

    }

}