package pt.pa.queue;

public class QueueEmptyException extends RuntimeException{
    public QueueEmptyException(){
        super("The queue has no elements to retrieve.");
    }
}
