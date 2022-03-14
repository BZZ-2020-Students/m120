package selbsttest_A; /**********************************************************
 *
 * @author H. Diethelm, HTA Luzern
 * @version 1.0  12-06-2000
 * @version 2.0  19-09-2007, Anapssung an Swing
 *
 **********************************************************/

import javax.swing.*;
import java.awt.*;

class ZeroGUI extends JFrame {

    // GUI Elemente erzeugen
    JButton ok = new JButton("Ok");
    JButton abbruch = new JButton("Abbruch");
    JButton hilfe = new JButton("Hilfe");
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JLabel firstLine = new JLabel("Dieses Programm macht nichts!");
    JLabel secondLine = new JLabel("Copyright (c) 1999");
    JLabel thirdLine = new JLabel("Zerosoft AG");


    ZeroGUI() {
        // Frame initialisieren
        setTitle("Zero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layouts setzen
        setLayout(new GridLayout(0,1));

        northPanel.setLayout(new GridLayout(0, 1));
        southPanel.setLayout(new GridLayout(0,3));

        // GUI zusammensetzen
        northPanel.add(firstLine);
        northPanel.add(secondLine);
        northPanel.add(thirdLine);
        southPanel.add(abbruch);
        southPanel.add(ok);
        southPanel.add(hilfe);

        add(northPanel);
        add(southPanel);

        // Frame sichtbar machen
        setVisible(true);
    }

    public static void main(String[] args) {
        ZeroGUI zg = new ZeroGUI();
        zg.setSize(300, 100);
    }

    // Listener-Klasse f�r ActionEvent des Ok Buttons realisieren
    //...
}