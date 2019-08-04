package LinkedList;

public interface LinkedList extends Iterable<Link> {

    void add(int value);

    Link remove();

    int getSize();

    boolean isEmpty();

    Link remove(int value);

    Link search(int value);

    void display();

    Link getFirstElement();

    void setFirstElement(Link firstElement);
}
