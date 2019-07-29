import java.util.Stack;

/**
 * Проверить соответствие открывающих и закрывающих круглых, фигурных
 * и квадратных скобок. Каждая открывающаяся скобка должна иметь пару
 */

public class Brackets {
    String input;

    public Brackets(String input) {
        this.input = input;
    }

    public void check() {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    st.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if (!st.empty()) {
                        char topChar = st.pop();
                        if ((ch == ')' && topChar != '(') || (ch == ']' && topChar != '[') ||
                                (ch == '}' && topChar != '{'))
                            System.out.println("Error " + ch + " at " + i);
                        break;
                    } else
                        System.out.println("Error " + ch + " at " + i);
                default:
                    break;
            }
        }
        if (!st.empty())
            System.out.println("Error: missing right delimiter");
    }

    public static void main(String[] args) {
        System.out.println("Checking String 1");
        String str1 = "public static void main(String[] args) {testStack(;}";
        new Brackets(str1).check();
        System.out.println("Checking String 2");
        String str2 = "public static void main(String[] args) {testStack();}";
        new Brackets(str2).check();
        System.out.println("Check finished");
    }
}