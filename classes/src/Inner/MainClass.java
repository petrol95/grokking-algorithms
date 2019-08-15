package Inner;

public class MainClass {

    public static void main(String[] args) {
        Outer outer = new Outer(30);
        Outer.Inner inner = outer.new Inner(20);
        Outer.Inner inner2 = new Outer(40).new Inner(20);
        inner.innerInfo();
        inner2.innerInfo();
        outer.outerInfo();

        Souter.Nested nested = new Souter.Nested();
        Souter souter = new Souter();
        nested.Info();
        souter.souterInfo();
    }
}
