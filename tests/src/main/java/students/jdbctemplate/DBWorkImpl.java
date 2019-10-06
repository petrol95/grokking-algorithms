package students.jdbctemplate;

import students.Student;

import java.util.List;

public class DBWorkImpl implements DBWork {

    private Connection connection;

    public DBWorkImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int addToDB(String name, int mark) {
        return connection.jdbcTemplate.update("INSERT INTO students (NAME, MARK) VALUES (?, ?)", name, mark);
    }

    @Override
    public int delFromDB(String name) {
        return connection.jdbcTemplate.update("DELETE FROM students where name = ?", name);
    }

    @Override
    public List<Student> readFromDB(String name) {
        List<Student> results = connection.jdbcTemplate.query(
                "SELECT * FROM students where name = ?",
                (rs, rowNum) -> new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("mark")), name);
        return results;
    }

    @Override
    public int update(String name, int newMark) {
        return connection.jdbcTemplate.update("UPDATE students SET MARK = ? WHERE name = ?", newMark, name);
    }

}
