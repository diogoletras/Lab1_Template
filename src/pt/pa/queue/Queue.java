package pt.pa.queue;

/**
 *
 * @author 200221114
 * @version 2020-01-21
 */


/**
 * Define a que data structure type.
 *
 * @param <T> The queue element type
 */
public interface Queue<T> {

    /**
     * Enqueue a new element
     *
     * @param elem The element to enqueue
     * @throws QueueFullException When queue is full
     */
    void enqueue(T elem) throws QueueFullException;

    /**
     * Removes the oldest element in the queue, according to insertion order.
     *
     * @return The oldest element in queue
     * @throws QueueEmptyException When queue is empty
     */
    public T dequeue() throws  QueueEmptyException;

    /**
     * Returns the oldest element in the queue, according to the insertion order. It does not remove the element of the queue
     *
     * @return The element in the queue
     * @throws QueueEmptyException When is empty
     */
    public T front() throws QueueEmptyException;

    /**
     * Returns the number of elements in the queue
     *
     * @return The number elements in queue
     */
    public int size();

    /**
     * Indicates weather the queue is empty
     *
     * @return true when queue is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Resets the queue, removing all elements
     */
    public void clear();
}