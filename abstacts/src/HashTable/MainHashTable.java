package HashTable;

public class MainHashTable {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.add(new Item(2));
        hashTable.add(new Item(15));
        hashTable.add(new Item(32));
        hashTable.add(new Item(7));
        hashTable.add(new Item(17));
        hashTable.display();
        System.out.println("---");

        hashTable.remove(15);
        hashTable.add(new Item(51));
        hashTable.display();
        System.out.println("---");

        System.out.println(hashTable.find(32));
        System.out.println(hashTable.find(81));

    }
}
