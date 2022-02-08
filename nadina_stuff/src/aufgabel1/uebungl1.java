package aufgabel1;

import javax.swing.*;
import java.awt.*;

public class uebungl1 extends JFrame {
    private JButton aButton;

    public uebungl1(){
        super("Übung L1-1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aButton = new JButton("Button1");
        getContentPane().add(aButton, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new uebungl1();
    }
}
