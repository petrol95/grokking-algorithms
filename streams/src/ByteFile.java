import java.io.*;

public class ByteFile {

    public static void main(String[] args) throws IOException {

        byte[] bytes = new byte[51_000];
        OutputStream os = new BufferedOutputStream((new FileOutputStream("streams/byteFile.txt")));
        for (int i = 0; i < 51_000; i++) {
            bytes[i] = 125;
        }
        os.write(bytes);
        os.close();

        InputStream is = new BufferedInputStream(new FileInputStream("streams/byteFile.txt"));
        int x;
        while ((x = is.read()) != -1) {
            System.out.println(x);
        }
        is.close();
    }
}
