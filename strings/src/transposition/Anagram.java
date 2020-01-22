package transposition;

/**
 * Функция, проверяющая, является ли заданная строка перестановкой палиндрома
 */

public class Anagram {
    private char[] text;
    private int size;

    public Anagram(String text) {
        this.text = text.toCharArray();
        size = text.length();
    }

    private void getAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int i = 0; i < newSize; i++) {
            getAnagram(newSize - 1);
            if (newSize == 2 && check()) {
                display();
                System.exit(-1);
            }
        }
        rotate(newSize);
    }

    private void rotate(int newSize) {
        int pos = size - newSize;
        char temp = text[pos];
        for (int i = pos + 1; i < size; i++) {
            text[i - 1] = text[i];
        }
        text[size - 1] = temp;
    }

    private void display() {
        if (checkPalindrome(new String(text))) {
            System.out.print(checkPalindrome(new String(text)) + " : ");
            for (int i = 0; i < size; i++) {
                System.out.print(text[i]);
            }
        }
    }

    private boolean check() {
        return checkPalindrome(new String(text));
    }

    private boolean checkPalindrome(String s) {
        String str = s.replaceAll("-|,|\\.|\\?|!|\\(|\\)|\\s", "");
        for (int i = 0; i < str.length() / 2; i++) {
            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(str.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "Tact Coa";
        Anagram anagram = new Anagram(word);
        anagram.getAnagram(word.length());
    }
}
