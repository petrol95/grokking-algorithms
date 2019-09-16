package Generics.change;

public class DemoChange {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4, 5};
        ArrayChange<Integer> intCE = new ArrayChange<>(intArr);
        String[] strArr = {"a", "b", "c", "d", "e"};
        ArrayChange<String> strCE = new ArrayChange<>(strArr);

        intCE.change(1,4);
        System.out.println(intCE);
        strCE.change(0,3);
        System.out.println(strCE);

    }
}
