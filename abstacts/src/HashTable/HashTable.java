package HashTable;

public class HashTable {
    private Item[] hashArray;
    private int maxSize;

    public HashTable(int maxSize) {
        this.maxSize = maxSize;
        hashArray = new Item[maxSize];
    }

    private int HashFunc(int key) {
        return key % hashArray.length;
    }

    public Item find(int key) {
        int index = HashFunc(key);
        while (hashArray[index] != null) {
            if (key == hashArray[index].hashCode()) {
                return hashArray[index];
            }
            index++;
            index %= hashArray.length;
        }
        return null;
    }

    public void add(Item item) {
        int index = HashFunc(item.hashCode());
        while (hashArray[index] != null) {
            index++;
            index %= hashArray.length;
        }
        hashArray[index] = item;
    }

    public boolean remove(Item item) {
        return remove(item.hashCode()) != null;
    }

    public Item remove(int key) {
        int index = HashFunc(key);
        while (hashArray[index] != null) {
            if (key == hashArray[index].hashCode()) {
                Item removed = hashArray[index];
                hashArray[index] = null;
                return removed;
            }
            index++;
            index %= hashArray.length;
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
