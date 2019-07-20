import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.BufferedInputStream;

class TestClasses {
    public static void main(String[] args) {
        Test.testString(120000);
        Test.testStringBuilder(120000);
        System.out.println();

        Test.testFileReader("C:\\KMPlayer\\KMPlayer.exe");
        Test.testBufferedReader("C:\\KMPlayer\\KMPlayer.exe");
        System.out.println();

        Test.testFileInputStream("C:\\KMPlayer\\KMPlayer.exe");
        Test.testBufferedInputStream("C:\\KMPlayer\\KMPlayer.exe");
    }
}

class Test{

    // testing String
    static void testString(int cycles) {
        System.out.println("Testing String...");
        long t1 = System.currentTimeMillis();
        String str = "";

        for(int i = 0; i < cycles; i++)
            str += "w";

        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) + " ms");
    }

    // testing StringBuilder
    static void testStringBuilder(int cycles) {
        System.out.println("Testing StringBuilder...");
        long t1 = System.currentTimeMillis();

        StringBuilder str = new StringBuilder("");
        for(int i = 0; i < cycles; i++)
            str.append("w");

        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) + " ms");
    }

    // testing FileReader, reading streams of characters
    static void testFileReader(String fileName) {
        System.out.println("Testing FileReader...");
        long t1 = System.currentTimeMillis();

        try(FileReader file = new FileReader(fileName)) {
            int x = -1;
            do
                x = file.read();
            while (x != -1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) + " ms");
    }

    // testing BufferedReader, reading streams of characters
    static void testBufferedReader(String fileName) {
        System.out.println("Testing BufferedReader...");
        long t1 = System.currentTimeMillis();

        try(BufferedReader file = new BufferedReader(new FileReader(fileName))) {
            int x = -1;
            do
                x = file.read();
            while (x != -1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) + " ms");
    }

    // testing FileInputStream, reading streams of raw bytes
    static void testFileInputStream(String fileName) {
        System.out.println("Testing FileInputStream...");
        long t1 = System.currentTimeMillis();

        try(FileInputStream file = new FileInputStream(fileName)) {
            int x = -1;
            do
                x = file.read();
            while (x != -1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) + " ms");
    }

    // testing BufferedInputStream, reading streams of raw bytes
    static void testBufferedInputStream(String fileName) {
        System.out.println("Testing BufferedInputStream...");
        long t1 = System.currentTimeMillis();

        try(BufferedInputStream file = new BufferedInputStream(new FileInputStream(fileName))) {
            int x = -1;
            do
                x = file.read();
            while (x != -1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) + " ms");
    }
}