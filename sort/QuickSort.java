import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {-5, 7, 0, -6, 4, 0, 2, 5, 8, -3, 8};
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partInd = partition(arr, low, high);
            quickSort(arr, low, partInd - 1);
            quickSort(arr, partInd + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}