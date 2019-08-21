package HashMap;

import HashMap.Phonebook.Phonebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MainClass {
    public static void main(String[] args) {
//        testPhoneBook();

        /**
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать, сколько раз встречается каждое слово.
         */

        String[] arr = {"A", "A", "B", "B", "B", "C", "D"};

        HashSet<String> hs = new HashSet<>();
        hs.addAll(Arrays.asList(arr));
        System.out.println(hs);

        HashMap<String, Integer> hm = new HashMap<>();
        for (String s : arr) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        System.out.println(hm);
        System.out.println(hm.keySet());
    }

    private static void testPhoneBook() {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "123456");
        phonebook.add("Иванов", "765432");
        phonebook.add("Петров", "545678");
        System.out.println("Иванов: " + phonebook.get("Иванов"));
    }
}
