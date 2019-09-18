package Generics.fruits;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        this.fruits.add(fruit);
    }

    public float getWeight() {
        if (fruits.size() == 0)
            return 0;
        else
            return fruits.get(0).getWeight() * fruits.size();
    }

    public boolean compare(Box<?> another) {
        return this.getWeight() == another.getWeight();
    }

    public void empty(Box<T> another) {
        Iterator<T> iter = this.fruits.iterator();
        while(iter.hasNext()) {
            another.addFruit(iter.next());
            iter.remove();
        }
    }
}