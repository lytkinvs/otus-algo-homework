package storage;

public class PriorityQueue<T> {
    private class PriorityQueuePair {
        private int priority;
        private Queue<T> queue;
    }

    private VectorArray<PriorityQueuePair> array;

    public PriorityQueue() {
        array = new VectorArray<>();
    }

    public void enqueue(T item, int priority) {

        for (int i = 0; i < array.size(); i++) {
            var pair = array.get(i);

            if(pair.priority == priority) {
                pair.queue.enqueue(item);
                return;
            }
            if(pair.priority < priority) {
                var newPair = new PriorityQueuePair();
                newPair.priority = priority;
                newPair.queue = new Queue<>();
                newPair.queue.enqueue(item);
                array.add(newPair, i);
                return;
            }
        }

        var newPair = new PriorityQueuePair();
        newPair.priority = priority;
        newPair.queue = new Queue<>();
        newPair.queue.enqueue(item);
        array.add(newPair);

    }

    public T dequeue() {

        var item = array.get(0).queue.dequeue();
        if(array.get(0).queue.isEmpty()) {
            array.remove(0);
        }


        return item;
    }

    public boolean isEmpty() {
        return array.size() == 0;
    }
}
