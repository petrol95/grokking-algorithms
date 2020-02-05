import java.util.Arrays;

public class MatrixRotation {
    public static void main(String[] args) {
        int[][] arr = {{10, 11, 12, 13, 14}, {15, 16, 17, 18, 19}, {20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29}, {30, 31, 32, 33, 34}};
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
//        System.out.println(Arrays.deepToString(arr));
        rotateFrame(arr, arr[0].length, 0);
        System.out.println();
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static void rotateFrame(int[][] arr, int size, int offset) {
        if (size < 2) {
            return;
        }
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[offset][i + offset];
        }

        for (int i = size - 1, j = 0; j < size; i--, j++) {
            arr[offset][i] = arr[j][offset];
        }

        for (int i = 0; i < size; i++) {
            arr[i][0] = arr[size - 1][i];
        }

        for (int i = 0, j = size - 1; i < size; i++, j--) {
            arr[size - 1][i] = arr[j][size - 1];
        }

        for (int i = 0, j = size - 1; i < size; i++, j--) {
            arr[i][size - 1] = temp[i];
        }

        rotateFrame(arr, size - 2, 1);
    }
}
