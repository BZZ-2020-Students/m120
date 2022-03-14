package l2_1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LayoutTest<T> extends JFrame {
    JButton b1 = new JButton("Press");
    JButton b2 = new JButton("Push");
    JTextField jtf = new JTextField("Enter");
    JTextArea jta = new JTextArea();
    JLabel l = new JLabel("This Labe is...");

    public LayoutTest(T layout){
        jta.setText("Dies ist ein mehrzeiliger Text.\nDer nur für den Test geeignet ist.\n Falls dies nicht ernst genommen wird kann nichts gegen sie verwendet werden.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout((LayoutManager) layout);

        add(b1, BorderLayout.EAST);
        add(b2, BorderLayout.WEST);
        add(jtf, BorderLayout.NORTH);
        add(jta, BorderLayout.CENTER);
        add(l, BorderLayout.SOUTH);



        setVisible(true);
    }

    public static void main(String[] args) {
        LayoutTest t = new LayoutTest(new FlowLayout());
        t.setSize(300,300);
        LayoutTest t1 = new LayoutTest(new GridLayout());
        t1.setSize(300,300);
        LayoutTest t2 = new LayoutTest(new BorderLayout());
        t2.setSize(300,300);
    }
}
