package ueben;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JButton button;
    private JTextField textField;
    private JLabel label;

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);
    }


    public GUI() {
        setTitle("Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocation(300, 300);

        button = new JButton("Click me");
        textField = new JTextField("Enter text here");
        label = new JLabel("Hello World");

        add(button);
        add(textField);
        add(label);

        button.addActionListener(new ButtonListener());
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            label.setText(textField.getText());
        }
    }


}
