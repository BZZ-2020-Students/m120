package L1_1;

import aufgabe5.JavaPhoneGUI;

import javax.swing.*;
import java.awt.*;

public class JavaGUI extends JFrame{

    private JButton aButton;

    public JavaGUI(){
        super("Java GUI L1-1");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aButton = new JButton("Button");
        getContentPane().add(aButton, BorderLayout.CENTER);
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        new JavaGUI();
    }
}
