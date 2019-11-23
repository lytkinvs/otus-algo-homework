package sorting;

public class HeapSort implements ISort {
    private final int[] arr;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    private void swap(int x, int y) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    private void down(int size, int n) {

        var left = 2 * n + 1;
        var right = left + 1;

        int X = n;

        if (left < size && arr[left] > arr[X]) X = left;
        if (right < size && arr[right] > arr[X]) X = right;

        if (X == n) return;

        swap(n, X);

        down(size, X);
    }

    public void sort() {

        for (int node = arr.length / 2 - 1; node >= 0; node--)
            down(arr.length, node);

        for (var i = arr.length - 1; i >= 0; i--) {
            swap(0, i);
            down(i, 0);
        }
    }

}
