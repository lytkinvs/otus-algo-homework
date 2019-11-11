package storage;

public class Node<T> {
    private T item;
    private Node<T> next;

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    public Node(T item) {
        this(item, null);
    }

    public T getItem() {
        return item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> item) {
        this.next = item;
    }
}
