package students;

import java.sql.*;

public class StudentDAO {
    private Connection connection;
    private PreparedStatement ps;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    public Student getStudent(int id) {
        try {
            ps = connection.prepareStatement("SELECT * FROM students WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = createStudent(rs);
                return student;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
        return null;
    }

    public int saveStudent(Student student) {
        try {
            ps = connection.prepareStatement("INSERT INTO students (NAME, MARK) VALUES (?, ?)");
            ps.setString(1, student.getName());
            ps.setInt(2, student.getMark());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
    }

    public int updateStudent(String name) {
        try {
            ps = connection.prepareStatement("UPDATE students SET MARK = ? WHERE name = ?");
            ps.setInt(1, 6);
            ps.setString(2, name);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
    }

    private Student createStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt(1));
        student.setName(rs.getString(2));
        student.setMark(rs.getInt(3));
        return student;
    }

    public void emptyTab() {
        try {
            ps = connection.prepareStatement("DELETE FROM students");
            ps.executeUpdate();
            ps = connection.prepareStatement("DELETE FROM sqlite_sequence WHERE name = 'students'");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
    }
}
