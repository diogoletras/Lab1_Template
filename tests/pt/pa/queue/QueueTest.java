package pt.pa.queue;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class QueueTest {

    private Queue<Integer> queue;
    @BeforeEach
    void setUp() {
        queue = new QueueLinkedList<>(40);
    }

    @Test
    void size() {
        Integer result = 0;
        assertEquals(result, queue.size());
        queue.enqueue(5);
        result = 1;
        assertEquals(result, queue.size());
        queue.dequeue();
        result = 0;
        assertEquals(result, queue.size());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty(), "stack is not empty");
        queue.enqueue(5);
        assertFalse(queue.isEmpty());
    }

    @Test
    void clear() {
        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @Test
    void enqueue() {
        queue.enqueue(1);
        queue.enqueue(6);
        Integer result=1;
        assertEquals(result, (Integer) queue.front());
        result=2;
        assertEquals(result, (Integer) queue.size());
    }

    @Test
    void dequeue() {
        queue.enqueue(5);
        queue.enqueue(6);
        Integer result=5;
        assertEquals(result, (Integer) queue.dequeue());
        result=6;
        assertEquals(result, (Integer) queue.dequeue());
    }

    @Test
    void front() {
        queue.enqueue(5);
        Integer result=5;
        assertEquals(result, (Integer) queue.front());
    }
}