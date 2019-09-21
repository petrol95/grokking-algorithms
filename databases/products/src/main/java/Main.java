package main.java;

import main.java.service.ProductService;
import main.java.service.repository.ProductDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try (ProductService prService = new ProductService("Products.db")) {
            ProductDAO dao = prService.getDao();
            dao.createTable();
            dao.clearTable();
            dao.fillTable(10000);

            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("Enter the command:");
                String msg = scanner.nextLine();

//                /price product_100
                if (msg.startsWith("/price ")) {
                    String[] data = msg.split("\\s");
                    int res = dao.getPrice(data[1]);
                    if (res == 0)
                        System.out.println("No such a product");
                    else
                        System.out.println("Price = " + res);
                }

//                /changePrice product_100 222
                if (msg.startsWith("/changePrice ")) {
                    String[] data = msg.split("\\s");
                    if (dao.setPrice(data[1], Integer.parseInt(data[2])))
                        System.out.println("ok");
                    else
                        System.out.println("failure");
                }

//                /productsByPrice 50 65
                if (msg.startsWith("/productsByPrice ")) {
                    String[] data = msg.split("\\s");
                    int priceFrom = Integer.parseInt(data[1]);
                    int priceTo = Integer.parseInt(data[2]);
                    System.out.println(dao.getProductsByPrice(priceFrom, priceTo));
                }

//                /end
                if (msg.equals("/end"))
                    break;
            }

        }
    }
}