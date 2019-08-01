public class TestClass {

    public static void main(String[] args) {
//        System.out.println("---Stack---");
//        Stack stack = new StackImpl(5);
//        addToStack(stack,1);
//        addToStack(stack,2);
//        addToStack(stack,3);
//        addToStack(stack,4);
//        addToStack(stack,5);
//        addToStack(stack,6);
//
//        stack.display();
//        stack.pop();
//        stack.pop();
//        System.out.println("peek: " + stack.peek());
//        stack.display();
//
//        while(!stack.isEmpty()) {
//            System.out.print(stack.pop() + " ");
//        }
//        System.out.println("\nStack is empty: " + stack.isEmpty());
//
//        System.out.println("---Queue---");
//        Queue queue = new QueueImpl(5);
//        addToQueue(queue, 1);
//        addToQueue(queue, 2);
//        addToQueue(queue, 3);
//        addToQueue(queue, 4);
//        addToQueue(queue, 5);
//        addToQueue(queue, 6);
//
//        queue.display();
//        queue.removeLeft();
//        queue.removeLeft();
//        queue.display();
//
//        while(!queue.isEmpty()) {
//            System.out.print(queue.removeLeft() + " ");
//        }
//        System.out.println("\nqueue is empty: " + queue.isEmpty());
//
//        System.out.println("---Priority Queue---");
//        PriorityQueue prQueue = new PriorityQueue(5);
//        prQueue.insert(10);
//        prQueue.insert(40);
//        prQueue.insert(30);
//        prQueue.insert(50);
//        prQueue.insert(20);
//        prQueue.display();
//        while (!prQueue.isEmpty()) {
//            System.out.print(prQueue.remove() + " ");
//        }
//        System.out.println("\nprQueue is empty: " + prQueue.isEmpty());

        System.out.println("---Deque---");
        DequeImpl deque = new DequeImpl(5);
        deque.addRight(1);
        deque.addRight(2);
        deque.addRight(3);
        deque.display();
        deque.addLeft(4);
        deque.display();
        deque.addLeft(5);
        deque.display();
        deque.removeLeft();
        deque.display();
        deque.removeRight();
        deque.display();
    }

    private static void addToQueue(Queue queue, int value) {
        if (!queue.isFull()) {
            queue.addRight(value);
        }
    }

    private static void addToStack(Stack stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
        }
    }
}
