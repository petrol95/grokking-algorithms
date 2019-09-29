import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Написать небольшой метод, в котором 3 потока построчно пишут данные в файл (по 10 записей с периодом в 20 мс)
 */

public class WriteFile {

    public static final int COUNT = 10;

    public static void main(String[] args) throws IOException, InterruptedException {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
                "threads/output.txt", false)))) {
            service.scheduleAtFixedRate(() -> write(out, "AAAAAAAAAA"), 0, 20, TimeUnit.MILLISECONDS);
            service.scheduleAtFixedRate(() -> write(out, "BBBBBBBBBB"), 0, 20, TimeUnit.MILLISECONDS);
            service.scheduleAtFixedRate(() -> write(out, "CCCCCCCCCC"), 0, 20, TimeUnit.MILLISECONDS);
            Thread.sleep(1000);
        }
        service.shutdown();

//        // вариант 2
//        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
//                "threads/output.txt", false)))) {
//            Thread t1 = new Thread(() -> {
//            try {
//                write(out, "AAAAAAAAAA");
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            try {
//                write(out, "BBBBBBBBBB");
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        Thread t3 = new Thread(() -> {
//            try {
//                write(out, "CCCCCCCCCC");
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t1.start();
//        t2.start();
//        t3.start();
//        t1.join();
//        t2.join();
//        t3.join();
//        }
    }

    private static void write(PrintWriter out, String s) {
        for (int i = 0; i < COUNT; i++) {
            out.println(s);
        }
    }
}
