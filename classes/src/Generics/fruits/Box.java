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
        float sum = 0;
        for (T fruit : fruits) {
            sum += fruit.getWeight();
        }
        return sum;
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
