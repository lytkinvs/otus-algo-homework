package sorting;

public class BubbleSort implements ISort {
    private final int[] arr;

    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {

        for (var i = 0; i < arr.length; i++) {
            for (var j = arr.length - 2; j >= i; j--) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }
}
