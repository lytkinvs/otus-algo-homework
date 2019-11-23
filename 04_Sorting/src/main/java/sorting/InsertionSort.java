package sorting;

public class InsertionSort implements ISort {
    private final int[] arr;

    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {

        for (var i = 0; i < arr.length - 1; i++) {
            int j = i - 1;
            int x = arr[i];
            while (j >= 0 && arr[j] > x) {
                var temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }
}
