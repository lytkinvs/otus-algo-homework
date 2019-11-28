package sorting;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Random;

public class FileHelper {

    public void fillFile() {
        try {
            createFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void createFile() throws Exception {
        Random random = new Random();
        Writer wr = new FileWriter("123.txt");

        for (var i = 0; i < 1000000000; i++) {
            int x = random.nextInt(65535);
            wr.write((char) x);
        }

        wr.close();
    }

}
