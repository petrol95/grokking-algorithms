import java.io.*;
import java.util.*;

public class SequenceStream {
    public static final String PATH = "streams\\";

    public static void main(String[] args) throws IOException {

        List<InputStream> al = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            prepareFile(i);
            al.add(new FileInputStream(PATH + i + ".txt"));
        }
        Enumeration<InputStream> e = Collections.enumeration(al);
        OutputStream out = new FileOutputStream(PATH + "output.txt");
        InputStream seq = new SequenceInputStream(e);

        int x;
        try {
            while ((x = seq.read()) != -1) {
                out.write(x);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            seq.close();
        }
    }

    private static void prepareFile(int i) throws IOException {
        File file = new File(PATH + i + ".txt");
        OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        while(file.length() <= 102_400) {
            out.write(70 + i);
        }
        out.close();
    }
}