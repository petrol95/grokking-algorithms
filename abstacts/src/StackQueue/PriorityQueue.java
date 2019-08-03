package StackQueue;

public class PriorityQueue {
    int[] data;
    int size;

    public PriorityQueue(int maxSize) {
        data = new int[maxSize];
        size = 0;
    }

    int remove() {
        return data[--size];
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == data.length;
    }

    void insert(int value) {
        if (isEmpty()) {
            data[size++] = value;
            return;
        }
        int i = 0;
        for (i = size - 1; i >= 0; i--) {
            if (value > data[i])
                data[i + 1] = data[i];
            else
                break;
        }
        data[i + 1] = value;
        size++;
    }

    void display() {
        System.out.print("{ ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("}");
    }
}
