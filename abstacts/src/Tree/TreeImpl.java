package Tree;

import java.util.Stack;

public class TreeImpl implements Tree {
    private Node root;
    private int maxLevel;

    public TreeImpl() {
        root = null;
    }

    public TreeImpl(int maxLevel) {
        root = null;
        this.maxLevel = maxLevel;
    }

    @Override
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.getKey() == key) {
                return current;
            } else {
                current = current.getNodeByKey(key);
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
                current = current.getNodeByKey(node.getKey());
            }

            if (parent.isLeftChild(node.getKey())) {
                parent.setLeftChild(node);
            } else {
                parent.setRightChild(node);
            }

            // remove node if too many levels in the tree
//            if (height(root) > maxLevel) {
//                removeLeafNode(node.getKey(), parent);
//            }
        }
    }

    @Override
    public Node remove(int key) {
        Node current = root;
        Node parent = root;

        while (current != null) {
            if (current.getKey() == key)
                break;
            parent = current;
            current = current.getNodeByKey(key);
        }

        if (current == null)
            return null;

        // no children
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            removeLeafNode(key, parent);

            // one child
        } else if (current.getLeftChild() == null || current.getRightChild() == null) {
            Node childNode = (current.getLeftChild() == null) ? current.getRightChild() :
                    current.getLeftChild();
            if (parent.isLeftChild(key))
                parent.setLeftChild(childNode);
            else
                parent.setRightChild(childNode);

        } else {
            // two children
            Node successor = getSuccessor(current);
            if (current == root)
                root = successor;

            if (parent.isLeftChild(key))
                parent.setLeftChild(successor);
            else
                parent.setRightChild(successor);

            successor.setLeftChild(current.getLeftChild());
        }
        return current;
    }

    private void removeLeafNode(int key, Node parent) {
        if (parent.isLeftChild(key))
            parent.setLeftChild(null);
        else
            parent.setRightChild(null);
    }

    private Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (node.getRightChild().getKey() != successor.getKey()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }
        return successor;
    }

    @Override
    public void revert() {
        revert(root);
    }

    private Node revert(Node node) {
        if (node == null)
            return null;
        Node newNode = new NodeImpl(60, "Petr", 100);
        newNode.setLeftChild(revert(node.getRightChild()));
        newNode.setRightChild(revert(node.getLeftChild()));
        return newNode;
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                this.inOrder(root);
                break;
            case PRE_ORDER:
                this.preOrder(root);
                break;
            case POST_ORDER:
                this.postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Invalid mode " + mode);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.print(node.getKey() + " ");
        }
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getKey() + " ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            System.out.print(node.getKey() + " ");
            inOrder(node.getRightChild());
        }
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

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        return node == null || isBalanced(node.getLeftChild()) && isBalanced(node.getRightChild()) &&
                Math.abs(height(node.getRightChild()) - height(node.getLeftChild())) <= 1;
    }

    private int height(Node node) {
        return (node == null) ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
