import java.util.HashSet;
import java.util.Set;

/**
 * Функция, проверяющая, что все символы в строке встречаются только один раз
 */

public class SingleOccurrence {

    public static void main(String[] args) {
        String s1 = "beautiful";
        String s2 = "answer";
        String s3 = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(s1 + ": " + checkOccurrence(s1) + "/" + checkOccurrenceWithoutStructures(s1));
        System.out.println(s2 + ": " + checkOccurrence(s2) + "/" + checkOccurrenceWithoutStructures(s2));
        System.out.println(s3 + ": " + checkOccurrence(s3) + "/" + checkOccurrenceWithoutStructures(s3));
    }

    private static boolean checkOccurrence(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size() == s.length();
    }

    private static boolean checkOccurrenceWithoutStructures(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    return false;
            }
        }
        return true;
    }
}
