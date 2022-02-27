package SelbsttestA; /**********************************************************
 *
 * @author  H. Diethelm, HTA Luzern
 * @version 1.0  12-06-2000
 * @version 2.0  19-09-2007, Anapssung an Swing
 *
 **********************************************************/
import java.awt.*;
import javax.swing.*;

class ZeroGUI extends JFrame {

  // GUI Elemente erzeugen
  JButton ok = new JButton("Ok");
  JButton abbruch = new JButton("Abbruch");
  JButton hilfe = new JButton("Hilfe");

  JLabel fl = new JLabel("Dieses Programm macht nichts!");
  JLabel sl = new JLabel("Copyright (c) 1999");
  JLabel tl = new JLabel("Zerosoft AG");

  JPanel upperP = new JPanel();
  JPanel underP = new JPanel();

  ZeroGUI() {
    // Frame initialisieren
    setTitle("Zero");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setResizable(false);

    // Layouts setzen
    setLayout(new GridLayout(0, 1));
    upperP.setLayout(new GridLayout(0,1));
    
    // Anzahl "Objekte"-> sind nebeneinander aufgelistet und gleich gross
    underP.setLayout(new GridLayout(0, 3));

    // GUI zusammensetzen
    // upper Panel
    upperP.add(fl);
    upperP.add(sl);
    upperP.add(tl);
    add(upperP);

    // under Panel
    underP.add(abbruch);
    underP.add(ok);
    underP.add(hilfe);
    add(underP);

    // Frame sichtbar machen
    setVisible(true);
  }
}