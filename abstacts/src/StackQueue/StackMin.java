package StackQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * Реализовать структуру на основе стека с возможностью нахождения наименьшего элемента за время О(1), сохранив
 * добавление и удаление из стека за О(1)
 */

public class StackMin {
    public static void main(String[] args) {
        PairStack pairStack = new PairStack();
        pairStack.add(20);
        pairStack.add(30);
        pairStack.add(40);
        pairStack.add(10);
        pairStack.add(50);
        System.out.println(pairStack);
        System.out.println("peek: " + pairStack.peek());
        System.out.println("min: " + pairStack.findMin());
        pairStack.pop();
        pairStack.pop();
        System.out.println(pairStack);
        System.out.println("min: " + pairStack.findMin());
    }
}

class PairStack {
    private Stack<Integer>[] stackArr;

    public PairStack() {
        stackArr = new Stack[2];
        stackArr[0] = new Stack<>(); // элемент
        stackArr[1] = new Stack<>(); // минимум в стеке, начиная с элемента и ниже
    }

    public void add(int value) {
        stackArr[1].push(stackArr[0].empty() ? value : Math.min(value, stackArr[1].peek()));
        stackArr[0].push(value);
    }

    public int pop() {
        stackArr[1].pop();
        return stackArr[0].pop();
    }

    public int peek() {
        return stackArr[0].peek();
    }

    public int findMin() {
        return stackArr[1].peek();
    }

    @Override
    public String toString() {
        return Arrays.toString(stackArr);
    }
}