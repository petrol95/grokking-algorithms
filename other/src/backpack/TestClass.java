package backpack;

import java.util.LinkedList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        List<Item> list = new LinkedList<>();
        list.add(new Item("Книга", 1, 600));
        list.add(new Item("Бинокль", 2, 5000));
        list.add(new Item("Аптечка", 4, 1500));
        list.add(new Item("Ноутбук", 2, 40000));
        list.add(new Item("Котелок", 1, 500));

        BackPack backPack = new BackPack(5);
        backPack.calcBestSet(list);
        list = backPack.getBestItems();
        for (Item item : list) {
            System.out.println(item.name + ": " + item.price);
        }
        System.out.println("Best price: " + backPack.getBestPrice());
        System.out.println("Count: " + backPack.getCount());
    }
}
