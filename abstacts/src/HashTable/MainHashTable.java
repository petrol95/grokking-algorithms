package HashTable;

import java.util.*;

public class MainHashTable {

    private static Item item1;

    public static void main(String[] args) {
//        testHashTable();
//        testHashMap();
        ChainHashTable chainHashTable = new ChainHashTable(10);
        Item item1 = new Item(2, "2");
        Item item2 = new Item(15, "15");
        Item item3 = new Item(32, "32");
        Item item4 = new Item(7, "7");
        Item item5 = new Item(17, "17");

        chainHashTable.add(item1);
        chainHashTable.add(item2);
        chainHashTable.add(item3);
        chainHashTable.add(item4);
        chainHashTable.add(item5);

        chainHashTable.display();
        System.out.println("size is: " + chainHashTable.getSize());
        System.out.println("---");

        System.out.println(chainHashTable.find(32));
        System.out.println(chainHashTable.find(81));
        System.out.println("---");

        chainHashTable.remove(item4);
        chainHashTable.display();
        System.out.println("size is: " + chainHashTable.getSize());

    }

    private static void testHashMap() {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(123, "abc");
        hashMap.put(456, "def");
        System.out.println(hashMap.get(123));
        System.out.println(hashMap.containsValue("def"));

        Set<String> treeSet = new TreeSet<>(Comparator.reverseOrder());
        treeSet.add("hij");
        treeSet.add("klm");
        for (String s : treeSet) {
            System.out.println(s);
        }

    }

    private static void testHashTable() {
        HashTable hashTable = new HashTable(10);
        Item item1 = new Item(2, "2");
        Item item2 = new Item(15, "15");
        Item item3 = new Item(32, "32");
        Item item4 = new Item(7, "7");
        Item item5 = new Item(17, "17");

        hashTable.add(item1);
        hashTable.add(item2);
        hashTable.add(item3);
        hashTable.add(item4);
        hashTable.add(item5);

        hashTable.display();
        System.out.println("---");

        System.out.println(hashTable.find(32));
        System.out.println(hashTable.find(81));
        System.out.println("---");

        hashTable.remove(15);
        hashTable.remove(item4);
        hashTable.display();
    }
}
