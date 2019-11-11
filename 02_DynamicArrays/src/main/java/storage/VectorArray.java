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

    @Override
    public void add(T item, int index) {
        if (index > size() || index < 0) return;

        var newArray = (T[]) new Object[size() + 1];

        System.arraycopy(array, 0, newArray, 0, index);

        newArray[index] = item;

        System.arraycopy(array, index, newArray, index + 1, size() - index);

        array = newArray;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index > size() || index < 0) return null;

        var item = array[index];

        var newArray = (T[]) new Object[size() - 1];

        System.arraycopy(array, 0, newArray, 0, index);

        System.arraycopy(array, index + 1, newArray, index, size() - index - 1);

        array = newArray;
        size--;

        return item;
    }
}
