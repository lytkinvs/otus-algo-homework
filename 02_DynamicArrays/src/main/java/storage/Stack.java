package storage;

public class Stack<T> {

    private Node<T> head;

    public Stack() {
        head = null;
    }

    public void push(T item) {
        head = new Node<T>(item, head);
    }

    public T pop() {
        if (isEmpty()) return null;
        T item = head.getItem();
        Node<T> next = head.getNext();
        head = next;
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
