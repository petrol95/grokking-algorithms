package HashTable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChainHashTable {
    private LinkedList<Item>[] chainHashArray;
    private int size;

    public ChainHashTable(int size) {
        this.size = size;
        chainHashArray = new LinkedList[size];
        for (int i = 0; i < chainHashArray.length; i++) {
            chainHashArray[i] = new LinkedList<Item>();
        }
    }

    private int hashFunc(int key) {
        return key % chainHashArray.length;
    }

    private int hashFunc(Item item) {
        return hashFunc(item.hashCode());
    }

    public Item find(int key) {
        int index = hashFunc(key);
        for (Item item : chainHashArray[index]) {
            if (key == item.hashCode())
                return item;
        }
        return null;
    }

    public void add(Item item) {
        int index = hashFunc(item);
        chainHashArray[index].addFirst(item);
    }

    public boolean remove(Item item) {
        int index = hashFunc(item);
        return chainHashArray[index].remove(item);
    }

    public void simpleDisplay() {
        for (int i = 0; i < chainHashArray.length; i++) {
            System.out.println(chainHashArray[i]);
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            String chain = chainHashArray[i].stream()
                    .map(Item::toString)
                    .collect(Collectors.joining(" -> ", "Row [", "]"));
            System.out.println(chain);
        }
    }

    public int getSize() {
        return Stream.of(chainHashArray)
                .mapToInt(LinkedList::size)
                .sum();
    }
}
