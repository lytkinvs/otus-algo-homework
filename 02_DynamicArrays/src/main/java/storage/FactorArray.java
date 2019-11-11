package storage;

public class FactorArray<T> implements IArray<T> {

    private T[] array;
    private int factor;
    private int size;

    public FactorArray(int factor) {
        array = (T[]) new Object[10];
        this.factor = factor;
    }

    public FactorArray() {
        this(100);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length) {
            array = resize(array, size() * factor / 100);
        }
        array[size] = item;
        size++;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

}


