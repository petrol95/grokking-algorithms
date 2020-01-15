/**
 * Функция, проверяющая, что строки являются анаграммами
 */

public class AnagramCheck {

    public static void main(String[] args) {
        String s1 = "лепесток", s2 = "телескоп";
        String s3 = "thing", s4 = "NiGht";
        String s5 = "wrong", s6 = "answer";
        String s7 = "applea", s8 = "leaapp";

        System.out.println(s1 + ", " + s2 + ": " + isAnagram(s1, s2));
        System.out.println(s3 + ", " + s4 + ": " + isAnagram(s3, s4));
        System.out.println(s5 + ", " + s6 + ": " + isAnagram(s5, s6));
        System.out.println(s7 + ", " + s8 + ": " + checkTransposition(s7, s8));
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] arr = s1.toCharArray();
        s2 = s2.toLowerCase();
        for (char c : arr) {
            String str = Character.toString(c).toLowerCase();
            if (s2.contains(str))
                s2 = s2.replaceFirst(str, "");
            else
                return false;
        }
        return true;
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
