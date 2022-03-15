package lu1;

import javax.swing.*;
import java.awt.*;

public class Gui1 extends JFrame {
    public Gui1() {
        initComponents();

        setTitle("Test z......");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void initComponents() {
        var input = new JTextField();
        var enter = new JButton("Enter");
        enter.addActionListener(e -> {
                    System.out.println(input.getText());
                    enter.setEnabled(false);
                }
        );


        var abort = new JButton("Abort");
        abort.addActionListener(e -> {
            enter.setEnabled(true);
            input.setText("");
        });

        setLayout(new BorderLayout());

        var buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(enter);
        buttonPanel.add(abort);

        add(input, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        var gui = new Gui1();
    }
}
