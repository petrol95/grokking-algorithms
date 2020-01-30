import java.util.Arrays;

public class MatrixRotation {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
//        System.out.println(Arrays.deepToString(arr));
        rotateFrame(arr, arr[0].length);
        System.out.println();
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static void rotateFrame(int[][] arr, int size) {
        if (size == 1) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            int temp = arr[0][i];
            arr[0][i] = arr[i][0];
            arr[i][0] = arr[size - 1][size - i - 1];
            arr[size - 1][size - i - 1] = arr[size - i - 1][size - 1];
            arr[size - i - 1][size - 1] = temp;
        }
        rotateFrame(arr, size - 1);
    }
}
