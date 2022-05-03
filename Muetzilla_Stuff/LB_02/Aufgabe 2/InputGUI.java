import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputGUI extends JFrame {
    private DefaultComboBoxModel<String> model;
    private JTextField destinationInput;
    private JButton addButton;

    public InputGUI(DefaultComboBoxModel<String> m){
        super("Administration - FlyTop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = m;
        init();
        pack();
        setVisible(true);
    }

    private void init() {
        //input area
        JLabel inputLabel = new JLabel("neue Destination: ");
        JPanel inputPanel = new JPanel();
        destinationInput = new JTextField();
        destinationInput.requestFocus();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputLabel, BorderLayout.WEST);
        inputPanel.add(destinationInput, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);

        //button area
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("zufügen");
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(addButton, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        addAction();
    }

    private void addAction(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }
    private void onClick(){
        model.addElement(destinationInput.getText().toString());
        destinationInput.setText("");
        destinationInput.requestFocus();
        System.out.println(model.toString());
    }
}
