import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
public class Examples {

    @Test
    public void queueTest(){
        Queue<Integer> q = null; //replace me
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);


        assertEquals(Optional.of(1), q.dequeue());
        assertEquals(Optional.of(2), q.dequeue());
        assertEquals(Optional.of(3), q.peek());
        assertEquals(Optional.of(3), q.dequeue());
        assertEquals(Optional.empty(), q.dequeue());
    }

    public void stackTest(){
        Stack<Integer> stack = null; //replace me
        stack.push(1);
        stack.push(2);
        stack.push(3);


        assertEquals(Optional.of(3), stack.pop());
        assertEquals(Optional.of(2), stack.pop());
        assertEquals(Optional.of(1), stack.peek());
        assertEquals(Optional.of(1), stack.pop());
        assertEquals(Optional.empty(), stack.pop());
    }

    @Test
    public void prioQueueTest(){
        PriorityQueue<Integer> q = null; //replace me
        q.registerVIP(2);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);


        assertEquals(Optional.of(2), q.dequeue());
        assertEquals(Optional.of(1), q.dequeue());
        assertEquals(Optional.of(3), q.peek());
        assertEquals(Optional.of(3), q.dequeue());
        assertEquals(Optional.empty(), q.dequeue());
    }
}
