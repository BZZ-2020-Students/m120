import javax.swing.*;
import java.awt.*;

public class InputGUI extends JFrame {
    private final DefaultComboBoxModel<String> model;
    private JTextField destinationInput;
    // button
    private JButton addButton;

    public InputGUI(DefaultComboBoxModel<String> model) {
        this.model = model;
        init();
        addAction();
    }

    private void addAction() {
        addButton.addActionListener(e -> {
            onClick();
        });
    }

    private void onClick() {
        String destination = destinationInput.getText();
        if (destination.length() > 0) {
            model.addElement(destination);
            destinationInput.setText("");
            System.out.println(model);
        }
    }

    private void init() {
        // label and textfield
        JLabel label = new JLabel("neue Destination:");
        destinationInput = new JTextField(20);
        destinationInput.requestFocus();

        addButton = new JButton("zufügen");

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        JPanel textLabelPanel = new JPanel();
        textLabelPanel.setLayout(new BoxLayout(textLabelPanel, BoxLayout.X_AXIS));
        textLabelPanel.add(label);
        textLabelPanel.add(destinationInput);
        rootPanel.add(textLabelPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(addButton, BorderLayout.EAST);
        rootPanel.add(buttonPanel);


        add(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
