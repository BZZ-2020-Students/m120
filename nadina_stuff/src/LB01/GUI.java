package LB01;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI(){
        setTitle("LB01");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);

        // Layout
        setLayout(new BorderLayout());

        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        GUI lb01gui = new GUI();
    }
}
