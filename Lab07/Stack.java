public class Stack extends List
{
    // constructor
    public Stack() { super(); }

    // methods

    /**
     * adds an item to the top of the stack.
     * @param item is the item to be added.
     */
    public void push( String item ) { addToTail( item ); }

    /**
     * removes an item of the stack.
     * @return the removed item.
     */
    public String pop()
    {
        if ( !isEmpty() )
        {
            // getting the required nodes.
            Node pointerNode1 = null;
            Node pointerNode2 = getHead();

            while (pointerNode2.nextNode != null)
            {
                pointerNode1 = pointerNode2;
                pointerNode2 = pointerNode2.nextNode;
            }

            if ( pointerNode2 == getHead() )
            {
                String s = pointerNode2.item;
                setHead( null ); return s;
            }
            else
            {
                String s = pointerNode2.item;
                pointerNode1.nextNode = null;
                return s;
            }
        }
        return null;
    }

    /**
     * checks whether the stack is empty or not.
     * @return the boolean type accordingly.
     */
    public boolean isEmpty() { return super.isEmpty(); }

}