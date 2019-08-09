package Tree;

import static Tree.TraverseMode.*;

public class MainTree {
    public static void main(String[] args) {
        Tree tree = new TreeImpl();
        tree.insert(new NodeImpl(60, "Petr", 100));
        tree.insert(new NodeImpl(66, "Petr", 100));
        tree.insert(new NodeImpl(25, "Petr", 100));
        tree.insert(new NodeImpl(15, "Petr", 100));
        tree.insert(new NodeImpl(45, "Petr", 100));
        tree.insert(new NodeImpl(5, "Petr", 100));
        tree.insert(new NodeImpl(30, "Petr", 100));
        tree.insert(new NodeImpl(20, "Petr", 100));
        tree.insert(new NodeImpl(55, "Petr", 100));
        tree.display();

//        System.out.println(tree.find(55));
//
        System.out.print("\ninOrder: ");
        tree.traverse(IN_ORDER);
        System.out.print("\npreOrder: ");
        tree.traverse(PRE_ORDER);
        System.out.print("\npostOrder: ");
        tree.traverse(POST_ORDER);

//        tree.remove(57);
//        tree.remove(55);
//        tree.remove(65);
//        tree.remove(50);
//        tree.remove(60);
//        tree.display();

//        System.out.println("Balanced: " + tree.isBalanced());
    }
}
