package LB01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class textGUI extends JFrame {

    JTextField aTextField;
    JButton enter, abort;
    JPanel buttonPanel = new JPanel(new GridLayout(1,2));

    public textGUI() {
        super("Test z...");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel.add(enter = new JButton("Enter"));
        buttonPanel.add(abort = new JButton("Abort"));

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(aTextField.getText());
                enter.setEnabled(false);
            }
        });

        abort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aTextField.setText("");
                enter.setEnabled(true);
            }
        });

        setLayout(new BorderLayout());
        getContentPane().add(aTextField = new JTextField("Text der ausgegeben wird",20), BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new textGUI();
    }
}
