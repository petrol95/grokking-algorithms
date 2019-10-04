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
        Assert.assertArrayEquals(new Integer[]{1, 7}, array.transformArray(new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void testEmpty() {
        Assert.assertArrayEquals(new Integer[]{}, array.transformArray(new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        array.transformArray(new Integer[]{1, 2, 1, 7});
    }
}
