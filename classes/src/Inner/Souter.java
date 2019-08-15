package Inner;

/**
 * Outer and nested classes
 */

public class Souter {

    public static class Nested {

        public void Info() {
//            souterVar = 10;
            System.out.println("nested");
        }

    }
    int souterVar = 10;
    public void souterInfo() {
        System.out.println("souter " + souterVar);
    }
}
