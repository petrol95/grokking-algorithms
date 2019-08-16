package Inner;

public class MainClass {

    public static void main(String[] args) {

        // Outer and inner classes
        Outer outer = new Outer(30);
        Outer.Inner inner = outer.new Inner(20);
        Outer.Inner inner2 = new Outer(40).new Inner(20);
        inner.innerInfo();
        inner2.innerInfo();
        outer.outerInfo();

        // Outer and nested classes
        Souter.Nested nested = new Souter.Nested();
        Souter souter = new Souter();
        nested.Info();
        souter.souterInfo();

        // Local class
        class Point {
            int x;
            int y;
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        Point point = new Point(10,10);
    }
}
