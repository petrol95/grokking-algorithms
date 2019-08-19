package MyException;

public class MyArraySizeException extends MyException {

    public MyArraySizeException(int x, int y) {
        super(String.format("Неверный размер массива %d х %d", x, y));
    }
}
