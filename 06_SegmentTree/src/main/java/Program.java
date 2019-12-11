import java.io.*;

public class Program {

    public static void main(String args[]) throws IOException {
        parseInput();
    }


    public static void parseInput() throws IOException {

        File file = new File("sum.in");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        st = br.readLine();

        String[] splittedInput = st.split(" ");

        int N = Integer.parseInt(splittedInput[0]);
        int K = Integer.parseInt(splittedInput[1]);

        String[] queryList = new String[K];

        int counter = 0;

        while ((st = br.readLine()) != null) {
            queryList[counter] = st;
            counter++;
        }

        int power = 0;

        for (int s = 1; s <= N; s *= 2) {
            power++;
        }

        int length = (int) Math.pow(2, power + 1);

        int[] array = new int[length];

        int startIndex = length / 2;
        int queryCounter = 0;

        for (String query : queryList) {
            splittedInput = query.split(" ");
            char queryType = splittedInput[0].charAt(0);

            int L = Integer.parseInt(splittedInput[1]);
            int R = Integer.parseInt(splittedInput[2]);

            if (queryType != 'A') break;

            int index = startIndex + L - 1;
            array[index] = R;
            queryCounter++;
        }

        for (int i = startIndex - 1; i > 0; i--) {
            int l = array[i * 2];
            int r = array[i * 2 + 1];
            array[i] = l + r;
        }


        FileWriter wr = new FileWriter("sum.out");

        for (int i = 0; (i + queryCounter) < queryList.length; i++) {
            splittedInput = queryList[i + queryCounter].split(" ");
            int L = Integer.parseInt(splittedInput[1]);
            int R = Integer.parseInt(splittedInput[2]);

            int sum = getSum(L, R, array, startIndex);
            wr.write(sum + "\r\n");
        }

        wr.close();
    }

    public static int getSum(int L, int R, int[] array, int startIndex) {

        L = startIndex + L - 1;
        R = startIndex + R - 1;

        int sum = 0;
        while (R >= L) {
            if (L % 2 != 0) sum += array[L];
            if (R % 2 == 0) sum += array[R];

            L = (L + 1) / 2;
            R = (R - 1) / 2;
        }
        return sum;
    }
}


