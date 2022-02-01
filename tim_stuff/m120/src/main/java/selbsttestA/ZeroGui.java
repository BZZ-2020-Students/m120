package selbsttestA;

import javax.swing.*;
import java.awt.*;

public class ZeroGui extends JFrame {
    public ZeroGui() {
        // initialize window with 300*100 pixel size and a not edible text area in the upper half and 3 buttons in the lower half
        setSize(300, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("""
                Dieses Programm macht nichts!
                Copyright (c) 1999
                Zerosoft AG""");
        add(textArea, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        add(buttonPanel, BorderLayout.SOUTH);
        JButton button1 = new JButton("Abbruch");
        buttonPanel.add(button1);
        JButton button2 = new JButton("OK");
        buttonPanel.add(button2);
        JButton button3 = new JButton("Hilfe");
        buttonPanel.add(button3);
    }

    public static void main(String[] args) {
        ZeroGui gui = new ZeroGui();
        gui.setVisible(true);
    }
}
