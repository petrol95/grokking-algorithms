package service.repository;

import model.Client;
import model.Phone;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {

    Client getClient(int id);

    List<Phone> getPhonesForClient(int clientId);

    List<Client> getAllClients();

    void saveClient(Client client);

    boolean removeClient(int clientId);

    void createPhones(int clientId, int count) throws SQLException;

}