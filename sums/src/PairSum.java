import java.util.Arrays;

/**
 * Функция, проверяющая, что в отсортированном массиве встречается такая пара чисел, которая дает нужную сумму
 */

public class PairSum {

    public static void main(String[] args) {

        int[] arr1 = {1, 1, 1, 2, 5};
        System.out.println(Arrays.toString(arr1) + " n = " + 2 + " " + checkSums(arr1, 2));

        int[] arr2 = {1, 2, 3, 6};
        System.out.println(Arrays.toString(arr2) + " n = " + 9 + " " + checkSums(arr2, 9));

        int[] arr3 = {1, 1, 3, 4};
        System.out.println(Arrays.toString(arr3) + " n = " + 2 + " " + checkSums(arr3, 2));

        int[] arr4 = {-1, 1, 4, 8};
        System.out.println(Arrays.toString(arr4) + " n = " + 3 + " " + checkSums(arr4, 3));

        int[] arr5 = {1, 4, 8, 9};
        System.out.println(Arrays.toString(arr5) + " n = " + 6 + " " + checkSums(arr5, 6));
    }

    private static boolean checkSums(int[] arr, int n) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] + arr[j] == n)
                    return true;
        return false;
    }
}
