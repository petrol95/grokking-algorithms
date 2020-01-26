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
        boolean ifExistModification = false;

        if(chars1.length == chars2.length) {        // replace check
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] != chars2[i]) {
                    if (ifExistModification) {
                        return false;
                    } else {
                        ifExistModification = true;
                    }
                }
            }
        } else if (Math.abs(chars1.length - chars2.length) == 1) {      // add or delete check
            int i = 0;
            int j = 0;
            while (i < chars1.length && j < chars2.length) {
                if (chars1[i] == chars2[j]) {
                    i++;
                    j++;
                } else {
                    if (ifExistModification) {
                        return false;
                    } else {
                        ifExistModification = true;
                        if (chars1[i] == chars2[j + 1]) {
                            j++;
                        }
                        if (chars1[i + 1] == chars2[j]) {
                            i++;
                        }
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
