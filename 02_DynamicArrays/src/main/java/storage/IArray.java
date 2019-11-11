package storage;

public interface IArray<T> {
    int size();

    void add(T item);

    T get(int index);

    void add(T item, int index);

    T remove(int index);

    default T[] resize(T[] array, int delta) {
        T[] newArray = (T[]) new Object[size() + delta];
        System.arraycopy(array, 0, newArray, 0, size());
        return newArray;
    }
}
