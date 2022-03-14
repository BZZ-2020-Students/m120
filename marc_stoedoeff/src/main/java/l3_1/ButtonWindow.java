package l3_1;

import javax.swing.*;
import java.awt.*;

public class ButtonWindow extends JFrame {

    public ButtonWindow() {
        super("Button Window");
        JButton button = new JButton("Speichern");

        setLayout(new BorderLayout());

        var southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());

        southPanel.add(button, BorderLayout.EAST);

        add(southPanel, BorderLayout.SOUTH);
    }


    public static void main(String[] args) {
        var window = new ButtonWindow();
        window.setSize(300, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
