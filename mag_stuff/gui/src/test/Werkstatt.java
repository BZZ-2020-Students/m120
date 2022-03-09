package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Werkstatt extends JFrame {
    JRadioButton upload = new JRadioButton("upload", true);
    JLabel verzeichnis = new JLabel("Verzeichnis:");
    JTextField text = new JTextField("",30);
    JButton go = new JButton("GO");


    public Werkstatt() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);
        setResizable(false);
        setLayout(new BorderLayout());
        setTitle("Test zu GUI-Werkstatts");

        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!upload.isSelected()){
                    text.setVisible(false);
                }else {
                    text.setVisible(true);
                }
            }
        });

        add(upload, BorderLayout.NORTH);
        add(verzeichnis, BorderLayout.WEST);
        add(text, BorderLayout.EAST);

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(text.getText());
                text.setText("");
            }
        });
        add(go, BorderLayout.SOUTH);

        setVisible(true);

    }


    public static void main(String[] args) {
        new Werkstatt();
    }
}
