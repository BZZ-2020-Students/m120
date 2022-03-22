package m1_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenster extends JFrame {
    JTextField text = new JTextField();
    JButton write = new JButton("write");
    JButton reset = new JButton("reset");
    JPanel panel = new JPanel(new GridLayout(1,2));

    public Fenster(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Fenster");
        setResizable(false);
        setSize(300,100);
        setLayout(new BorderLayout());

        add(text, BorderLayout.CENTER);

        write.setBackground(Color.GREEN);
        reset.setForeground(Color.RED);

        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(text.getText());
                write.setEnabled(false);            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                write.setEnabled(true);
            }
        });

        panel.add(write);
        panel.add(reset);

        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Fenster();
    }
}
