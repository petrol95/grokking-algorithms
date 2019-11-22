package Tree;

public interface Tree {

    Node find(int value);

    void insert(Node node);

    Node remove(int id);

    void traverse(TraverseMode mode);

    void revert();

    void display();

    boolean isBalanced();
}
