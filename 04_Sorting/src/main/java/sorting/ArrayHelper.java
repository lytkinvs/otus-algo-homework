package sorting;

import java.util.Random;

public class ArrayHelper {
    public static int[] create(int length) {

        Random random = new Random();
        var arr = new int[length];

        for (var i = 0; i < length; i++) {
            arr[i] = random.nextInt(101);
        }
        return arr;
    }

    public static int[] copy(int[] arr) {
        int[] newArray = new int[arr.length];
        System.arraycopy(arr, 0, newArray, 0, arr.length);
        return newArray;
    }

    public static void mixByPercentage(int[] arr, int percentage) {

        int count = arr.length * percentage/100;

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int indexA = random.nextInt(arr.length);
            int indexB = random.nextInt(arr.length);

            int tmp = arr[indexA];
            arr[indexA] = arr[indexB];
            arr[indexB] = tmp;
        }
    }

    public static void mixByNumber(int[] arr, int number) {

        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int indexA = random.nextInt(arr.length);
            int indexB = random.nextInt(arr.length);

            int tmp = arr[indexA];
            arr[indexA] = arr[indexB];
            arr[indexB] = tmp;
        }

    }
}
