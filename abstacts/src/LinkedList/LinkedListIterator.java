package LinkedList;

import java.util.Iterator;

public class LinkedListIterator implements Iterator<Link> {
    private LinkedList list;
    private Link current;
    private boolean firstIteration = true;

    public LinkedListIterator(LinkedList list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (firstIteration) {
            firstIteration = false;
            return list.getFirstElement() != null;
        }
        return current.getNext() != null;
    }

    @Override
    public Link next() {
        if (current == null)
            current = list.getFirstElement();
        else
            current = current.getNext();
        return current;
    }
}
