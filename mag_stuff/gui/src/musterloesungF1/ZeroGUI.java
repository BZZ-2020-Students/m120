package musterloesungF1; /**********************************************************
 *
 * @author  H. Diethelm, HTA Luzern
 * @version 1.0  12-06-2000
 * @version 2.0  19-09-2007, Anapssung an Swing
 *
 **********************************************************/
import javax.swing.*;
import java.awt.*;

class ZeroGUI extends JFrame {
    // Label und Buttons erzeugen
    JLabel text1 = new JLabel("Dieses Programm macht nichts!");
    JLabel text2 = new JLabel("Copyright (c) 1999");
    JLabel text3 = new JLabel("Zerosoft AG");
    JButton ok      = new JButton("OK");
    JButton abbruch = new JButton("Abbruch");
    JButton hilfe  = new JButton("Hilfe");
    
    // Panel für Buttons und Text erzeugen
    JPanel buttonPanel = new JPanel();
    JPanel textPanel   = new JPanel();
    
    ZeroGUI() {
        // Frame initialisieren
        setTitle("Zero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setResizable(false);
        
        // Layouts setzen
        buttonPanel.setLayout(new GridLayout(1, 3));
        textPanel.setLayout(new GridLayout(3, 1));
        
        // GUI zusammensetzen
        buttonPanel.add(abbruch);
        buttonPanel.add(ok);
        buttonPanel.add(hilfe);
        
        textPanel.add(text1);
        textPanel.add(text2);
        textPanel.add(text3);
        
        getContentPane().add(textPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        // Frame sichtbar machen
        setVisible(true);
    }
}