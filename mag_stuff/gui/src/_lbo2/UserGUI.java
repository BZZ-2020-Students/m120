package _lbo2;

import javax.swing.*;
import java.awt.*;

public class UserGUI extends JFrame {
    private DefaultComboBoxModel<String> model;
    private JComboBox<String> destination;
    private JLabel label = new JLabel("Ihr Reiseziel:");

    public UserGUI(DefaultComboBoxModel<String> m) {
        super("Fluginformationen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 60);
        model = m;

        init();

//        pack();
        setVisible(true);
    }

    private void init() {
        setLayout(new BorderLayout());
        add(label, BorderLayout.WEST);
        destination = new JComboBox<>(model);
        add(destination, BorderLayout.EAST);
    }
}
