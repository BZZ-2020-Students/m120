package l1_1;

import javax.swing.*;

public class JavaGUI extends JFrame {
    public JavaGUI() {
        super("JavaGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JButton("Button"));
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new JavaGUI();
    }
}
