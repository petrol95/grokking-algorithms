import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadPages {

    public static final String FILE_NAME = "streams\\byteFile.txt";
    public static final int PAGE_SIZE = 1800;


    public static void main(String[] args) throws IOException {

        File file = new File(FILE_NAME);
        BufferedWriter wr = Files.newBufferedWriter(Paths.get(FILE_NAME));
        try {
            for (int j = 1; j < PAGE_SIZE; j++) {
                for (int i = 0; i < PAGE_SIZE; i++) {
                    wr.write("" + j);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            wr.close();
        }

        Scanner sc = new Scanner(System.in);
        RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "r");
        try {
            while (true) {
                System.out.println("Введите номер страницы");
                String msg;
                int num;
                msg = sc.nextLine();
                if (msg.equals("end")) break;
                else {
                    num = Integer.parseInt(msg);
                    raf.seek((num - 1) * PAGE_SIZE);
                    for (int i = 0; i < PAGE_SIZE; i++) {
                        System.out.println((char) raf.read());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода!");
        } finally {
            sc.close();
            raf.close();
        }

    }
}
