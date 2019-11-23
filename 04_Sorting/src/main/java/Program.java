import sorting.*;


class Program {

    public static void main(String args[]) {

        testHeapSortAndShellSort();

    }


    public static void testHeapSortAndShellSort() {

        int length = 100000000;

        var arr1 = ArrayHelper.create(length);
        var arr2 = ArrayHelper.copy(arr1);
        var arr3 = ArrayHelper.copy(arr1);


        var shell1 = new ShellSort(arr1, new GapNPow2(length));
        var shell2 = new ShellSort(arr2, new GapNPow4Div3(length));
        var heap = new HeapSort(arr3);

        testSort(shell1, "");
        testSort(shell2, "");
        testSort(heap, "");

        System.out.println("############");
        System.out.println("After sorting and mixing by 5 percent");

        ArrayHelper.mixByPercentage(arr1, 5);

        var sorted1 = ArrayHelper.copy(arr1);
        var sorted2 = ArrayHelper.copy(sorted1);
        var sorted3 = ArrayHelper.copy(sorted1);

        shell1 = new ShellSort(sorted1, new GapNPow2(length));
        shell2 = new ShellSort(sorted2, new GapNPow4Div3(length));
        heap = new HeapSort(sorted3);


        testSort(shell1, "");
        testSort(shell2, "");
        testSort(heap, "");


    }


    public static void testShellSort() {

        int length = 100000000;

        var initArr = ArrayHelper.create(length);
        var sortArr = ArrayHelper.copy(initArr);

        var shellSortNPow2 = new ShellSort(sortArr, new GapNPow2(length));
        shellSortNPow2.sort();

        testShellSortImpl(initArr, sortArr, new GapNPow2(length));

        System.out.println();

        testShellSortImpl(initArr, sortArr, new GapNPow3Div2(length));

        System.out.println();

        testShellSortImpl(initArr, sortArr, new GapNPow4Div3(length));


    }

    public static void testShellSortImpl(int[] randomIn, int[] sortedIn, IGap gapClass) {

        int[] random = ArrayHelper.copy(randomIn);
        int[] sorted = ArrayHelper.copy(sortedIn);


        var mixedByPrcArr = ArrayHelper.copy(sorted);
        ArrayHelper.mixByPercentage(mixedByPrcArr, 10);

        var mixedByNumArr = ArrayHelper.copy(sorted);
        ArrayHelper.mixByNumber(mixedByNumArr, 5);


        System.out.println("############");
        var shellSortRandom = new ShellSort(random, gapClass);
        testSort(shellSortRandom, "");

        System.out.println("############");
        var shellSortMixedByPrc = new ShellSort(mixedByPrcArr, gapClass);
        testSort(shellSortMixedByPrc, "");

        System.out.println("############");
        var shellSortMixedByNum = new ShellSort(mixedByNumArr, gapClass);
        testSort(shellSortMixedByNum, "");
    }


    public static void testSort(ISort sort, String description) {

        long start = System.currentTimeMillis();

        sort.sort();

        long duration = System.currentTimeMillis() - start;

        System.out.println(
            "Execute: " + sort +
                " " + description +
                " " + duration + " ms"
        );
    }

    public static void printArray(int[] arr) {

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

}
