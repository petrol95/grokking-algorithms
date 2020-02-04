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
        int temp;
        temp = arr[offset][offset];
        arr[offset][offset] = arr[size - 1 + offset][offset];
        arr[size - 1 + offset][offset] = arr[size - 1 + offset][size - 1 + offset];
        arr[size - 1 + offset][size - 1 + offset] = arr[offset][size - 1 + offset];
        arr[offset][size - 1 + offset] = temp;

        for (int i = 1 + offset; i < size - 1; i++) {
            temp = arr[offset][i + offset];
            arr[offset][i + offset] = arr[size - i - 1 - offset][offset];
            arr[size - i - 1 - offset][offset] = arr[size - 1 - offset][size - i - 1 - offset];
            arr[size - 1 - offset][size - i - 1 - offset] = arr[i + offset][size - 1 - offset];
            arr[i + offset][size - 1 - offset] = temp;
        }
//        System.out.println();
//        for (int i = 0; i < arr[0].length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
        rotateFrame(arr, size - 2, 1);
    }
}
