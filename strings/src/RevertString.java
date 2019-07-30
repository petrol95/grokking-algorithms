import java.util.Stack;

/**
 * Функция, переворачивающая строку
 */

public class RevertString {

    public static void main(String[] args) {
        String str = "industrialization";
        System.out.println(str);
        revertString(str);
    }

    private static void revertString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }
}