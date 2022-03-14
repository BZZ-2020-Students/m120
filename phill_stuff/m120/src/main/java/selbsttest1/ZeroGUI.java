package selbsttest1;

import javax.swing.*;
import java.awt.*;

public class ZeroGUI extends JFrame {

    private JTextArea area;
    private JButton abb;
    private JButton ok;
    private JButton help;
    private JPanel panel;

    public ZeroGUI(){
        super("Zero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);
        area = new JTextArea("Dieses Programm macht nichts!");
        abb = new JButton("Abbruch");
        ok = new JButton("OK");
        help = new JButton("Hilfe");
        panel = new JPanel();
        getContentPane().add(area,BorderLayout.NORTH);
        panel.add(abb);
        panel.add(ok);
        panel.add(help);
        getContentPane().add(panel,BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new ZeroGUI();
    }
}
