public class StackImpl implements Stack {
    private int[] data;
    private int size;

    public StackImpl(int maxSize) {
        data = new int[maxSize];
        this.size = 0;
    }

    @Override
    public void push(int value) {
        data[size++] = value;
    }

    @Override
    public int pop() {
        return data[--size];
    }

    @Override
    public int peek() {
        return data[size - 1];
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
        System.out.print("{ ");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println("}");
    }
}
