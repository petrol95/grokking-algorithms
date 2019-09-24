import java.io.*;

public class ByteFile {

    public static final String FILE_NAME = "streams\\byteFile.txt";

    public static void main(String[] args) throws IOException {

        byte[] bytesIn = new byte[50_000];
        byte[] bytesOut = new byte[50_000];

        OutputStream os = new BufferedOutputStream((new FileOutputStream(FILE_NAME)));
        for (int i = 0; i < bytesIn.length; i++) {
            bytesIn[i] = 125;
        }
        os.write(bytesIn);
        os.close();

        InputStream is = new BufferedInputStream(new FileInputStream(FILE_NAME));
        is.read(bytesOut);
        is.close();
        for (int i = 0; i < bytesOut.length; i++) {
            System.out.println(bytesOut[i]);
        }
    }
}
