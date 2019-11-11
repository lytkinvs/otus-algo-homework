package storage;

public class VectorArray<T> implements IArray<T> {

    private T[] array;
    private int vector;
    private int size;


    public VectorArray(int vector) {
        array = (T[]) new Object[0];
        this.vector = vector;
    }

    public VectorArray() {
        this(100);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length) {
            array = resize(array, vector);
        }
        array[size] = item;
        size++;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

}


