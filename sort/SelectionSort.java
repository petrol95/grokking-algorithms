import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    
    private static int findSmallest(List<Integer> list) {
        int smallest = list.get(0);
        int smallest_index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < smallest) {
                smallest = list.get(i);
                smallest_index = i;
            }
        }
        return smallest_index;
    }
    
    private static List<Integer> selectSort(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        int smallest;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            smallest = findSmallest(list);
            newList.add(list.remove(smallest));
        }
        return newList;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(selectSort(list).toString());
    }
}
