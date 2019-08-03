package LinkedList;

public interface LinkedList {

    void add(int value);

    Link remove();

    int getSize();

    boolean isEmpty();

    Link remove(int value);

    Link search(int value);

    void display();

    Link getFirstElement();
}
