import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Написать консольное приложение которое умеет постранично читать текстовые файлы (размером > 10 Mb).
 * Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
 * Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чеение - занимать свыше 5 секунд.
 */

public class ReadPages {

    private static final String FILE_NAME = "streams\\bigFile.txt";
    private static final int FILE_SIZE = 10 * 1024 * 1024; // bytes
    private static final int PAGE_SIZE = 1800; // symbols

    public static void main(String[] args) throws IOException {

        System.out.println("Preparing file : " + now());

        File file = new File(FILE_NAME);
        BufferedWriter wr = Files.newBufferedWriter(Paths.get(FILE_NAME));
        int pageNum = 0;
        try {
            for (pageNum = 1; file.length() < FILE_SIZE; pageNum++) {
                for (int i = 0; i < PAGE_SIZE; i++) {
                    wr.write("" + pageNum % 10);
                }
            }
            pageNum--;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            wr.close();
        }

        System.out.println("File prepared : " + now());

        try (Scanner sc = new Scanner(System.in);
             RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "r")) {
            while (true) {
                System.out.println("Введите номер страницы (1..." + pageNum + "):");
                String msg = sc.nextLine();
                if (msg.equals("end")) break;
                else {
                    int num = Integer.parseInt(msg);
                    if (num < 0 || num > pageNum) {
                        System.out.println("Введен неверный номер страницы!");
                        break;
                    }
                    raf.seek((num - 1) * PAGE_SIZE);
                    System.out.println("Reading page : " + now());
                    for (int i = 0; i < PAGE_SIZE; i++) {
                        System.out.print((char) raf.read());
                    }
                    System.out.println();
                    System.out.println("Page reading finished : " + now());
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода!");
        }
    }

    private static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:MM:ss"));
    }
}
