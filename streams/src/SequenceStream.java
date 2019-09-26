import java.io.*;
import java.util.*;

/**
 * Последовательно сшить 5 файлов в один (файлы примерно 100 байт)
 */

public class SequenceStream {
    private static final String PATH = "streams\\";
    private static final int FILE_SIZE = 100;

    public static void main(String[] args) throws IOException {

        List<InputStream> al = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            prepareFile(i);
            al.add(new FileInputStream(PATH + i + ".txt"));
        }
        Enumeration<InputStream> e = Collections.enumeration(al);

        int x;
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(PATH + "output.txt"));
             InputStream seq = new SequenceInputStream(e)) {
            while ((x = seq.read()) != -1) {
                out.write(x);
            }
        }
    }

    private static void prepareFile(int i) throws IOException {
        File file = new File(PATH + i + ".txt");
        OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        while(file.length() <= FILE_SIZE) {
            out.write(70 + i);
        }
        out.close();
    }
}