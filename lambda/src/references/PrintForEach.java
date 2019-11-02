package references;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class PrintForEach {
    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();
        strings.add("trick");
        strings.add("or");
        strings.add("treat");

//        strings.forEach(System.out::println);

        // 1. reference on static method
//        strings.forEach(PrintForEach::staticMethod);

        // 2. reference on non-static method
//        PrintForEach instance = new PrintForEach();
//        strings.forEach(instance::nonStaticMethod);

        List<User> users = new LinkedList<>();
        users.add(new User("Bob"));
        users.add(new User("Daniel"));
        users.add(new User("Michael"));

        // 3. reference on non-static method using class
        users.forEach(User::print);

        // 4. reference on constructor
        Callable<User> c = User::new;

    }

    private static void staticMethod(String s) {
        System.out.println(s);
    }

    private void nonStaticMethod(String s) {
        System.out.println(s);
    }

    private static class User {
        private String name;

        private User() {
        }

        private User(String name) {
            this.name = name;
        }

        private void print() {
            System.out.println(name);
        }
    }
}
