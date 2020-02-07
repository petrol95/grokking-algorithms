import java.util.Arrays;

public class MatrixZeroing {
    public static void main(String[] args) {
        int[][] arr = {{10, 11, 12, 13, 14}, {15, 16, 0, 18, 19}, {20, 21, 22, 23, 24}};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        checkZero(arr);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static void checkZero(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    makeZero(arr, i, j);
                }
            }
        }
    }

    private static void makeZero(int[][] arr, int row, int col) {
        for (int i = 0; i < arr[0].length; i++) {
            if (i == row) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = 0;
                }
            }
            for (int j = 0; j < arr[0].length; j++) {
                if (j == col) {
                    for (int k = 0; k < arr.length; k++) {
                        arr[k][j] = 0;
                    }
                }
            }
        }
    }
}
