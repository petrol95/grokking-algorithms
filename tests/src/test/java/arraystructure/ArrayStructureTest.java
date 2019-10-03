package arraystructure;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayStructureTest {

    private ArrayStructure array;

    @Before
    public void prepare() {
        array = new ArrayStructure();
    }

    @After
    public void tearDown() {
        array = null;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new Integer[]{1, 2, 3, 4}, true},
                {new Integer[]{1, 2, 3}, false},
                {new Integer[]{2, 3, 4}, false},
                {new Integer[]{5, 6, 7, 8}, false}
        });
    }

    private Integer[] arg;
    private boolean res;

    public ArrayStructureTest(Integer[] arg, boolean res) {
        this.arg = arg;
        this.res = res;
    }

    @Test
    public void testCheckArray() {
        Assert.assertEquals(array.checkArray(arg), res);
    }
}
