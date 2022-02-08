package l2_1;

import javax.swing.*;
import java.awt.*;

public class LayoutTest extends JFrame {
    private static final String[] LOCATIONS  = {"North", "South", "East", "West", "Center"};

    public LayoutTest() {
        super("LayoutTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(3, 2));
        JButton[] buttons = new JButton[2];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Button" + i);
            add(buttons[i], loc());
        }

        JTextField textField = new JTextField("TextField");
        add(textField, loc());

        JLabel label = new JLabel("Label");
        add(label, loc());

        JTextArea textArea = new JTextArea("TextArea");
        add(textArea, loc());

        pack();

        setVisible(true);
    }

    private String loc() {
        return LOCATIONS[getContentPane().getComponentCount()];
    }



    public static void main(String[] args) {
        new LayoutTest();
    }
}
