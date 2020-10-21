package pt.pa.queue;

public class QueueLinkedList<T> implements Queue<T> {
    private Node header;
    private Node current;
    private int size;
    private int capacity;

    public QueueLinkedList(int capacity){
        this.header = new Node(null, null);
        this.current = this.header;
        this.size = 0;
        this.capacity = capacity;
    }

    @Override
    public int size() {//1-2-3-4-5-6-7-8-9
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(this.size!=0)
            return false;
        return true;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public void enqueue(T elem) throws QueueFullException {
        if(size >= capacity) throw new QueueFullException();

        Node newNode = new Node(elem, header);

        if (header.element == null || size == 0)
            header = newNode;

        this.current.next = newNode;

        this.size++;

        this.current = newNode;
    }

    @Override
    public T dequeue() throws QueueEmptyException {

        if(this.size == 0) throw new QueueEmptyException();

        Node returnNode = this.header;

        this.header = returnNode.next;

        this.size--;

        returnNode.next = null;

        return returnNode.element;
    }

    @Override
    public T front() throws QueueEmptyException {
        if(this.size == 0) throw new QueueEmptyException();

        return header.element;
    }

    private class Node {
        private T element;
        private Node next;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
