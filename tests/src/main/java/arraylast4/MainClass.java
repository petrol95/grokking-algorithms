package arraylast4;

import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {

        ArrayLast4 al = new ArrayLast4();
        Integer[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        System.out.println(Arrays.toString(al.transformArray(arr)));
    }
}
