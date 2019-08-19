import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReportMaker {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("Report Maker");
        jf.setBounds(800, 400, 400, 400);
        JButton jButton = new JButton("Save Report");
        jButton.addActionListener(e -> {
            try {
                makeReportPDF("Report 1", "Z:\\1.pdf");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка при сохранении отчета!");
                ex.printStackTrace();
            }
        });
        jf.add(jButton, BorderLayout.SOUTH);
        jf.setVisible(true);
    }

    private static void makeReportPDF(String str, String path) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(path);
        System.out.println(str);
        pw.close();
    }
}
