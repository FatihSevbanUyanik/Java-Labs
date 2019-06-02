public class MyList
{
    // properties
    private Node head;

    // constructor
    public MyList() { head = null; }

    // methods

    /**
     * checks whether the list is empty or not.
     * @return boolean type depending on result.
     */
    public boolean isEmpty() { return head == null; }

    /**
     * adds a new node to the head of the list.
     * @param item is the String that will be added.
     */
    public void addToHead( String item )
    {
        Node newNode = new Node( item );
        newNode.nextNode = head;
        head = newNode;
    }

    /**
     * adds a new node to the tail of the node list.
     * @param item is the String that will be added.
     */
    public void addToTail( String item )
    {
        Node newNode = new Node(item);

        if ( isEmpty() ) { head = newNode; }
        
        else 
        {
            TheIterator theIterator = new TheIterator();
            Node lastNode = head;

            while (theIterator.hasNext())
                lastNode = theIterator.next();

            lastNode.nextNode = newNode;
        }
    }

    /**
     * prints the list of nodes abd indicates indexes.
     */
    public String printList()
    {
        Node pointerNode = head;
        String list = pointerNode.item + "  ";

        while ( pointerNode.nextNode != null )
        {
            pointerNode = pointerNode.nextNode;
            list += pointerNode.item + "  ";
        }
        return list;
    }

    /**
     * prints the list in reverse order.
     */
    public void printReverse() { printReverse( head  ); }

    /**
     * prints the list in reverse order.
     * It is the helper method of printReverse().
     * @param startingNode is the starting node.
     */
    private void printReverse( Node startingNode )
    {
        if ( startingNode != null )
        {
            String string = startingNode.item;
            printReverse( startingNode.nextNode );
            System.out.print( string + "  " );
        }
    }

    /**
     * gets the data from a specific index.
     * @param index is the specific index.
     * @return the item of the specific node.
     */
    public String  getData( int index )
    {
        Node pointerNode = head;
        int currentIndex = 0;

        while ( pointerNode!= null && currentIndex < index  )
        {
            pointerNode = pointerNode.nextNode;
            currentIndex++;
        }

        if ( pointerNode!= null )
            return pointerNode.item;

        else return null;
    }

    /**
     * removes the head node from the list.
     */
    public String removeFromHead()
    {
        if ( !isEmpty() )
        {
            String string = head.item;
            head = head.nextNode;
            return string;
        }
        return null;
    }
}