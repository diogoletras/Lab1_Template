package pt.pa.queue;

public class QueueFullException extends RuntimeException{
    public QueueFullException (){
        super("The queue is empty.");
    }
}
