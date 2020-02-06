import java.util.Arrays;

/**
 * Matrix 90 degree rotation
 */

public class MatrixRotation {
    public static void main(String[] args) {
        int[][] arr = {{10, 11, 12, 13, 14}, {15, 16, 17, 18, 19}, {20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29}, {30, 31, 32, 33, 34}};
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        rotateFrame(arr);
        System.out.println();
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static void rotateFrame(int[][] arr) {
        rotateFrame(arr, arr[0].length, 0);
    }

    private static void rotateFrame(int[][] arr, int size, int offset) {
        if (size < 2) {
            return;
        }
        int[] temp = new int[size];
        // first horizontal
        for (int i = 0; i < size; i++) {
            temp[i] = arr[offset][i + offset];
        }
        // first vertical
        for (int i = size - 1, j = 0; j < size; i--, j++) {
            arr[offset][i + offset] = arr[j + offset][offset];
        }
        // last horizontal
        for (int i = 0; i < size; i++) {
            arr[i + offset][offset] = arr[size - 1 + offset][i + offset];
        }
        // last vertical
        for (int i = 0, j = size - 1; i < size; i++, j--) {
            arr[size - 1 + offset][i + offset] = arr[j + offset][size - 1 + offset];
        }
        // first horizontal
        for (int i = 0, j = size - 1; i < size; i++, j--) {
            arr[i + offset][size - 1 + offset] = temp[i];
        }
        rotateFrame(arr, size - 2, 1);
    }
}
