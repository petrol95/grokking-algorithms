package StackQueue;

public interface Queue {

    void addRight(int value);

    int removeLeft();

    boolean isEmpty();

    boolean isFull();

    int getSize();

    void display();
}
