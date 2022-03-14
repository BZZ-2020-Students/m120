package selbstestA.src;

import javax.swing.*;
import java.awt.*;

public class ZeroGUI extends JFrame {
    private JTextArea text = new JTextArea("Dieses Programm macht nichts!");
    private JButton abbr = new JButton("Abbruch");
    private JButton ok = new JButton("OK");
    private JButton help = new JButton("Hilfe");
    private JPanel panel = new JPanel();

    public ZeroGUI(){
        super("Zero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(text, BorderLayout.NORTH);
        text.setBackground(Color.lightGray);
        panel.add(abbr);
        panel.add(ok);
        panel.add(help);
        getContentPane().add(panel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new ZeroGUI();
    }
}
