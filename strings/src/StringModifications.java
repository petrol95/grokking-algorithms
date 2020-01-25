/**
 * Функция, проверяющая, находятся ли две строки на расстоянии не более одной модификации друг от друга
 */

public class StringModifications {

    public static void main(String[] args) {
        String[] strings = {"pale", "bale", "pales", "pale", "pale", "ple", "pale", "bake"};
        System.out.println(strings[0] + ", " + strings[1] + ": " + checkModification(strings[0], strings[1]));
        System.out.println(strings[2] + ", " + strings[3] + ": " + checkModification(strings[2], strings[3]));
        System.out.println(strings[4] + ", " + strings[5] + ": " + checkModification(strings[4], strings[5]));
        System.out.println(strings[6] + ", " + strings[7] + ": " + checkModification(strings[6], strings[7]));
    }

    private static boolean checkModification(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        boolean firstMod = false;

        // replacing
        if(chars1.length == chars2.length) {
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] != chars2[i]) {
                    if (firstMod) {
                        return false;
                    } else {
                        firstMod = true;
                    }
                }
            }
        } else {

        }
        return true;
    }
}
