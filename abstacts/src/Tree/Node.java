package Tree;

public interface Node {

    int getKey();

    Node getLeftChild();

    void setLeftChild(Node node);

    Node getRightChild();

    void setRightChild(Node node);

    boolean isLeftChild(int key);

    Node getNodeByKey(int key);
}
