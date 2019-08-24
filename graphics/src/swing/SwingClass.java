package swing;

import javax.swing.*;

public class SwingClass {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyWindow());
    }
}
