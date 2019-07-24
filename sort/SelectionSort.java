import java.util.Arrays;

public class SelectionSort {
    
    private static int findSmallest(int[] arr) {
        int smallest = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                index = i;
            }
        }
        return index;
    }
    
    private static void selectSort(int[] arr) {
        int index;
        int size = arr.length;
        int[] newArr = new int[arr.length];
        for (int i = 0; i < newArr.length; i++) {
            index = findSmallest(arr);
            newArr[i] = arr[index];
            for (int j = index; j < size - 1; j++)
                arr[j] = arr[j + 1];
            size--;
        }
        System.out.println(Arrays.toString(newArr));
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 10};
        selectSort(arr);
        int[] arr1 = {-5, 7, 0, -6, 4, 0, 2, 5, 8, -3, 8};
        selectSort(arr1);
    }
}
