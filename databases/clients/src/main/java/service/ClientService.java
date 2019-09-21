package service;

import service.repository.ClientDAO;
import service.repository.SimpleClientDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClientService implements AutoCloseable {
    private Connection connection;
    private ClientDAO dao;

    public ClientDAO getDAO() {
        return dao;
    }

    public ClientService(String DBName) {
        connectDriver();
        this.connection = connect(DBName);
        dao = new SimpleClientDAO(connection);
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
