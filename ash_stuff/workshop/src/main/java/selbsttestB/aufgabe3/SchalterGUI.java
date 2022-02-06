package selbsttestB.aufgabe3;
/**********************************************************
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
    // ...
    on.addActionListener(new KeyOnListener());
    off.addActionListener(new KeyOffListener());


  // Frame sichtbar machen
    setVisible(true);
  }
    
    
  // Listener-Klasse f�r ActionEvent des on Buttons
  //...
  public class KeyOnListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      state.setText("Der Schalter ist ein.");
    }
  }
    
  // Listener-Klasse f�r ActionEvent des off Buttons
  //...
  public class KeyOffListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      state.setText("Der Schalter ist aus.");
    }
  }
    
}