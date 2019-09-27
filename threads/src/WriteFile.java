import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Написать небольшой метод, в котором 3 потока построчно пишут данные в файл (по 10 записей с периодом в 20 мс)
 */

public class WriteFile {

    static BufferedWriter wr;

    public static void main(String[] args) throws IOException, InterruptedException {

        wr = new BufferedWriter(new FileWriter("threads/output.txt", true));

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    write("AAAAAAAAAA");
                    Thread.sleep(20);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    write("BBBBBBBBBB");
                    Thread.sleep(20);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    write("CCCCCCCCCC");
                    Thread.sleep(20);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(3000);
        wr.close();
    }

    private static synchronized void write(String s) throws IOException {
        wr.write(s);
        wr.newLine();
    }
}
