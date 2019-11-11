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



}

