import java.util.Arrays;

public class MatrixRotation {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
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
        int temp;
        temp = arr[0 + offset][0 + offset];
        arr[0 + offset][0 + offset] = arr[size - 1 - offset][0 + offset];
        arr[size - 1 - offset][0 + offset] = arr[size - 1 - offset][size - 1 - offset];
        arr[size - 1 - offset][size - 1 - offset] = arr[0 + offset][size - 1 - offset];
        arr[0 + offset][size - 1 - offset] = temp;

        for (int i = 1 + offset; i < size - 1; i++) {
            temp = arr[0 + offset][i + offset];
            arr[0 + offset][i + offset] = arr[size - i - 1 - offset][0 + offset];
            arr[size - i - 1 - offset][0 + offset] = arr[size - 1 - offset][size - i - 1 - offset];
            arr[size - 1 - offset][size - i - 1 - offset] = arr[i + offset][size - 1 - offset];
            arr[i + offset][size - 1 - offset] = temp;
        }
        System.out.println();
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        rotateFrame(arr, size - 2, 1);
    }
}
