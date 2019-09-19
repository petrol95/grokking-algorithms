package Generics.arraychange;

import java.util.List;

public class DemoChange {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4, 5};
        ArrayChange<Integer> intCE = new ArrayChange<>(intArr);
        String[] strArr = {"a", "b", "c", "d", "e"};
        ArrayChange<String> strCE = new ArrayChange<>(strArr);

        intCE.changeElements(1,4);
        System.out.println(intCE);
        strCE.changeElements(0,3);
        System.out.println(strCE);

        List<Integer> intList = intCE.transformToArrayList();
        System.out.println(intCE.transformToArrayList().getClass().getSimpleName() + ": " + intList);
        List<String> strList = strCE.transformToArrayList();
        System.out.println(strCE.transformToArrayList().getClass().getSimpleName() + ": " + strList);
    }
}
