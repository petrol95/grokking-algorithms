package LinkedList;

import java.util.Iterator;

public interface ListIterator extends Iterator<Link> {

    void reset();

    void insertBefore(int value);

    void insertAfter(int value);

}
