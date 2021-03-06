import java.util.EmptyStackException;

public class MyStack<E> implements Stack<E> {

    private Node<E> top;        // the node on the top of the stack
    private int size;        // size of the stack

    // helper linked list class
    private class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    /**
     * Tests if this stack is empty
     */
    @Override
    public boolean empty() {
        // TODO STUDENT: Implement empty method
        return size==0;
    }

    /**
     * Looks at the object at the top of this stack
     * without removing it from the stack
     */
    @Override
    public E peek() throws EmptyStackException {
        // TODO STUDENT: Implement peek method
        if(this.empty())
            throw new EmptyStackException();
        return top.item;
    }

    /**
     * Removes the object at the top of this stack
     * and returns that object as the value of this function
     */
    @Override
    public E pop() throws EmptyStackException {
        // TODO STUDENT: Implement pop method
        if(this.empty())
            throw new EmptyStackException();
        E res=top.item;
        Node n=top;
        top=n.next;
        n.next=null;
        size--;
        return res;
    }

    /**
     * Pushes an item onto the top of this stack
     * @param item the item to append
     */
    @Override
    public void push(E item) {
        // TODO STUDENT: Implement push method
        Node add=new Node(item, top);
        top=add;
        size++;
    }
}
