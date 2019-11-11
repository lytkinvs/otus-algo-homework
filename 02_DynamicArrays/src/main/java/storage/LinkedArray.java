package storage;

public class LinkedArray<T> implements IArray<T> {

    private Queue<T> queue;
    private int size;

    public LinkedArray() {
        this.queue = new Queue<>();
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        queue.enqueue(item);
        size++;
    }

    @Override
    public T get(int index) {
        if (index >= size) return null;

        Node<T> curr = queue.getHead();

        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }

        return curr.getItem();
    }

    @Override
    public void add(T item, int index) {
        if (index > size() || index < 0) return;

        Node<T> curr = queue.getHead();

        if(index == 0) {
            var q = new Queue<T>();
            q.enqueue(item);
            var node = q.getHead();
            node.setNext(curr);
            queue = q;
            size++;
            return;
        }

        for (int i = 0; i < index - 1; i++) {
            curr = curr.getNext();
        }

        var next = curr.getNext();

        Node<T> node = new Node<T>(item);

        curr.setNext(node);

        if (next != null) {
            node.setNext(next);
        }

        size++;

    }

    @Override
    public T remove(int index) {
        if (index > size() || index < 0) return null;

        Node<T> curr = queue.getHead();

        if (index == 0) {
            var q = new Queue<T>();

            var next = curr.getNext();

            if (next != null) {
                q.enqueue(next.getItem());
                var h = q.getHead();
                h.setNext(next.getNext());
            }

            queue = q;
            size--;
            return curr.getItem();
        }


        for (int i = 0; i < index - 1; i++) {
            curr = curr.getNext();
        }

        var forRemove = curr.getNext();

        if(forRemove == null) {
            return null;
        }

        var next = forRemove.getNext();

        if(next != null) {
            curr.setNext(next);
        }

        size--;
        return forRemove.getItem();
    }
}
