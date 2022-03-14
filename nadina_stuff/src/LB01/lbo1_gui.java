package LB01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lbo1_gui extends JFrame {

    JRadioButton jr = new JRadioButton("uplaod", true);

    JLabel jl = new JLabel("Verzeichnis");

    JTextField jtx = new JTextField("", 30);

    JButton jb = new JButton("GO");

    public lbo1_gui() {
        setTitle("Test zu Gui-Werkstatt");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 110);

        // Layout
        setLayout(new BorderLayout());


        getContentPane().add(jr, BorderLayout.NORTH);
        getContentPane().add(jb, BorderLayout.SOUTH);
        getContentPane().add(jl, BorderLayout.WEST);
        getContentPane().add(jtx, BorderLayout.CENTER);


        setResizable(false);
        setVisible(true);

        //ActionListener
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jtx.getText());
                jtx.setText("");
            }
        });

        jr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jr.equals(false)) {
                    jtx.setVisible(false);
                } else {
                    jtx.setVisible(true);
                }

                // richtig: jtx.setVisible(jr.isSelected());
            }
        });
    }

    public static void main(String[] args) {
        lbo1_gui lb01gui = new lbo1_gui();
    }
}
