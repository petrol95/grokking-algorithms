import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 10};
        System.out.println(Arrays.toString(bubbleSort(arr)));
        int[] arr1 = {-5, 7, 0, -6, 4, 0, 2, 5, 8, -3, 8};
        System.out.println(Arrays.toString(bubbleSort(arr1)));
    }

    private static int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1])
                    change(arr, j, j + 1);
            }
        }
        return arr;
    }

    private static void change(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
