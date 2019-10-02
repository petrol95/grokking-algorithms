package arraylast4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayLast4ParamTest {

    private ArrayLast4 array;

    @Before
    public void prepare() {
        array = new ArrayLast4();
    }

    @After
    public void tearDown() {
        array = null;
    }

    @Parameterized.Parameters
    public static Collection<Integer[][]> data() {
        return Arrays.asList(new Integer[][][]{
                {{1, 2, 4, 4, 2, 3, 4, 1, 7}, {1, 7}},
                {{1, 2, 4, 4, 2, 3, 4, 1, 4}, {}}
                }
        );
    }

    private Integer[] arg;
    private Integer[] res;

    public ArrayLast4ParamTest(Integer[] arg, Integer[] res) {
        this.arg = arg;
        this.res = res;
    }

    @Test
    public void testTransform() {
        Assert.assertArrayEquals(res, array.transformArray(arg));
    }
}
