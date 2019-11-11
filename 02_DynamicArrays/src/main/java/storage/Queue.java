package storage;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void enqueue(T item) {
        Node<T> node = new Node<T>(item);

        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public T dequeue() {
        if (tail == null) return null;

        T item = head.getItem();
        head = head.getNext();
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
