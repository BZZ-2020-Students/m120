package selbsttestb; /**********************************************************
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
    
    // GUI zusammensetzen
    getContentPane().add(on, BorderLayout.NORTH);
    getContentPane().add(state, BorderLayout.CENTER);
    getContentPane().add(off, BorderLayout.SOUTH);
    
    // Listeners registrieren
    on.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        state.setText("Der Schalter ist ein");
      }
    });

    off.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        state.setText("Der Schalter ist aus");
      }
    });
    
  // Frame sichtbar machen
    setVisible(true);
  }
    
    
  // Listener-Klasse für ActionEvent des on Buttons
  //...
    
  // Listener-Klasse für ActionEvent des off Buttons
  //...

    
}