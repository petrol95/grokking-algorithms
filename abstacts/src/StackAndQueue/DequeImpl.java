package StackAndQueue;

public class DequeImpl extends QueueImpl implements Deque {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public void addRight(int value) {
        super.addRight(value);
    }

    @Override
    public int removeLeft() {
        return super.removeLeft();
    }

    @Override
    public void addLeft(int value) {
        if (front - 1 < 0)
            front = data.length;
        data[--front] = value;
        size++;
    }

    @Override
    public int removeRight() {
        if (rear < 0)
            rear = data.length - 1;
        size--;
        return data[rear--];
    }
}
