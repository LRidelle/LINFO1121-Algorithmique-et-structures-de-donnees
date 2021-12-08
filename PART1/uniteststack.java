import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.EmptyStackException;


public class StackTests {

    @Test
    public void firstTest() {
        Stack<Integer> stack = new MyStack<Integer>();
        stack.push(1);
        assertEquals(new Integer(1), stack.pop());
        stack.push(2);
        assertEquals(new Integer(2), stack.pop());
        stack.push(3);
        assertEquals(new Integer(3), stack.pop());
        stack.push(4);
        assertEquals(new Integer(4), stack.pop());
        stack.push(5);
        assertEquals(new Integer(5), stack.pop());
        stack.push(6);
        assertEquals(new Integer(6), stack.pop());
        stack.push(7);
        stack.push(8);
        stack.push(9);
        assertEquals(new Integer(9), stack.pop());
        assertEquals(new Integer(8), stack.pop());
        assertEquals(new Integer(7), stack.pop());
        assertTrue(stack.empty());

        stack.push(1);
        assertEquals(new Integer(1), stack.peek());
        stack.push(2);
        assertEquals(new Integer(2), stack.peek());
        stack.push(3);
        assertEquals(new Integer(3), stack.peek());
        stack.push(4);
        assertEquals(new Integer(4), stack.peek());
        stack.push(5);
        assertEquals(new Integer(5), stack.peek());
        stack.push(6);
        assertEquals(new Integer(6), stack.pop());
        assertEquals(new Integer(5), stack.pop());
        assertEquals(new Integer(4), stack.pop());
        assertEquals(new Integer(3), stack.pop());
        assertEquals(new Integer(2), stack.pop());
        assertEquals(new Integer(1), stack.pop());



    }


  //  @Test
  //  public void secondTest() {
  //    Stack<Integer> stack = new MyStack<Integer>();
  //
  //    }


     @Test(expected = EmptyStackException.class)
    public void thirdTest() {
        Stack<Integer> stack = new MyStack<Integer>();
        stack.push(1);
        stack.pop();
        stack.push(2);
        stack.pop();
        stack.pop();
}

     @Test(expected = EmptyStackException.class)
     public void fourthTest() {
        Stack<Integer> stack = new MyStack<Integer>();
        stack.push(1);
        stack.pop();
        stack.push(2);
        stack.pop();
        stack.peek();
    }


}
