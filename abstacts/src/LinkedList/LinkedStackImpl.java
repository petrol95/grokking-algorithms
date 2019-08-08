package LinkedList;

import StackAndQueue.Stack;

public class LinkedStackImpl implements Stack {
    private LinkedList linkedList;

    public LinkedStackImpl() {
        linkedList = new SimpleLinkedListImpl();
    }

    @Override
    public void push(int value) {
        linkedList.add(value);
    }

    @Override
    public int pop() {
        return linkedList.remove().getData();
    }

    @Override
    public int peek() {
        return linkedList.getFirstElement().getData();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public void display() {
        linkedList.display();
    }
}
