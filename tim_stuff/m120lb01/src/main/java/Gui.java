import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    public Gui() {
        setTitle("Test z..."); // ich gsehn de rest vom titel nöd
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);

        JTextField textField = new JTextField();
        textField.setText("Text der ausgegeben wird");
        add(textField, BorderLayout.CENTER);

        JButton button1 = new JButton("Enter");
        button1.addActionListener(e -> {
            System.out.println(textField.getText());
            button1.setEnabled(false);
        });

        JButton button2 = new JButton("Abort");
        button2.addActionListener(e -> {
            textField.setText("");
            button1.setEnabled(true);
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(button1);
        panel.add(button2);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Gui();
    }
}
