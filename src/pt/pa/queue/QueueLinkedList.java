package pt.pa.queue;

import java.lang.reflect.Executable;

public class QueueLinkedList<T> implements Queue<T> {
    private Node header;
    private Node trailer;
    private int size;
    private int capacity;

    public QueueLinkedList(int capacity){
        clear();
        this.capacity = capacity;
    }

    /**
     * Enqueue a new element
     *
     * @param element The element to enqueue
     * @throws QueueFullException When queue is full
     */
    @Override
    public void enqueue(T element) throws QueueFullException {
        if (this.size() == this.capacity)
            throw new QueueFullException();
        Node node = new Node(element, this.header, this.header.getNext());
        this.header.getNext().setPrev(node);
        this.header.setNext(node);
        this.size++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {

        if(this.isEmpty()){
            throw new QueueEmptyException();
        }

        Node node = this.trailer.getPrev();
        node.getPrev().setNext(this.trailer);
        trailer.setPrev(node.getPrev());
        this.size--;
        return  node.getElement();
    }

    @Override
    public T front() throws QueueEmptyException {
        if(this.isEmpty())
            throw new QueueEmptyException();
        return this.trailer.getPrev().getElement();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void clear() {
        this.header = new Node(null, null, null);
        this.trailer = new Node(null, this.header, null);
        this.header.setNext(this.trailer);
        this.size = 0;
    }

    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public T getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
