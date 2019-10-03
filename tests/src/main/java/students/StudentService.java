package students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentService implements AutoCloseable {
    private Connection connection;
    private StudentDAO dao;

    public StudentDAO getDAO() {
        return dao;
    }

    public StudentService(String DBName) {
        connectDriver();
        this.connection = connect(DBName);
        dao = new StudentDAO(connection);
    }

    private Connection connect(String dbName) {
        try {
            return DriverManager.getConnection("jdbc:sqlite:" + dbName);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Invalid DB name " + dbName);
        }
    }

    private void connectDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found", e);
        }
    }

    public void close() throws SQLException {
        if (connection != null)
            connection.close();
    }
}

