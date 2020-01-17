/**
 * Функция, проверяющая, является ли заданная строка перестановкой палиндрома
 */

public class PalindromeTransposition {
    public static void main(String[] args) {
        String s = "Tact Coa";
        System.out.println(s + " : " + checkTransposition(s, 2));
    }

    private static boolean checkTransposition(String s, int pos) {
        if (pos == s.length())
            return false;
        if (PalindromeCheck.isPalindrome(s))
            return true;
        else {
            String string1 = s.substring(0, pos);
            String string2 = s.substring(pos, s.length());
            char[] arr = string1.toCharArray();

            for (int i = 0; i < arr.length - 1; i++) {
                arr = transport(arr, i);
                String newString = arr.toString() + string2;
                if (PalindromeCheck.isPalindrome(newString))
                    return true;
                checkTransposition(newString, pos + 1);
            }
        }
        return false;
    }

    private static char[] transport(char[] arr, int pos) {
        switch (pos) {
            case 0:
                return swap(arr, arr.length - 2, arr.length - 1);
            case 1:
                return swap(arr, arr.length - 1, 0);
            default:
                return swap(arr, pos - 2, pos - 1);
        }
    }

    private static char[] swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
