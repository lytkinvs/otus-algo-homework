package storage;


public class MatrixArray<T> implements IArray<T> {

    private int size;
    private int vector;

    private FactorArray<VectorArray<T>> array;

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new FactorArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(100);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.size() * vector) {
            array.add(new VectorArray<>(vector));
        }
        int index = size();
        array.get(index / vector).add(item);
        size++;
    }

    @Override
    public T get(int index) {
        return array.get(index / vector).get(index % vector);
    }
}
