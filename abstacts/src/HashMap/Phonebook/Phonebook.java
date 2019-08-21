package HashMap.Phonebook;

/**
 * Класс Телефонный Справочник, который хранит в себе список фамилий и
 * телефонных номеров. В этот телефонный справочник с помощью метода add() можно
 * добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
 * Под одной фамилией может быть несколько телефонов (в случае
 * однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны
 */

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    HashMap<String, HashSet<String>> book;

    public Phonebook() {
        book = new HashMap<>();
    }

    public void add(String name, String telNumber) {
        if (!book.containsKey(name))
            book.put(name, new HashSet<>());
        book.get(name).add(telNumber);
    }

    public HashSet<String> get(String name) {
        return book.get(name);
    }
}
