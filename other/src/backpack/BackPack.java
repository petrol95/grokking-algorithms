package backpack;

import java.util.ArrayList;
import java.util.List;

public class BackPack {
    private int maxWeight;
    private int bestPrice;
    private List<Item> bestItems = null;
    private int count = 0;

    public BackPack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void calcBestSet(List<Item> items) {
        if (items.size() > 0) {
            bestSet(items);
            count++;
        }
        for (int i = 0; i < items.size(); i++) {
            List<Item> list = new ArrayList<>(items);
            list.remove(i);
            calcBestSet(list);
        }
    }

    private void bestSet(List<Item> items) {
        if (bestItems == null) {
            if (calcWeight(items) <= maxWeight) {
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        } else {
            if (calcWeight(items) <= maxWeight && calcPrice(items) > bestPrice) {
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        }
    }

    public int calcWeight(List<Item> items) {
        int sumWeight = 0;
        for (Item item : items) {
            sumWeight += item.weight;
        }
        return sumWeight;
    }

    public int calcPrice(List<Item> items) {
        int sumPrice = 0;
        for (Item item : items) {
            sumPrice += item.price;
        }
        return sumPrice;
    }

    public List<Item> getBestItems() {
        return bestItems;
    }

    public int getBestPrice() {
        return bestPrice;
    }

    public int getCount() {
        return count;
    }
}
