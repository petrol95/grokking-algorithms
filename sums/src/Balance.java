import java.util.Arrays;

public class Balance {

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 2, 5};
        int[] arr2 = {-1, 1, -1, 1, -2, 2};
        int[] arr3 = {1, 1, 2, 3, 4};
        test(arr1);
        test(arr2);
        test(arr3);

    }

    private static boolean checkBalance(int[] arr) {
        if (arr == null || arr.length < 2)
            return false;
        int sum = 0, subsum = 0;
        for (int i : arr)
            sum += i;
        if (sum % 2 != 0)
            return false;
        for (int i = 0; i < arr.length - 1; i++) {
            subsum += arr[i];
            if (subsum * 2 == sum)
                return true;
        }
        return false;
    }

    private static void test(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println("Balance: " + checkBalance(arr));
        System.out.println();
    }
}
