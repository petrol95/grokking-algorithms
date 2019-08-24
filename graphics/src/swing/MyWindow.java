package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyWindow extends JFrame {
    JTextField jtf;
    JTextArea jta;

    class MyTextField extends JTextField{
        String hint;

        public MyTextField(String hint) {
            this.hint = hint;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (getText().isEmpty())
                g.drawString(hint, 6, 20);
        }
    }

    private void sendMsg() {
        jta.append(jtf.getText() + "\n");
        jtf.setText("");
        jtf.grabFocus();
    }

    public MyWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My application");
        setBounds(800, 400, 400, 400);
        setLayout(new BorderLayout());

        jta = new JTextArea(10,15);
        JScrollPane jsp = new JScrollPane(jta);
        jta.setLineWrap(true);

        JPanel upperPanel = new JPanel();
        jtf = new MyTextField("Введите слово");
        jtf.setPreferredSize(new Dimension(200, 25));
        jtf.addActionListener(e -> sendMsg());

        JButton jb1 = new JButton("Button #1");
        jb1.addActionListener(e -> {
//                JOptionPane.showInputDialog(null, "Here is your value:", 10);
            JOptionPane.showOptionDialog(null, "Please make a choice",
                    "Window", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    new Object[] {"A", "B", "C", "D"}, "A");
        });
        jb1.setPreferredSize(new Dimension(30,25));
        JButton jb2 = new JButton("OK");
        jb2.addActionListener(e -> sendMsg());
        jb1.setPreferredSize(new Dimension(100,25));
        JButton jbWarning = new JButton("Warning");
        jbWarning.addActionListener(e -> JOptionPane.showMessageDialog(null, "Warning!"));

        jbWarning.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                jbWarning.setBackground(new Color((int)((float)e.getX()/(float)jbWarning.getWidth() * 255f),0,0));
            }
        });

        upperPanel.add(jtf, BorderLayout.WEST);
        upperPanel.add(jb2, BorderLayout.CENTER);
        upperPanel.add(jb1, BorderLayout.EAST);
        add(upperPanel, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);
        add(jbWarning, BorderLayout.SOUTH);

        JList<String> jls = new JList<>(new DefaultListModel<>());
        jls.setPreferredSize(new Dimension(50, 20));
        add(jls, BorderLayout.EAST);
        ((DefaultListModel<String>)jls.getModel()).addElement("A");
        ((DefaultListModel<String>)jls.getModel()).addElement("B");
        ((DefaultListModel<String>)jls.getModel()).addElement("C");

        setVisible(true);
    }

}
