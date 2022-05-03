package _lbo2;

import javax.swing.*;
import java.awt.*;

public class InputGUI extends JFrame {
    private DefaultComboBoxModel<String> model;
    private JTextField destinationInput = new JTextField("", 20);
    private JButton addButton = new JButton("zufügen");
    private JLabel label = new JLabel("neue Destination:");
    private JPanel panel = new JPanel(new BorderLayout());


    public InputGUI(DefaultComboBoxModel<String> m) {
        super("Administration - FlyTop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = m;

        init();
        addAction();

        pack();
        setVisible(true);
    }

    private void init() {
        setLayout(new BorderLayout());
        add(label, BorderLayout.WEST);
        destinationInput.requestFocus();
        add(destinationInput, BorderLayout.EAST);
        panel.add(addButton, BorderLayout.EAST);
        add(panel, BorderLayout.SOUTH);
    }

    private void addAction() {
        addButton.addActionListener(e -> {
            onClick();
        });
    }

    private void onClick() {
        model.addElement(destinationInput.getText());
        System.out.println(model);
        destinationInput.setText("");
        destinationInput.requestFocus();
    }
}
