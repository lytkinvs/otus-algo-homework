package sorting;


public class ShellSort implements ISort {
    protected final int[] arr;
    protected int[] gaps;

    public ShellSort(int[] arr, IGap gaps) {
        this.arr = arr;
        this.gaps = gaps.get();
    }

    public void sort() {

        for (var gap : gaps) {
            for (var i = 0; i < arr.length - gap; i++) {
                int j = i + gap;
                int tmp = arr[j];

                while (j - gap >= 0 && tmp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = tmp;
            }
        }
    }
}
