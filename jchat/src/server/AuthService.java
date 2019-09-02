package server;

import java.sql.*;

public class AuthService {
    private Connection connection;
    private Statement stmt;

    public Connection getConnection() {
        return connection;
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:jchat/main.db");
        stmt = connection.createStatement();
    }

    public String getNickByLoginAndPass(String login, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT nick FROM users WHERE login = '" + login +
                    "' AND password = '" + pass + "';");
            if (rs.next()) {
                return rs.getString("nick");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void disconnect() {
        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
