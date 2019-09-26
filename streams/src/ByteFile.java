import java.io.*;
import java.io.FileInputStream;

/**
 * Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль
 */

public class ByteFile {

    private static final String FILE_NAME = "streams\\byteFile.txt";
    private static OutputStream os;
    private static FileInputStream is;

    public static void main(String[] args) throws IOException {

        try {
            byte[] bytesIn = new byte[50];
            byte[] bytesOut = new byte[50];

            os = new FileOutputStream(FILE_NAME);
            for (int i = 0; i < bytesIn.length; i++) {
                bytesIn[i] = (byte) i;
            }
            os.write(bytesIn);

            is = new FileInputStream(FILE_NAME);
            is.read(bytesOut);
            System.out.println("Read " + bytesOut.length + " bytes");

            for (byte b : bytesOut) {
                System.out.print(b + " ");
            }
        } finally {
            os.close();
            is.close();
        }
    }
}
