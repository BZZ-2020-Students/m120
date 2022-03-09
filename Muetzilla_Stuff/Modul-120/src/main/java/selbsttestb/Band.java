package selbsttestb;

import L1_1.JavaGUI;

import javax.swing.*;
import java.awt.*;

public class Band extends JFrame {
    private JButton fm;
    private JButton mw;
    private JButton lw;
    private JButton scan;
    private JLabel bandLabel;
    public Band(){
        super("Radio");
        setSize(300, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fm = new JButton("FM");
        mw= new JButton("MW");
        lw = new JButton("LW");
        JPanel horizontalPanel = new JPanel();
        horizontalPanel.setLayout(new FlowLayout());
        horizontalPanel.add(fm);
        horizontalPanel.add(mw);
        horizontalPanel.add(lw);
        bandLabel = new JLabel("Band:");
        scan = new JButton("Scan");
        setLayout(new GridLayout(0,1));
        add(bandLabel);
        add(horizontalPanel);
        add(scan);
        pack();
        setVisible(true);
    }
    public static void main(String[] args){
        new Band();
    }
}