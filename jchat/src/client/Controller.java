package client;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    final String SERVER_IP = "localhost";
    final int SERVER_PORT = 8189;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean authorized;
    private ObservableList<String> clientsList;
    private String myNick;

    @FXML
    TextArea textArea;
    @FXML
    TextField msgField;
    @FXML
    HBox authPanel;
    @FXML
    HBox msgPanel;
    @FXML
    TextField loginField;
    @FXML
    PasswordField passField;
    @FXML
    ListView clientsListView;

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
        if (authorized) {
            authPanel.setVisible(false);
            authPanel.setManaged(false);
            msgPanel.setVisible(true);
            msgPanel.setManaged(true);
            clientsListView.setVisible(true);
            clientsListView.setManaged(true);
        } else {
            authPanel.setVisible(true);
            authPanel.setManaged(true);
            msgPanel.setVisible(false);
            msgPanel.setManaged(false);
            clientsListView.setVisible(false);
            clientsListView.setManaged(false);
            myNick = "";
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAuthorized(false);
    }

    public void connect() {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            clientsList = FXCollections.observableArrayList();
            clientsListView.setItems(clientsList);

            clientsListView.setCellFactory(new Callback<ListView, ListCell>() {
                @Override
                public ListCell call(ListView param) {
                    return new ListCell<String>() {
                        @Override
                        protected void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if(!empty) {
                                setText(item);
                                if (item.equals(myNick)) {
                                    setStyle("-fx-font-weight: bold; -fx-background-color: #cfff65;");
                                }
                            } else {
                                setGraphic(null);
                                setText(null);
                            }
                        }
                    };
                }
            });

            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.readUTF();
                        if (msg.startsWith("/authok ")) { // /authok nick1
                            setAuthorized(true);
                            myNick = msg.split("\\s")[1];
                            break;
                        }
                        textArea.appendText(msg + "\n");
                    }

                    while (true) {
                        String msg = in.readUTF();
                        if (msg.startsWith("/clientsList")) {
                            String[] data = msg.split("\\s");
                            Platform.runLater(() -> {
                                clientsList.clear();
                                for (int i = 1; i < data.length; i++) {
                                    clientsList.addAll(data[i]);
                                }
                            });
                        }
                        textArea.appendText(msg + "\n");
                    }
                } catch (IOException e) {
                    showAlert("Сервер перестал отвечать");
                } finally {
                    setAuthorized(false);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.setDaemon(true);
            t.start();

        } catch (IOException e) {
            showAlert("Не удалось подключиться к серверу. Проверьте сетевое соединение");
        }
    }

    public void sendAuthMsg() {
        if (loginField.getText().isEmpty() || passField.getText().isEmpty()) {
            showAlert("Указаны неполные данные авторизации");
            return;
        }
        if (socket == null || socket.isClosed()) {
            connect();
        }
        try { // /auth login pass
            out.writeUTF("/auth " + loginField.getText() + " " + passField.getText());
            loginField.clear();
            passField.clear();
        } catch (IOException e) {
            showAlert("Не удалось подключиться к серверу. Проверьте сетевое соединение");
        }
    }

    public void sendMsg() {
        try {
            out.writeUTF(msgField.getText());
            msgField.clear();
            msgField.requestFocus();
        } catch (IOException e) {
            showAlert("Не удалось подключиться к серверу. Проверьте сетевое соединение");
        }
    }

    public void showAlert(String msg) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Возникли проблемы");
            alert.setHeaderText(null);
            alert.setContentText(msg);
            alert.showAndWait();
        });
    }

    public void clientsListClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            msgField.setText("/w" + clientsListView.getSelectionModel().getSelectedItem());
            msgField.requestFocus();
            msgField.selectEnd();
        }
    }
}
