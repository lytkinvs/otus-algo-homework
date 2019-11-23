package sorting;

public class GapNPow2 implements IGap {
    private final int length;

    public GapNPow2(int length) {
        this.length = length;
    }


    @Override
    public int[] get() {
        int counter = 1;
        int gap = length / 2;

        while (gap / 2 > 0) {
            counter++;
            gap /= 2;
        }

        int[] gaps = new int[counter];

        gap = length / 2;
        for (int i = 0; i < counter; i++) {
            gaps[i] = gap;
            gap /= 2;
        }

        return gaps;
    }
}
