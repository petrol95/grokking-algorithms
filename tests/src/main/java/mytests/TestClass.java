package mytests;

public class TestClass {

    public TestClass() {
    }

    @BeforeSuite
    public void prepare() {
        System.out.println("BeforeSuite method running...");
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("AfterSuite method running...");
    }

    @Test(priority = 9)
    public void testMethod9() {
        System.out.println("Test9 running...");
    }

    @Test(priority = 3)
    public void testMethod3() {
        System.out.println("Test3 running...");
    }

}
