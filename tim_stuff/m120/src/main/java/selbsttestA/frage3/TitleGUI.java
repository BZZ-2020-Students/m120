package selbsttestA.frage3;

import javax.swing.*;
import java.awt.*;

/**********************************************************
 *
 * @author H. Diethelm, HTA Luzern
 * @version 1.0  12-06-2000
 * @version 2.0  19-09-2007, Anapssung an Swing
 *
 **********************************************************/
class TitleGUI extends JFrame {

    // GUI Elemente erzeugen
    JButton ok = new JButton("Ok");
    JTextField input = new JTextField();


    TitleGUI() {
        // Frame initialisieren
        setTitle("Enter title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 100);
        setResizable(false);

        // Layouts setzen
        setLayout(new BorderLayout(20, 20));

        // GUI zusammensetzen
        getContentPane().add(input, BorderLayout.NORTH);
        getContentPane().add(ok, BorderLayout.CENTER);

        // Listener registrieren
        //...

        // Frame sichtbar machen
        setVisible(true);
    }

    // Listener-Klasse f�r ActionEvent des Ok Buttons realisieren
    //...
}