package HashTable;

import java.util.Objects;

public class Item {
    private int id;
    private final String data;

    public Item(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                Objects.equals(data, item.data);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
