
/**
 * Метод, определяющий, является ли одна строка перестановкой другой
 */

public class Transposition {
    public static void main(String[] args) {
        String s1 = "applea";
        String s2 = "leaapp";
        System.out.println("s1 = " + s1 + ", s2 = " + s2 + ": " + checkTransposition(s1, s2));
    }

    private static boolean checkTransposition(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            int j;
            char sym = s1.charAt(i);
            for (j = 0; j < s2.length(); j++) {
                if (sym == s2.charAt(j)) {
                    s2 = s2.replace(sym, ' ');
                    break;
                }
            }
            if (j == s2.length() - 1) {
                return false;
            }
        }
        return true;
    }
}
