package L1_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaGUI extends JFrame {

    JButton aButton = new JButton("Close");

    public JavaGUI(){
        setTitle("Close on button");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        new JavaGUI();
    }

}
