package sorting;

public class SelectionSort implements ISort {
    private final int[] arr;

    public SelectionSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        for (var i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (var j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            var temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
