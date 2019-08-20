package MyException;

public class MyArrayDataException extends MyException{

    public MyArrayDataException(int row, int column) {
        super(String.format("Ошибка данных в ячейке %d, %d", row, column));
    }
}
