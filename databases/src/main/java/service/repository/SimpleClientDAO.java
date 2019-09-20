package service.repository;

import model.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class SimpleClientDAO implements ClientDAO {
    private Connection connection;

    public SimpleClientDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Client getClient(int id) {
        Client client = null;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT FIRSTNAME, SURNAME, BIRTHDATE " +
                    "FROM Client WHERE ID = " + id);
            while (rs.next()) {
                client = new Client();
                client.setId(id);
                client.setFirstName(rs.getString(1));
                client.setSurname(rs.getString(2));
                client.setBirthDate(LocalDate.parse(rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

}

