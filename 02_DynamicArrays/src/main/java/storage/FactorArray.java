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

    public void set(T item, int index) {
        this.array[index] = item;
    }
}
