package MyException;

public class MyArrayDataException extends MyException{

    public MyArrayDataException(int x, int y) {
        super(String.format("Ошибка данных в ячейке %d, %d", x, y));
    }
}
