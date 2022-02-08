package L2_1;

import javax.swing.*;
import java.awt.*;

public class LayoutTest extends JFrame {
    JButton buttonOne = new JButton("Click me");
    JButton buttonTwo = new JButton("No Click me");

    JTextField textField = new JTextField(5);
    JTextArea textArea = new JTextArea(5,50);
    JLabel label = new JLabel("This is text");

    LayoutTest(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonOne, BorderLayout.SOUTH);
        getContentPane().add(buttonTwo, BorderLayout.NORTH);
        getContentPane().add(textField, BorderLayout.WEST);
        getContentPane().add(textArea, BorderLayout.CENTER);
        getContentPane().add(label, BorderLayout.EAST);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutTest();
    }

}
