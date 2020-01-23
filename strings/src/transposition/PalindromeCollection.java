package transposition;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Функция, проверяющая, является ли заданная строка перестановкой палиндрома
 */

public class PalindromeCollection {

    private List<Character> text;
    private int size;

    public PalindromeCollection(String text) {
        this.text = text.chars()                                    // IntStream
                .mapToObj(ch -> (char) ch)                          // Stream<Character>
                .collect(Collectors.toCollection(LinkedList::new));
        size = text.length();
    }

    private void getAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int i = 0; i < newSize; i++) {
            getAnagram(newSize - 1);
            if (newSize == 2 && checkPalindrome(text)) {
                display();
                System.exit(-1);
            }
        }
        rotate(newSize);
    }

    private void rotate(int newSize) {
        Character chr = text.get(size - newSize);
        text.remove(size - newSize);
        text.add(chr);
    }

    private void display() {
        if (checkPalindrome(text)) {
            System.out.print(checkPalindrome(text) + " : " + text);
        }
    }

    private boolean checkPalindrome(List<Character> text) {
        List<Character> list = new LinkedList<>(text);
        list.removeIf(chr -> chr == ' ');
        for (int i = 0; i <= list.size() / 2; i++) {
            if (Character.toLowerCase(list.get(i)) != Character.toLowerCase(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "Tact Coa";
        PalindromeCollection palindromeCollection = new PalindromeCollection(word);
        palindromeCollection.getAnagram(word.length());
    }
}