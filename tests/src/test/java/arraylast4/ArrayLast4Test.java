package arraylast4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayLast4Test {

    private ArrayLast4 array;

    @Before
    public void prepare() {
        array = new ArrayLast4();
    }

    @After
    public void tearDown() {
        array = null;
    }

    @Test
    public void testPositive() {
        Integer[] arg = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        Integer[] res = {1, 7};
        Assert.assertArrayEquals(res, array.transformArray(arg));
    }

    @Test
    public void testEmpty() {
        Integer[] arg = {1, 2, 4, 4, 2, 3, 4, 1, 4};
        Integer[] res = {};
        Assert.assertArrayEquals(res, array.transformArray(arg));
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        Integer[] arg = {1, 2, 1, 7};
        Assert.assertEquals(array.transformArray(arg), RuntimeException.class);
    }
}
