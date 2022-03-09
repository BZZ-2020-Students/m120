package selbsttestb;

import javax.swing.*;
import java.awt.*;

public class RadioGUI extends JFrame {
    JLabel bandlabel = new JLabel("Band:");
    JButton fm   = new JButton("FM");
    JButton mw   = new JButton("MW");
    JButton lw   = new JButton("LW");
    JButton scan  = new JButton("Scan");


    RadioGUI() {
        // Frame initialisieren
        setTitle("Radio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 120);
        setResizable(false);

        // Layouts setzen
        setLayout(new BorderLayout());



        // GUI zusammensetzen
        getContentPane().add(bandlabel, BorderLayout.NORTH);
        getContentPane().add(fm, BorderLayout.WEST);
        getContentPane().add(mw, BorderLayout.CENTER);
        getContentPane().add(lw, BorderLayout.EAST);
        getContentPane().add(scan, BorderLayout.SOUTH);

        // Listeners registrieren
        // ...

        // Frame sichtbar machen
        setVisible(true);
    }
}
