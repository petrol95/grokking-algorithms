package console;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения
 * как на клиентской стороне, так и на серверной. Сервер общается только с одним клиентом.
 */

public class ClientMain {

    public static void main(String[] args) {

        final String SERVER_IP = "localhost";
        final int SERVER_PORT = 8189;

        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected to chat...");

            Scanner inKey = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // ввод с клавиатуры
            new Thread(() -> {
                try {
                    while (true) {
                        String msg = inKey.nextLine();
                        System.out.println(msg);
                        out.println(msg);
                        if (msg.equals("/end"))
                            break;
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

            // обработка сообщения с сервера
            new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.nextLine();
                        System.out.println("from server: " + msg);
                        if (msg.equals("/end"))
                            break;
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