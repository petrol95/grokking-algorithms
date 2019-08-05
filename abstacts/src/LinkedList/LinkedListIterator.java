package LinkedList;

public class LinkedListIterator implements ListIterator {
    private LinkedList list;
    private Link current;
    private Link previous;
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
            current = list.getFirstElement(); //reset();
        else {
            previous = current;
            current = current.getNext();
        }
        return current;
    }

    @Override
    public void remove() {
        if (current == list.getFirstElement()) { //if (previous == null)
            list.setFirstElement(current.getNext());
            previous = null;
//            reset();
        } else {
            previous.setNext(current.getNext());
            if (!hasNext())
                reset();
            else
                current = current.getNext();
        }
    }

    @Override
    public void reset() {
        firstIteration = false;
        previous = null;
        current = list.getFirstElement();
    }

    @Override
    public void insertBefore(int value) {
        Link link = new Link(value);
        if (current == list.getFirstElement()) { //if (previous == null)
            link.setNext(list.getFirstElement());
            list.setFirstElement(link);
//            reset();
        } else {
            link.setNext(previous.getNext());
            previous.setNext(link);
//            current = link;
        }
    }

    @Override
    public void insertAfter(int value) {
        Link link = new Link(value);
        if (list.isEmpty()) {
            list.setFirstElement(link);
            current = link;
        } else {
            link.setNext(current.getNext());
            current.setNext(link);
            next();
        }
    }
}
