package main.java.service.repository;

import main.java.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

    boolean createTable();

    boolean clearTable();

    void fillTable(int count) throws SQLException;

    int getPrice(String title);

    boolean setPrice(String title, int price);

    List<Product> getProductsByPrice(int priceFrom, int priceTo);

}
