import java.io.File;

/** Программа просмотра содержимого папки
 */

public class ViewDir {
    public static void main(String[] args) {
        File file = new File("C:\\GeekBrains\\Алгоритмы\\Lesson_1");
        viewDir(file, "");
    }

    private static void viewDir(File rootDir, String prefix) {
        if (rootDir.isFile())
            System.out.println("File: " + prefix + rootDir.getName());
        else {
            System.out.println("Dir: " + prefix + rootDir.getName());
            File[] files = rootDir.listFiles();
            for (File file : files) {
                viewDir(file, prefix + "    ");
            }
        }
    }
}
