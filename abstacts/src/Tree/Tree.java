package Tree;

public interface Tree {

    Node find(int value);

    void insert(Node node);

    Node remove(int id);

    void traverse(TraverseMode mode);

    void invert();

    void display();

    boolean isBalanced();
}
