package Tree;

import java.util.Random;

import static Tree.TraverseMode.*;

public class MainTree {

    public static void main(String[] args) {
//        testTree();
        testDZ();
    }

    private static void testDZ() {
        int treeNum = 20;
        int levelNum = 4;
        int nodeNum = (int)(Math.pow(2, levelNum) - 1)/2;
        int maxValue = 20;

        Random rand = new Random();
        int sumBalanced = 0;

        for (int i = 0; i < treeNum; i++) {
            Tree tree = new TreeImpl(levelNum);
            for (int j = 0; j < nodeNum; j++) {
                int id = rand.nextInt(maxValue * 2 + 1) - maxValue;
                tree.insert(new NodeImpl(id, "Petr", 100));
            }
            tree.display();
            if (tree.isBalanced()) {
                sumBalanced++;
            }
        }
        System.out.println("Trees: " + treeNum + "; balanced, : " + (sumBalanced * 100.0 / treeNum) + " %");
    }

    private static void testTree() {
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
