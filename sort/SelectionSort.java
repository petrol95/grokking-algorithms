import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 10};
        System.out.println(Arrays.toString(selectSort(arr)));
        int[] arr1 = {-5, 7, 0, -6, 4, 0, 2, 5, 8, -3, 8};
        System.out.println(Arrays.toString(selectSort(arr1)));
    }

    private static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int mark = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[mark])
                    mark = j;
            }
            int temp = arr[i];
            arr[i] = arr[mark];
            arr[mark] = temp;
        }
        return arr;
    }
}