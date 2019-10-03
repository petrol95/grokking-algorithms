package students;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentDAOTest {

    private static StudentService ss;
    private static StudentDAO dao;

    @BeforeClass
    public static void setUp() throws Exception {
        ss = new StudentService("Students.db");
        dao = ss.getDAO();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        cancelUpdates();
        ss.close();
    }

    @Test
    public void getStudentTest() {
        Assert.assertEquals(dao.getStudent(1), new Student(1, "Ivanov", 5));
    }

    @Test
    public void saveStudentTest() {
        Assert.assertEquals(dao.saveStudent(new Student("New", 3)), 1);
    }

    @Test
    public void updateStudentTest() {
        Assert.assertEquals(dao.updateStudent("Petrov"), 1);
    }

    private static void cancelUpdates() {
        dao.emptyTab();
        dao.saveStudent(new Student("Ivanov", 5));
        dao.saveStudent(new Student("Petrov", 4));
        dao.saveStudent(new Student("Sidorov", 2));
    }
}
