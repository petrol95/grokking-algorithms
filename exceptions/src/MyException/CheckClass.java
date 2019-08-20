package MyException;

public class CheckClass {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"4", "0", "1", "0"},
                {"1", "2", "i", "4"},
                {"1", "2", "3", "4"}};
        try {
            int res = testArray(arr);
            System.out.println(res);
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int testArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
