import model.Client;
import service.ClientService;
import service.repository.ClientDAO;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {

        try(ClientService cs = new ClientService("databases/NewSample.db")) {
            ClientDAO dao = cs.getDAO();

            System.out.println(dao.getClient(1));

            Client client = new Client();
            client.setFirstName("Artem");
            client.setSurname("Sidorov");
            client.setBirthDate(LocalDate.parse("2019-01-02"));
            dao.saveClient(client);

            System.out.println(dao.removeClient(10));

            dao.createPhones(2, 10);

            System.out.println(dao.getAllClients());
        }
    }
}
