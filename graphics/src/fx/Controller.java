import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    public TextArea jta;
    public TextField jtf;

    public void sendMsg() {
        jta.appendText(jtf.getText() + "\n");
        jtf.clear();
        jtf.requestFocus();
    }
}
