import service.ClientService;

public class Main {
    public static void main(String[] args) {

        ClientService cs = new ClientService("databases/NewSample.db");
        System.out.println(cs.getDAO().getClient(1));

    }
}
