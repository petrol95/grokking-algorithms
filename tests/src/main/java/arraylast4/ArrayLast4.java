package arraylast4;

import java.util.Arrays;
import java.util.List;

public class ArrayLast4 {

    public static final int DIGIT = 4;

    public Integer[] transformArray(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        int index = list.lastIndexOf(DIGIT);
        if (index == -1)
            throw new RuntimeException();
        return list.subList(index + 1, list.size()).toArray(new Integer[0]);
    }
}
