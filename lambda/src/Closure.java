import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Closure {
    public static void main(String[] args) {
        repeatMessage("Hello", 1000);
        countDown(10, 1000);
        repeat("Bye", 3);
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

    public static void countDown(int start, int delay) {
        ActionListener listener = event -> {
//            start--; // error! variable should be final
            System.out.println(start);
        };
        new Timer(delay, listener).start();
    }

    public static void repeat(String text, int count) {
        for (int i = 1; i <= count; i++) {
            ActionListener listener = event -> {
//                System.out.println(i + ": " + text); // error! variable should be final
                System.out.println(text);
            };
            new Timer(1000, listener).start();
        }
    }
}
