package SelbsttestB;

import javax.swing.*;
import java.awt.*;

public class RadioGUI extends JFrame {

    JTextArea ta = new JTextArea("Band: ");

    JButton btn1 = new JButton("FM");
    JButton btn2 = new JButton("MV");
    JButton btn3 = new JButton("LW");

    JButton btn4 = new JButton("Scan");


    JPanel threebtn = new JPanel();

    RadioGUI(){
        setTitle("Radio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,120);

        //Layout
        setLayout(new BorderLayout());
        getContentPane().add(ta, BorderLayout.NORTH);
        getContentPane().add(btn4, BorderLayout.SOUTH);
        getContentPane().add(threebtn, BorderLayout.CENTER);

        // JPanel
        threebtn.setLayout(new GridLayout(1,3));

        threebtn.add(btn1);
        threebtn.add(btn2);
        threebtn.add(btn3);

        setResizable(false);

    setVisible(true);

    }
    public static void main(String[] args) {
        RadioGUI rg = new RadioGUI();

    }
}
