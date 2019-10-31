package comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainComparator {

    public static void main(String[] args) {

        String[] array1 = {"trick", "or", "treat"};
        String[] array2 = {"happy", "halloween"};
        String[] array3 = {"moans", "and", "groans"};

        List<String[]> arrays = new ArrayList<>();
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);

//        arrays.sort((o1, o2) -> o1.length - o2.length);

        arrays.sort((o1, o2) -> {
                int length1 = 0;
                int length2 = 0;
                for(String s : o1) {
                    length1 += s.length();
                }
                for(String s : o2) {
                    length2 += s.length();
                }
                return length1 - length2;
        });

        for(String[] arr : arrays) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
