package musterloesungBF1; /**********************************************************
 *
 * @author  H. Diethelm, HTA Luzern
 * @version 1.0  12-06-2000
 * @version 2.0  19-09-2007, Anapssung an Swing
 *
 **********************************************************/
import java.awt.*;
import javax.swing.*;

class RadioGUI extends JFrame {
    // Label und Buttons erzeugen
    JLabel text  = new JLabel("Band:");
    JButton fm   = new JButton("FM");
    JButton mw   = new JButton("MW");
    JButton lw   = new JButton("LW");
    JButton scan = new JButton("Scan");

    // Panel f�r Bandbuttons erzeugen
    JPanel buttonPanel = new JPanel();

    RadioGUI() {
        // Radio Frame initialisieren
        setTitle("Radio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 120);

        // Layouts setzen
        setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(1, 3));

        // GUI zusammensetzen
        buttonPanel.add(fm);
        buttonPanel.add(mw);
        buttonPanel.add(lw);

        getContentPane().add(text, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(scan, BorderLayout.SOUTH);

        // Frame sichtbar machen
        setVisible(true);
    }
}