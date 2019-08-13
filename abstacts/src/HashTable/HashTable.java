package HashTable;

public class HashTable {
    private static final int DOUBLE_HASH_CONST = 5;

    private Item[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new Item[size];
    }

    private int hashFunc(int key) {
        return key % hashArray.length;
    }

    private int doubleHashFunc(int key) {
        return DOUBLE_HASH_CONST - key % DOUBLE_HASH_CONST;
    }

    public Item find(int key) {
        int index = hashFunc(key);
        int stepSize = doubleHashFunc(key);
        int count = 0;
        while (hashArray[index] != null && count < hashArray.length) {
            if (key == hashArray[index].hashCode()) {
                return hashArray[index];
            }
            index += stepSize;
            index %= hashArray.length;
            count++;
        }
        return null;
    }

    public void add(Item item) {
        int index = hashFunc(item.hashCode());
        int stepSize = doubleHashFunc(item.hashCode());
        int count = 0;
        while (hashArray[index] != null && count < hashArray.length) {
            index += stepSize;
            index %= hashArray.length;
            count++;
        }
        hashArray[index] = item;
    }

    public boolean remove(Item item) {
        return remove(item.hashCode()) != null;
    }

    public Item remove(int key) {
        int index = hashFunc(key);
        int stepSize = doubleHashFunc(key);
        int count = 0;
        while (hashArray[index] != null && count < hashArray.length) {
            if (key == hashArray[index].hashCode()) {
                Item removed = hashArray[index];
                hashArray[index] = null;
                return removed;
            }
            index += stepSize;
            index %= hashArray.length;
            count++;
        }
        return null;
    }

    public void display() {
        for (Item item : hashArray) {
//            if (item != null)
                System.out.println(item);
        }
    }
}
