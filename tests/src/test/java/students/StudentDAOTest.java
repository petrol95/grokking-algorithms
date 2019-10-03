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
        ss.close();
    }

    @Test
    public void getStudentTest() {
        Assert.assertEquals(dao.getStudent(1), new Student(1, "Ivanov", 5));
    }

    @Test
    public void saveStudentTest() {
        Student newStudent = new Student();
        newStudent.setName("New");
        newStudent.setMark(3);
        Assert.assertEquals(dao.saveStudent(newStudent), 1);
    }

    @Test
    public void updateStudentTest() {
        Assert.assertEquals(dao.updateStudent("Petrov"), 1);
    }
}
