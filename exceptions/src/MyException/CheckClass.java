package MyException;

public class CheckClass {
    public static void main(String[] args) {
        Object[][] arr = {{1, 2, 3, 4}, {4, 0, 1, 0}, {1, 2, 'i', 4}, {1, 2, 3, 4}};
        try {
            int res = testArray(arr);
            System.out.println(res);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размерности!");
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных!");
            e.printStackTrace();
        }
    }

    private static int testArray(Object[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException(arr.length, arr[0].length);
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                try {
                    sum += (int) arr[i][j];
                } catch (ClassCastException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
