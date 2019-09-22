package main.java.service.repository;

import main.java.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleDAO implements ProductDAO {
    private Connection connection;
    private PreparedStatement ps;

    public SimpleDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean createTable() {
        try {
            Statement stmt = connection.createStatement();
            return stmt.execute("CREATE TABLE IF NOT EXISTS products (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "PRODID INTEGER," +
                    "TITLE TEXT," +
                    "COST INTEGER)");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
    }

    @Override
    public boolean clearTable() {
        try {
            ps = connection.prepareStatement("DELETE FROM products");
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
    }

    @Override
    public void fillTable(int count) throws SQLException {
        connection.setAutoCommit(false);
        try {
            ps = connection.prepareStatement("INSERT INTO products (ID, PRODID, TITLE, COST) " +
                    "VALUES (?, ?, ?, ?)");
            for (int i = 1; i <= count; i++) {
                ps.setInt(1, i);
                ps.setInt(2, 7000 + i);
                ps.setString(3, "product_" + i);
                ps.setInt(4, i);
                ps.addBatch();
            }
            ps.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public int getPrice(String title) {
        try {
            ps = connection.prepareStatement("SELECT COST FROM products WHERE TITLE = ?");
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
        return 0;
    }

    @Override
    public boolean setPrice(String title, int price) {
        try {
            ps = connection.prepareStatement("UPDATE products SET COST = ? WHERE TITLE = ?" );
            ps.setInt(1, price);
            ps.setString(2, title);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
    }

    @Override
    public List<Product> getProductsByPrice(int priceFrom, int priceTo) {
        List<Product> products = new ArrayList<>();
        try {
            ps = connection.prepareStatement("SELECT ID, PRODID, TITLE, COST " +
                    "FROM products WHERE COST BETWEEN ? AND ?");
            ps.setInt(1, priceFrom);
            ps.setInt(2, priceTo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                products.add(createProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    private Product createProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt(1));
        product.setProductId(rs.getInt(2));
        product.setTitle(rs.getString(3));
        product.setCost(rs.getInt(4));
        return product;
    }
}