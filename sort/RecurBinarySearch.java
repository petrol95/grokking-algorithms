import java.util.Arrays;

public class RecurBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int value = 7;
        Arrays.sort(arr);
        System.out.println("value = " + value + " found at position " +
                recurBinarySearch(arr, 7, 0, arr.length - 1));
    }

    public static int recurBinarySearch(int[] arr, int value, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == value)
            return mid;
        else if (value < arr[mid])
            return recurBinarySearch(arr, value, 0, mid - 1);
        else
            return recurBinarySearch(arr, value, mid + 1, high);
    }
}
