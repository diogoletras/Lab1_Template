package pt.pa.queue;

/**
 *
 * @author 200221114
 * @version 2020-01-21
 */

public interface Queue<T> {

    /**
     *
     * @return count of number of elements in Queue
     */
    public int size();

    /**
     *
     * @return true if Queue is emptry / false if Queue is not empty
     */
    public boolean isEmpty();

    /**
     * Removes every element of Queue
     */
    public void clear();

    void enqueue(T elem) throws QueueFullException;

    public T dequeue() throws  QueueEmptyException;

    public T front() throws QueueEmptyException;
}