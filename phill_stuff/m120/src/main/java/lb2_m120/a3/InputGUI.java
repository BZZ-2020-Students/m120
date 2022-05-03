package lb2_m120.a3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputGUI extends JFrame {
    private DefaultComboBoxModel<String> model;
    private JTextField destinationInput;
    private JButton addButton;

    public InputGUI(DefaultComboBoxModel<String> m) {
        this.model = m;
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administration - FlyTop");
        setResizable(false);
        setSize(300, 100);

        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 2));

        JLabel destinationLabel = new JLabel("neue Destination:");
        topPanel.add(destinationLabel);

        destinationInput = new JTextField();
        topPanel.add(destinationInput);

        this.add(topPanel, BorderLayout.NORTH);

        addButton = new JButton("Add");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addElement(destinationInput.getText());
                destinationInput.setText("");
                System.out.println(model.toString());
            }
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(addButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
        destinationInput.requestFocus();
        setVisible(true);
    }

}
