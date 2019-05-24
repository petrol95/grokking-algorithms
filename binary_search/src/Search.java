public class Search {

    private static void binarySearch(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == item) {
                System.out.println("Item = " + item + " has index = " + mid);
                return;
            } else if (arr[mid] > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("Item = " + item + " wasn't found");
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};

        binarySearch(arr, 3);
        binarySearch(arr, -1);
    }
}
