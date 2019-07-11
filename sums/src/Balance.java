import java.util.Arrays;

public class Balance {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 5};
        System.out.println(Arrays.toString(arr));
        System.out.println("Balance: " + checkBalance(arr));
        System.out.println();
    }

    private static boolean checkBalance(int[] arr) {
        int s1 = arr[0];
        int s2 = 0;
        for (int i = 1; i < arr.length; i++)
            s2 += arr[i];
        int i = 1;
        while ((s1 != s2) && (i < arr.length - 1)) {
            s1 += arr[i];
            s2 -= arr[i++];
        }
        return s1 == s2;
    }
}
