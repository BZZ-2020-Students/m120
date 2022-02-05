package selbsttestA.aufgabe1;

import javax.swing.*;
import java.awt.*;

public class ZeroGUI extends JFrame {

    JLabel warning = new JLabel("Dieses Program macht nichts!");
    JLabel copyright = new JLabel("Copyright(c) 1999");
    JLabel zerosoft = new JLabel("Zerosoft AG");

    JButton cancel = new JButton("Abbruch");
    JButton ok = new JButton("OK");
    JButton help = new JButton("Hilfe");

    JPanel display = new JPanel();
    JPanel buttonPanel = new JPanel();
    ZeroGUI(){
        setTitle("Zero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        display.setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout());

        display.add(warning, BorderLayout.NORTH);
        display.add(copyright,  BorderLayout.CENTER);
        display.add(zerosoft,  BorderLayout.SOUTH);

        buttonPanel.add(cancel);
        buttonPanel.add(ok);
        buttonPanel.add(help);

        getContentPane().add(display, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);

    }


    public static void main(String[] args) {
        ZeroGUI g = new ZeroGUI();
        g.setSize(300, 100);
    }
}
