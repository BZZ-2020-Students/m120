package selbsttestB.aufgabe1;

import javax.swing.*;
import java.awt.*;

public class RadioGUI extends JFrame {

    JLabel band = new JLabel("Band: ");

    JButton fm = new JButton("FM");
    JButton mw = new JButton("MW");
    JButton lw = new JButton("LW");

    JButton scan = new JButton("Scan");

    JPanel bandPanel = new JPanel();
    JPanel scanPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    public RadioGUI(){
        setTitle("Radio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPanel.setLayout(new GridLayout());
        bandPanel.setLayout(new GridLayout());
        scanPanel.setLayout(new GridLayout());

        bandPanel.add(band);

        buttonPanel.add(fm);
        buttonPanel.add(mw);
        buttonPanel.add(lw);

        scanPanel.add(scan);

        setLayout(new GridLayout(3,1));

        getContentPane().add(bandPanel);
        getContentPane().add(buttonPanel);
        getContentPane().add(scanPanel);

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        RadioGUI rg = new RadioGUI();
        rg.setSize(300, 120);
    }

}
