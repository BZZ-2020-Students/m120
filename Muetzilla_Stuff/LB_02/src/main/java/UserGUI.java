import javax.swing.*;
import java.awt.*;

public class UserGUI extends JFrame {
    private DefaultComboBoxModel<String> model;
    private JComboBox destination;
    public UserGUI(DefaultComboBoxModel<String> m){
        super("Fluginformationen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = m;
        init();
        pack();
        setVisible(true);
    }

    private void init() {
        setLayout(new BorderLayout());
        JLabel destinationLabel = new JLabel("Ihr Reiseziel");
        destination = new JComboBox(model);
        destination.setSelectedItem(model.getElementAt(0));
        add(destinationLabel, BorderLayout.WEST);
        add(destination, BorderLayout.EAST);
    }
}
