/**
 * Функция, проверяющая, является ли заданная строка перестановкой палиндрома
 */

public class PalindromeTransposition {
    public static void main(String[] args) {
        String s = "Tact Coa";
        System.out.println(s + " : " + checkTransposition(s));
    }

    private static boolean checkTransposition(String s) {
        char[] arr = s.toCharArray();
        for (int i = 2; i < arr.length; i++) {
            if (PalindromeCheck.isPalindrome(transport(arr, i)))
                return true;
        }
        return false;
    }

    private static String transport(char[] arr, int i) {
        return arr.toString();
    }
}
