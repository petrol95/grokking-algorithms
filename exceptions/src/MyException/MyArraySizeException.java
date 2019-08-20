package MyException;

public class MyArraySizeException extends MyException {

    public MyArraySizeException() {
        super("Неверный размер! Массив должен иметь размер 4 х 4!");
    }
}
