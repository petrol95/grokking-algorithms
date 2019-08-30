package console;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения
 * как на клиентской стороне, так и на серверной. Сервер общается только с одним клиентом.
 */

public class ServerMain {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server started. Waiting for clients...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            Scanner inKey = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // ввод с клавиатуры
            new Thread(() -> {
                try {
                    while (true) {
                        String msg = inKey.nextLine();
                        System.out.println("from server: " + msg);
                        if (msg.equals("/end"))
                            break;
                        out.println(msg);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            // обработка сообщения от клиента
            new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.nextLine();
                        System.out.println("from client: " + msg);
                        if (msg.equals("/end"))
                            break;
                        out.println("echo: " + msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
