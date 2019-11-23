package sorting;

public class GapNPow4Div3 implements IGap {
    private final int length;

    public GapNPow4Div3(int length) {
        this.length = length;
    }


    @Override
    public int[] get() {
        int counter = 1;
        int gap = 1;

        while (gap < length) {
            if (counter % 2 == 0) {
                gap = 9 * ((int) Math.pow(2, counter) - (int) Math.pow(2, counter / 2)) + 1;
            } else {
                gap = 8 * (int) Math.pow(2, counter) - 6 * (int) Math.pow(2, (counter + 1) / 2) + 1;
            }
            counter++;
        }

        counter -= 1;
        int[] gaps = new int[counter];

        int i = 0;

        while (counter > 0) {
            int k = counter - 1;
            if (k % 2 == 0) {
                gap = 9 * ((int) Math.pow(2, k) - (int) Math.pow(2, k / 2)) + 1;
            } else {
                gap = 8 * (int) Math.pow(2, k) - 6 * (int) Math.pow(2, (k + 1) / 2) + 1;
            }

            gaps[i] = gap;

            counter--;
            i++;
        }


        return gaps;
    }
}
