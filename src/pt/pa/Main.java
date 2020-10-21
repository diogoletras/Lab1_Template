package pt.pa;

import pt.pa.queue.Queue;
import pt.pa.queue.QueueLinkedList;

public class Main {

    public static void main(String[] args) {

        //Queue<Integer> queue = new QueueLinkedList<>();

        Queue<Integer> queue = new QueueLinkedList<>(2);

        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(2);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        //TODO: testar implementação

    }
}
