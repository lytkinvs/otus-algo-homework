package sorting;

public class QuickSort implements ISort {
    private final int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        quicksort(0, arr.length - 1);
    }

    public void quicksort(int left, int right) {
        if (left >= right) return;

        int center = partition(left, right);

        quicksort(left, center - 1);
        quicksort(center + 1, right);
    }

    private int partition(int left, int right) {

        int counter = left - 1;
        int pivot = arr[right];
        for (var i = left; i <= right; i++) {
            if (arr[i] > pivot) continue;
            counter++;

            int tmp = arr[counter];
            arr[counter] = arr[i];
            arr[i] = tmp;
        }

        return counter;
    }

}
