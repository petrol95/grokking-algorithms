package Generics.arraychange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа)
 * Метод, который преобразует массив в ArrayList
 */

public class ArrayChange<T> {
    private T[] arr;

    public ArrayChange(T[] arr) {
        this.arr = arr;
    }

    public void changeElements(int i, int j) {
        T temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<T> transformToArrayList(){
//        List<T> arrayList = new ArrayList<>(Arrays.asList(arr));
        List<T> arrayList = new ArrayList<>();
        for (T t : arr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
