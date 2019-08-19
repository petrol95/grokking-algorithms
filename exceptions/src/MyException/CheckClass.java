package MyException;

public class CheckClass {
    public static void main(String[] args) {
        int[][] arr = new int[8][3];
        testSize(arr);
    }

    private static void testSize(int[][] arr) {
        if (arr.length != 4 || arr[0].length != 4)
            throw new MyArraySizeException(arr.length, arr[0].length);
    }


}
