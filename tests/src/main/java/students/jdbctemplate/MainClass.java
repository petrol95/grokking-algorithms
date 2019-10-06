package students.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import students.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainClass {

    private static String dbName = "tests\\Students.db";
    private static int size = 10;
    private static Student[] students;
    private static String nameTable = "students";

    public static void main(String[] args) {

        Connection connection = new Connection(dbName);

        makeStudentsArray(size);

        ClearTableAndMakeNew(connection.jdbcTemplate);

        List<Object[]> list = new ArrayList<>();
        for (Student student : students) {
            list.add(new Object[]{
                    student.getName(),
                    student.getMark()
            });
        }
        connection.jdbcTemplate.batchUpdate("insert into students (name, mark) values(?,?)", list);
    }

    private static void ClearTableAndMakeNew(JdbcTemplate jdbcTemplate) {
//        jdbcTemplate.execute("DROP TABLE IF EXISTS " + nameTable);
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS " + nameTable +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name text, mark int)");
    }

    private static void makeStudentsArray(int size) {
        students = new Student[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            students[i] = new Student("Студент" + i, rand.nextInt(5) + 1);
        }
    }
}