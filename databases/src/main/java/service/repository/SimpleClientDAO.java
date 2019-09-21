package service.repository;

import model.Client;
import model.Phone;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SimpleClientDAO implements ClientDAO {
    private Connection connection;
    private PreparedStatement ps;

    public SimpleClientDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Client getClient(int id) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Client WHERE ID = " + id);
            while (rs.next()) {
                Client client = createClient(rs);
                List<Phone> phones = getPhonesForClient(id);
                client.getPhones().addAll(phones);
                return client;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
        return null;
    }

    @Override
    public List<Phone> getPhonesForClient(int clientId) {
        List<Phone> phones = new ArrayList<>();
        try {
            ps = connection.prepareStatement("SELECT ID, TYPE, NUMBER " +
                    "FROM Phone WHERE CLIENT_ID = ?");
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                phones.add(createPhone(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
        return phones;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Client");
            while (rs.next()) {
                Client client = createClient(rs);
                List<Phone> phones = getPhonesForClient(client.getId());
                client.getPhones().addAll(phones);
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
        return clients;
    }

    @Override
    public void saveClient(Client client) {
        try {
            ps = connection.prepareStatement("INSERT INTO Client (FIRSTNAME, SURNAME, BIRTHDATE) VALUES " +
                    "(?, ?, ?)");
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getSurname());
            ps.setString(3, client.getBirthDate().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
    }

    @Override
    public boolean removeClient(int clientId) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeUpdate("DELETE FROM Client WHERE id = " + clientId) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void createPhones(int clientId, int count) throws SQLException {
        ps = connection.prepareStatement("INSERT INTO Phone (TYPE, NUMBER, CLIENT_ID) VALUES ('Work', ?, ?)");
        connection.setAutoCommit(false);
        try {
            for (int i = 0; i < count; i++) {
                ps.setString(1, "111-222-33" + i);
                ps.setInt(2, clientId);
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

    private Client createClient(ResultSet rs) throws SQLException {
        Client client = new Client();
        client.setId(rs.getInt(1));
        client.setFirstName(rs.getString(2));
        client.setSurname(rs.getString(3));
        client.setBirthDate(LocalDate.parse(rs.getString(4)));
        return client;
    }

    private Phone createPhone(ResultSet rs) throws SQLException {
        Phone phone = new Phone();
        phone.setId(rs.getInt(1));
        phone.setType(rs.getString(2));
        phone.setNumber(rs.getString(3));
        return phone;
    }

}

