package musterloesungBF3; /**********************************************************
 *
 * @author  H. Diethelm, HTA Luzern
 * @version 1.0  12-06-2000
 * @version 2.0  19-09-2007, Anapssung an Swing
 *
 **********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SchalterGUI extends JFrame {
    // Listener f�r ActionEvent des on Buttons
    class OnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            state.setText("Der Schalter ist ein.");
        }
    }
    
    // Listener f�r ActionEvent des off Buttons
    class OffListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            state.setText("Der Schalter ist aus.");
        }
    }
    
    
    // GUI Elemente erzeugen
    JLabel state = new JLabel("Der Schalter ist aus.");
    JButton on   = new JButton("On");
    JButton off  = new JButton("Off");
    
    
    SchalterGUI() {
        // Frame initialisieren
        setTitle("Schalter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(150, 150);
        setResizable(false);
        
        // Layouts setzen
        setLayout(new BorderLayout());
        
        // Listeners registrieren
        on.addActionListener(new OnListener());
        off.addActionListener(new OffListener());
        
        // GUI zusammensetzen
        getContentPane().add(on, BorderLayout.NORTH);
        getContentPane().add(state, BorderLayout.CENTER);
        getContentPane().add(off, BorderLayout.SOUTH);
        
        // Frame sichtbar machen
        setVisible(true);
    }
}