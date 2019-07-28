public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int item1 = 7;
        int item2 = -1;
        test(arr, item1);
        test(arr, item2);
    }

    private static void test(int[] arr, int item) {
        int index = binarySearch(arr, item);
        System.out.println("Item = " + item + ((index == -1) ? " wasn't found" : " has index = " + index));
    }

    private static int binarySearch(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low < high) {
            mid = (low + high) / 2;
            if (arr[mid] == item) {
                return mid;
            } else if (arr[mid] > item) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
