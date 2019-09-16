package Generics.change;

import java.util.Arrays;

/**
 * Метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа)
 */

public class ArrayChange<T> {
    private T[] arr;

    public ArrayChange(T[] arr) {
        this.arr = arr;
    }

    public void change(int i, int j) {
        T temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
