import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 10};
        System.out.println(Arrays.toString(insertSort(arr)));
        int[] arr1 = {-5, 7, 0, -6, 4, 0, 2, 5, 8, -3, 8};
        System.out.println(Arrays.toString(insertSort(arr1)));
    }

    private static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while(j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }
}
