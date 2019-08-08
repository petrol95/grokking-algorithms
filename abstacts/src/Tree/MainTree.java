package Tree;

public class MainTree {
    public static void main(String[] args) {
        Tree tree = new TreeImpl();
        tree.insert(new NodeImpl(60, "Petr", 100));
        tree.insert(new NodeImpl(66, "Petr", 100));
        tree.insert(new NodeImpl(50, "Petr", 100));
        tree.insert(new NodeImpl(40, "Petr", 100));
        tree.insert(new NodeImpl(31, "Petr", 100));
        tree.insert(new NodeImpl(45, "Petr", 100));
        tree.insert(new NodeImpl(55, "Petr", 100));
        tree.insert(new NodeImpl(57, "Petr", 100));
        tree.insert(new NodeImpl(70, "Petr", 100));
        tree.insert(new NodeImpl(67, "Petr", 100));
        tree.insert(new NodeImpl(81, "Petr", 100));
        tree.display();

        System.out.println(tree.find(55));
    }
}
