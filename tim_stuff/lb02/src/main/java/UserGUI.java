import javax.swing.*;
import java.awt.*;

public class UserGUI extends JFrame {
    private final DefaultComboBoxModel<String> model;
    private JComboBox<String> destination;

    public UserGUI(DefaultComboBoxModel<String> model) throws HeadlessException {
        this.model = model;
        init();
    }

    private void init() {
        // label on the left, combo box on the right
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JLabel("Ihr Reiseziel:"));
        destination = new JComboBox<>(model);
        panel.add(destination);
        add(panel);
        setTitle("Fluginformationen ...");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 75);
        setVisible(true);
    }
}
