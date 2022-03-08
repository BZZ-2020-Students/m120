package Maufgabe2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import static java.awt.Color.cyan;

public class SematischGUI extends JFrame {

    JButton jb1 = new JButton("toggle color");
    JButton jb2 = new JButton("JButton");

    JLabel jl = new JLabel("JLabel");

    JTextField tf1 = new JTextField("", 20);

    TextArea jta = new TextArea();

    JList jli = new JList<>();

    JPanel southp = new JPanel();
    JPanel northp = new JPanel();


    public SematischGUI(){
        setTitle("M2-1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,250);

        // Layout
        setLayout(new BorderLayout());


        // Panel
        southp.setLayout(new BorderLayout());
        southp.add(jb1, BorderLayout.WEST);
        southp.add(jb2, BorderLayout.EAST);

        northp.setLayout(new BorderLayout());
        northp.add(jl, BorderLayout.WEST);
        northp.add(tf1, BorderLayout.EAST);

        // ActionListener
        // BTN Color change
        jb1.setBackground(cyan);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(jb1.getBackground().equals(cyan)){
                     jb1.setBackground(Color.green);
                 }else{
                     jb1.setBackground(Color.cyan);
                 }
            }
        });

        // JTextField FocusListener

        // JListSelectionListener

        getContentPane().add(southp, BorderLayout.SOUTH);
        getContentPane().add(northp, BorderLayout.NORTH);

        getContentPane().add(jta, BorderLayout.CENTER);
        getContentPane().add(jli, BorderLayout.EAST);

        setVisible(true);
    }

    public static void main(String[] args) {
        SematischGUI sgui = new SematischGUI();
    }
}
