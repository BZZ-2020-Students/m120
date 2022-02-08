package L1_1;

import javax.swing.*;
import java.awt.*;
public class JavaGUI extends JFrame{
    private JButton aButton;
    public JavaGUI(){
        super("JavaGUI Exit on close");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aButton = new JButton("Press Me!");
        getContentPane().add(aButton, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
    public static void main(String[] args){
        new JavaGUI();
    }
}