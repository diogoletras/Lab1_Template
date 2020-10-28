package pt.pa.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

class QueueLinkedListTest {

    private Queue<String> queue;

    @BeforeEach
    public void setUp(){
        this.queue = new QueueLinkedList<>(10);
    }

    public void insertElem(int numElem){
        for (int i=0; i<numElem; i++){
            queue.enqueue("Element "+i);
        }
    }

    @Test
    void enqueue() throws QueueEmptyException, QueueFullException {
        queue.enqueue("PA");
        assertEquals("PA", queue.front());
        assertEquals(1, queue.size());
        assertThrows(QueueFullException.class, () -> insertElem(10));
    }

    @Test
    void dequeue() throws QueueEmptyException, QueueFullException {
        queue.enqueue("PA");
        assertEquals("PA", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    void dequeue_if_list_is_empty(){
        assertThrows(QueueEmptyException.class, () -> queue.dequeue());
    }

    @Test
    void front() throws QueueFullException, QueueEmptyException{
        assertThrows(QueueEmptyException.class, () -> queue.front());
        queue.enqueue("PA");
        assertEquals("PA", queue.front());
        queue.enqueue("ESTS");
        assertEquals("PA", queue.front());
    }

    @Test
    void size() throws QueueFullException{
        assertEquals(0, queue.size());
        queue.enqueue("PA");
        assertEquals(1, queue.size());
        queue.enqueue("ESTS");
        queue.enqueue("IPS");
        assertEquals(3, queue.size());
        queue.dequeue();
        assertEquals(2, queue.size());
        queue.clear();
        assertEquals(0, queue.size());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue("PA");
        assertFalse(queue.isEmpty());
    }

    @Test
    void clear() {
        queue.enqueue("PA");
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

}