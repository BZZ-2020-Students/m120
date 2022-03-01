package aLdreieins;

import javax.swing.*;
import java.awt.*;

public class DemoBtnGUI extends JFrame {

    JButton speichern = new JButton("Speichern");

    JPanel jp = new JPanel();

    public DemoBtnGUI(){
        setTitle("Demo");
        setBackground(Color.lightGray);

        getContentPane().setLayout(new BorderLayout());

        jp.setLayout(new BorderLayout());
        jp.add(speichern, BorderLayout.SOUTH);

        getContentPane().add(jp, BorderLayout.EAST);

        setVisible(true);
    }

    public static void main(String[] args) {
        DemoBtnGUI gui = new DemoBtnGUI();
        gui.pack();

    }
}
