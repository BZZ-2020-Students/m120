package lb2_m120.a3;

import javax.swing.*;
import java.awt.*;

public class UserGUI extends JFrame {
    private DefaultComboBoxModel<String> model;
    private JComboBox<String> destination;


    public UserGUI(DefaultComboBoxModel<String> m) {

        this.model = m;
        init();
    }

    public void init() {
        this.setTitle("Fluginformationen");
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Ihr Reiseziel:");

        destination = new JComboBox(model);


        this.add(label, BorderLayout.WEST);
        this.add(destination, BorderLayout.EAST);

        this.setVisible(true);
    }
}
