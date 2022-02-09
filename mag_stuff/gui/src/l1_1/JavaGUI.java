package l1_1;

import aug_5.JavaPhoneGUI;

import javax.swing.*;
import java.awt.*;

public class JavaGUI extends JFrame {
    JButton aButton = new JButton("Button");
    public JavaGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(aButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        JavaGUI gui = new JavaGUI();
        gui.setSize(300, 300);
    }
}
