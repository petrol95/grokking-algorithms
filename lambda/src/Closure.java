import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Closure {
    public static void main(String[] args) {
        repeatMessage("Hello", 1000);
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    private static void repeatMessage(String text, int delay) {
        ActionListener listener = event -> {
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };
        new Timer(delay, listener).start();
    }
}
