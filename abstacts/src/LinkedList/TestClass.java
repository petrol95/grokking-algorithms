package LinkedList;

import StackQueue.Stack;

public class TestClass {
    public static void main(String[] args) {

//        LinkedList linkedList = new SimpleLinkedListImpl();
//        LinkedList linkedList = new TwoSideLinkedListImpl();
//        TwoSideLinkedList linkedList = new TwoSideLinkedListImpl();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(4);
//        linkedList.add(5);
//        linkedList.add(6);
//        linkedList.display();
//        System.out.println(linkedList.remove());
//        System.out.println(linkedList.remove(5));
//        linkedList.display();
//        linkedList.addLast(7);
//        linkedList.addLast(8);
//        linkedList.display();
//
//        System.out.println("Find 8: " + linkedList.search(4));
//        System.out.println("Find 81: " + linkedList.search(81));
//
//        while(!linkedList.isEmpty()) {
//            System.out.println(linkedList.remove());
//        }

        System.out.println("---Test Stack---");
        Stack stack = new LinkedStackImpl();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        stack.display();
        stack.pop();
        stack.pop();
        System.out.println("peek: " + stack.peek());
        stack.display();
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\nStack is empty: " + stack.isEmpty());

    }
}
