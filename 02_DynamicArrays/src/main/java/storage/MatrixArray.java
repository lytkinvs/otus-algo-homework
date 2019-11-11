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

    @Override
    public void add(T item, int index) {
        if (index >= size() || index < 0) return;

        if (size() == array.size() * vector) {
            array.add(new VectorArray<>(vector));
        }

        int currentIndex = index / vector;

        for (var i = size / vector; i > currentIndex; i--) {

            var lastItemFromPrev = array.get(i - 1).get(vector - 1);
            array.get(i).add(lastItemFromPrev, 0);
        }

        array.get(currentIndex).add(item, index % vector);

        if (index + 1 < size) {
            array.get(currentIndex).remove(array.get(currentIndex).size() - 1);
        }

        size++;
    }

    @Override
    public T remove(int index) {
        if (index >= size() || index < 0) return null;

        var item = get(index);

        var currentArray = array.get(index / vector);
        currentArray.remove(index % vector);
        size--;

        for (var i = index / vector; i < size / vector; i++) {

            var currentA = array.get(i);
            var nextArray = array.get(i + 1);
            if(nextArray == null) break;

            var nextValue = nextArray.get(0);
            currentA.add(nextValue);
            nextArray.remove(0);
            if(nextArray.size() == 0)  {
                array.remove(i + 1);
            }
        }

        return item;
    }
}
