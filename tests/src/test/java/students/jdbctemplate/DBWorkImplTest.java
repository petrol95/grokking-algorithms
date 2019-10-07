package students.jdbctemplate;

import org.hamcrest.core.Is;
import org.junit.*;
import org.junit.runners.MethodSorters;
import students.Student;

import java.util.Collections;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DBWorkImplTest {

    private static String dbName = "Students.db";
    private Connection con;
    private DBWork dbw;
    private Student stdTest = new Student("ТестовыйСтудент", 4);

    @Before
    public void prepare() {
        con = new Connection(dbName);
        dbw = new DBWorkImpl(con);
    }

    @After
    public void tearDown() {
        dbw = null;
        con = null;
    }

    @Test
    public void a_testAddDB() {
        int rowsUpdated = dbw.addToDB(stdTest.getName(), stdTest.getMark());
        Assert.assertThat(rowsUpdated, Is.is(1));
    }

    @Test
    public void b_testReadDB() {
        Student studentFromDb = dbw.readFromDB(stdTest.getName()).get(0);
        stdTest.setId(studentFromDb.getId());
        Assert.assertEquals(stdTest, studentFromDb);
    }

    @Test
    public void c_update() {
        int newMark = 2;
        int rowsUpdated = dbw.update(stdTest.getName(), newMark);
        Assert.assertThat(rowsUpdated, Is.is(1));

        Student studentFromDb = dbw.readFromDB(stdTest.getName()).get(0);
        Assert.assertEquals(2, studentFromDb.getMark());
    }

    @Test
    public void d_testDeleteDB() {
        Assert.assertThat(dbw.delFromDB(stdTest.getName()), Is.is(1));
        Assert.assertThat(dbw.readFromDB(stdTest.getName()), Is.is(Collections.emptyList()));
    }

}
