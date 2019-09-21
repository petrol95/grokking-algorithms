package main.java.service;

import main.java.service.repository.ProductDAO;
import main.java.service.repository.SimpleDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductService implements AutoCloseable {
    private Connection connection;
    private ProductDAO dao;

    public ProductService(String nameDB) {
        connectDriver();
        connection = connect(nameDB);
        dao = new SimpleDAO(connection);
    }

    public ProductDAO getDao() {
        return dao;
    }

    private Connection connect(String nameDB) {
        try {
            return DriverManager.getConnection("jdbc:sqlite:databases/" + nameDB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void connectDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found", e);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
