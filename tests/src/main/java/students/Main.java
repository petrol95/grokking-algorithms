package students;

public class Main {

    public static void main(String[] args) throws Exception {

        try(StudentService ss = new StudentService("tests/Students.db")) {
            StudentDAO dao = ss.getDAO();

            System.out.println(dao.getStudent(1));

            Student student = new Student();
            student.setName("Losev");
            student.setMark(4);
            dao.saveStudent(student);

        }
    }
}
