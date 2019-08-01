import java.sql.SQLOutput;

public class QueueImpl implements Queue {
    protected int[] data;
    protected int size;
    protected int front;
    protected int rear;
    public static final int DEFAULT_FRONT = 0;
    public static final int DEFAULT_REAR = -1;

    public QueueImpl(int maxSize) {
        data = new int[maxSize];
        size = 0;
        front = DEFAULT_FRONT;
        rear = DEFAULT_REAR;
    }

    @Override
    public void addRight(int value) {
        if (rear == data.length - 1)
            rear = DEFAULT_REAR;
        data[++rear] = value;
        size++;
        System.out.println("front = " + front);
        System.out.println("rear = " + rear);
    }

    @Override
    public int removeLeft() {
        int value = data[front++];
        if (front == data.length)
            front = DEFAULT_FRONT;
        size--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void display() {
        int currentSize = size;
        int currentFront = front;
        System.out.print("{ ");
        while (currentSize > 0) {
            System.out.print(data[currentFront++] + " ");
            if (currentFront == data.length)
                currentFront = DEFAULT_FRONT;
            currentSize--;
        }
        System.out.println("}");
    }
}
