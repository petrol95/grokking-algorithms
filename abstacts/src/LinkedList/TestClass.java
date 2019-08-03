package LinkedList;

public class TestClass {
    public static void main(String[] args) {

//        LinkedList linkedList = new SimpleLinkedListImpl();
//        LinkedList linkedList = new TwoSideLinkedListImpl();
        TwoSideLinkedList linkedList = new TwoSideLinkedListImpl();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.display();
        System.out.println(linkedList.remove());
        System.out.println(linkedList.remove(5));
        linkedList.display();
        linkedList.addLast(7);
        linkedList.addLast(8);
        linkedList.display();

        System.out.println("Find 8: " + linkedList.search(4));
        System.out.println("Find 81: " + linkedList.search(81));

        while(!linkedList.isEmpty()) {
            System.out.println(linkedList.remove());
        }

    }
}
