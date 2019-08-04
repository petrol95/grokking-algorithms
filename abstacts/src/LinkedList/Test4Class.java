package LinkedList;

import StackQueue.Queue;
import StackQueue.Stack;

import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.ListIterator;
import java.util.function.Predicate;

public class Test4Class {
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

//        System.out.println("---Test Stack---");
//        Stack stack = new LinkedStackImpl();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.push(6);
//
//        stack.display();
//        stack.pop();
//        stack.pop();
//        System.out.println("peek: " + stack.peek());
//        stack.display();
//        while(!stack.isEmpty()) {
//            System.out.print(stack.pop() + " ");
//        }
//        System.out.println("\nStack is empty: " + stack.isEmpty());

//        System.out.println("---Test Queue---");
//        Queue queue = new LinkedQueueImpl();
//        queue.addRight(1);
//        queue.addRight(2);
//        queue.addRight(3);
//        queue.addRight(4);
//        queue.addRight(5);
//        queue.addRight(6);
//
//        queue.display();
//        queue.removeLeft();
//        queue.removeLeft();
//        queue.display();
//        while(!queue.isEmpty()) {
//            System.out.print(queue.removeLeft() + " ");
//        }
//        System.out.println("\nqueue is empty: " + queue.isEmpty());

//        testIterator();

        LinkedList linkedList = new SimpleLinkedListImpl();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        for (Link value : linkedList) {
            System.out.println(value);
        }

    }

//    private static void testIterator() {
//        List<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);

//        for (Integer value : linkedList) {
////            linkedList.remove(0);
//            System.out.println(value);
//        }

//        Iterator<Integer> iterator = linkedList.iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            System.out.println(next);
//            iterator.remove();
//        }

//        ListIterator<Integer> iterator = linkedList.listIterator();
//        while(iterator.hasNext()) {
//            Integer next = iterator.next();
//            System.out.println(next);
//            iterator.add(22);
////            iterator.remove();
////            iterator.set(22);
//        }

//        linkedList.removeIf(value -> value % 2 != 0);

//        System.out.println("after iterator");
//        for (Integer value : linkedList) {
//            System.out.println(value);
//        }
//    }
}
