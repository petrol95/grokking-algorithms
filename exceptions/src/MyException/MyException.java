package MyException;

public class MyException extends RuntimeException {
    public MyException(String message) {
        super("Произошла чудовищная ошибка! " + message);
    }
}
