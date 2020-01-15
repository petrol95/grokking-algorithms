/**
 * Метод, заменяющий все пробелы в строке в строке символами '%20'.
 * Ввод - строка, через запятую - длина строки
 */

public class Replacement {
    public static void main(String[] args) {
        String s = "Mr John Smith   ";
        int size = 13;
        System.out.println(s + ": " + replaceString(s, size));
    }

    private static String replaceString(String s, int size) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < size; i++) {
            if (arr[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
