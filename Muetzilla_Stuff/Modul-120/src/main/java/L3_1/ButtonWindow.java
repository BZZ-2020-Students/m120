package L3_1;

import javax.swing.*;
import java.awt.*;

public class ButtonWindow extends JFrame {

    public ButtonWindow(){
        super("Button Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Speichern");
        JPanel panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.EAST);
        add(panel, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }
    public static void main(String[] args) {
        new ButtonWindow();
    }
}
