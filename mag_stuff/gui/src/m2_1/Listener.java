package m2_1;

import javax.swing.*;
import java.awt.*;

public class Listener extends JFrame {
    JPanel oben = new JPanel(new BorderLayout());
    JPanel unten = new JPanel(new BorderLayout());

    JLabel label = new JLabel();
    JTextField text = new JTextField();
    JTextArea area = new JTextArea();
    JList<String> list = new JList();
    JButton button = new JButton("toggle color");
    JButton button1 = new JButton("-");

    public Listener(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Listener");
        setLayout(new BorderLayout());
        setSize(500,500);

        String[] liste = {"hello","hallo"};
        list.setListData(liste);

        oben.add(label, BorderLayout.WEST);
        oben.add(text, BorderLayout.EAST);
        add(oben, BorderLayout.NORTH);
        add(area, BorderLayout.CENTER);
        add(list, BorderLayout.EAST);
        unten.add(button, BorderLayout.WEST);
        unten.add(button1, BorderLayout.EAST);
        add(unten, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Listener();
    }
}
