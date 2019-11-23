package sorting;

public class GapNPow3Div2 implements IGap {
    private final int length;

    public GapNPow3Div2(int length) {
        this.length = length;
    }


    @Override
    public int[] get() {
        int counter = 1;

        int gap = 2 * length / (int) Math.pow(2, counter + 1) + 1;

        while (gap != 1) {
            counter++;
            gap = 2 * length / (int) Math.pow(2, counter + 1) + 1;
        }

        int [] gaps = new int[counter];


        for(int k = 1, i = 0; i < counter; i++, k++) {
            gap = 2 * length / (int) Math.pow(2, k + 1) + 1;
            gaps[i] = gap;
        }


        return gaps;
    }
}
