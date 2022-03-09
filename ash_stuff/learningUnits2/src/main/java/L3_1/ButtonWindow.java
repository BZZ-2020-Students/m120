package L3_1;

import javax.swing.*;
import java.awt.*;

public class ButtonWindow extends JFrame {
    JButton save = new JButton("Speichern");

    JPanel buttonPanel = new JPanel(new BorderLayout());
    public ButtonWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buttonPanel.add(save, BorderLayout.EAST);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        new ButtonWindow();
    }
}
