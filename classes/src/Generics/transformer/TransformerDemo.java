package Generics.transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransformerDemo {

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>(Arrays.asList(111, 222, 333));
        List<String> strList = CollectionUtils.transform(intList, obj -> String.valueOf(obj));
        System.out.println(strList);

        Integer[] intArr = {444, 555, 666};
        List<String> strList2 = CollectionUtils.transform(intArr, obj -> String.valueOf(obj) + "ххх");
        System.out.println(strList2);
    }
}
