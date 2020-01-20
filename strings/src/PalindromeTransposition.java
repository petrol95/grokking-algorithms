import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Функция, проверяющая, является ли заданная строка перестановкой палиндрома
 */

public class PalindromeTransposition {

    public static void main(String[] args) {
        String s = "Tact Coa";
        checkTransposition(s);
    }

    private static void checkTransposition(String str) {
        List<Character> chrList = str.chars()         // IntStream
                .mapToObj(ch -> (char) ch)      // Stream<Character>
                .collect(Collectors.toCollection(LinkedList::new));
        shift(chrList, chrList.size());
    }

    private static void shift(List<Character> list, int size) {
        List<Character> newList;
        if (list.size() == 2) {
            Character chr = list.get(0);
            list.remove(0);
            list.add(chr);
        } else if (list.size() < size) {
            for (Character chr : list) {
                newList = list;
                newList.remove(chr);
                shift(newList, newList.size());
                newList.add(chr);
            }
        } else if (list.size() == size) {
            System.out.println(list + ": " + checkPalindrome(list));
        }
    }

    private static boolean checkPalindrome(List<Character> list) {
        for (int i = 0; i <= list.size() / 2; i++) {
            if (Character.toLowerCase(list.get(i)) != Character.toLowerCase(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}

