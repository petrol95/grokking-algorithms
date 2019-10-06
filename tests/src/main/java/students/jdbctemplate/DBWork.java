package students.jdbctemplate;

import students.Student;
import java.util.List;

public interface DBWork {

    int addToDB(String name, int mark);

    int delFromDB(String name);

    List<Student> readFromDB(String name);

    int update(String name, int newMark);

}
