package sorting;

public class MergeSort implements ISort {
    private final int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        mergesort(0, arr.length - 1);
    }

    void mergesort(int left, int right) {
        if (left >= right) return;

        int center = left + (right - left) / 2;

        mergesort(left, center);
        mergesort(center + 1, right);

        merge(left, center, right);
    }


    public void merge(int left, int center, int right) {
        int[] res = new int[right - left + 1];

        int a = left;
        int b = center + 1;
        int r = 0;

        while (a <= center && b <= right) {
            if (arr[a] < arr[b]) {
                res[r++] = arr[a++];
            } else {
                res[r++] = arr[b++];
            }
        }

        while (a <= center) {
            res[r++] = arr[a++];
        }

        while (b <= right) {
            res[r++] = arr[b++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = res[i - left];
        }

    }
}
