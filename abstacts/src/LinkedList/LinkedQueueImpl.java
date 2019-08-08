package LinkedList;

import StackAndQueue.Queue;

public class LinkedQueueImpl implements Queue {
    private TwoSideLinkedList linkedList;

    public LinkedQueueImpl() {
        linkedList = new TwoSideLinkedListImpl();
    }

    @Override
    public void addRight(int value) {
        linkedList.addLast(value);
    }

    @Override
    public int removeLeft() {
       return linkedList.remove().getData();
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
