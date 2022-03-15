package l3_1;

import javax.swing.*;
import java.awt.*;

public class ButtonWindow extends JFrame {
    private JButton button = new JButton("Speichern");
    private JPanel panel = new JPanel(new BorderLayout());
    public ButtonWindow(){
        setTitle("Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);

        panel.add(button, BorderLayout.EAST);
        getContentPane().add(panel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonWindow();
    }
}
