package arraystructure;

import java.util.Arrays;
import java.util.List;

public class ArrayStructure {

    public static final int DIGIT_1 = 1;
    public static final int DIGIT_2 = 4;

    public boolean checkArray(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        return list.contains(DIGIT_1) && list.contains(DIGIT_2);
    }
}
