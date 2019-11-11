package storage;

public class SingleArray<T> implements IArray<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public SingleArray() {
        array = (T[]) new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        array = resize(array, 1);
        array[size() - 1] = item;
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
    }

    @Override
    public T remove(int index) {
        if (index > size() || index < 0) return null;

        var item = array[index];

        var newArray = (T[]) new Object[size() - 1];

        System.arraycopy(array, 0, newArray, 0, index);

        System.arraycopy(array, index + 1, newArray, index, size() - index - 1);

        array = newArray;

        return item;
    }
}
