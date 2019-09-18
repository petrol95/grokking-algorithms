package Generics.transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtils {

    public static <T, R> List<R> transform(List<T> values, Transformer<T, R> transformer) {
        List<R> result = new ArrayList<>();
        for (T value : values) {
            result.add(transformer.transform(value));
        }
        return result;
    }

    public static <T,R> List<R> transform(T[] values, Transformer<T, R> transformer) {
        return transform(new ArrayList<T>(Arrays.asList(values)), transformer);
    }
}

