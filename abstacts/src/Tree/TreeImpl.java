package Tree;

import java.util.Stack;

public class TreeImpl implements Tree {
    Node root;

    public TreeImpl() {
        root = null;
    }

    @Override
    public Node find(int value) {
        Node current = root;
        while (current != null) {
            if (current.getKey() == value) {
                return current;
            } else {
                current = getNodeByKey(current, value);
            }
        }
    return null;
    }

    @Override
    public void insert(Node node) {
        Node current = root;
        Node parent = null;

        if (current == null) {
            root = node;
        } else {
            while (current != null) {
                parent = current;
                current = getNodeByKey(current, node.getKey());
            }

            if (node.isLeftChild(parent))
                parent.setLeftChild(node);
            else
                parent.setRightChild(node);
        }
    }

    private Node getNodeByKey(Node current, int key) {
        if (key < current.getKey()) {
            current = current.getLeftChild();
        } else {
            current = current.getRightChild();
        }
        return current;
    }

    @Override
    public Node remove(int id) {
        return null;
    }

    @Override
    public void traverse(int mode) {

    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getKey());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }
}
