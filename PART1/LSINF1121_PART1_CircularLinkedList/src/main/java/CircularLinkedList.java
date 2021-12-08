
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<Item> implements Iterable<Item> {
    private long nOp = 0; // count the number of operations
    private int n;          // size of the stack
    private Node  last;   // trailer of the list

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    public CircularLinkedList() {
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private long nOp() {
        return nOp;
    }



    /**
     * Append an item at the end of the list
     * @param item the item to append
     */
    public void enqueue(Item item) {
        // TODO STUDENT: Implement add method
        nOp++;
        Node add = new Node();
        add.item=item;
        if(n==0)
            add.next=add;
        else{
            add.next=last.next;
            last.next=add;
        }
        last=add;
        n++;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     */
    public Item remove(int index) {
        // TODO STUDENT: Implement remove method
        nOp++;
        if(index<0 || index>n-1)
            throw new IndexOutOfBoundsException();
        if(n==0){
            return null;
        }
        if(n==1){
            last.next=null;
            Item res=last.item;
            last=null;
            n--;
            return res;
        }
        else{
            Node runner=last;
            for(int i=0; i<index; i++){
                runner=runner.next;
            }
            Node temp=runner.next;
            runner.next=temp.next;
            temp.next=null;
            n--;
            return temp.item;
        }
    }


    /**
     * Returns an iterator that iterates through the items in FIFO order.
     * @return an iterator that iterates through the items in FIFO order.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        // TODO STUDENT: Implement the ListIterator

        private final int l = size();
        private int index=0;
        private Node it=last;

        @Override
        public boolean hasNext() {
            return index<l;
        }

        @Override
        public Item next() {
            if(l!=size())
                throw new ConcurrentModificationException();
            if(!hasNext())
                throw new NoSuchElementException();
            else{
                index++;
                it=it.next;
                return it.item;
            }
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

}