package selbsttest1;
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

class TitleGUI extends JFrame {
  
  // GUI Elemente erzeugen
  JButton ok       = new JButton("Ok");
  JTextField input = new JTextField();
    
    
  TitleGUI() {
    // Frame initialisieren
    setTitle("JavaPhone");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(250, 100);
    setResizable(false);
    
    // Layouts setzen
    setLayout(new BorderLayout(20, 20));
    ok.addActionListener(e -> {
      input.setText("ahhhhhh");
    });
    // GUI zusammensetzen
    getContentPane().add(input, BorderLayout.NORTH);
    getContentPane().add(ok, BorderLayout.CENTER);
    
    // Listener registrieren
    //...
    
    // Frame sichtbar machen
    setVisible(true);
  }
    
  // Listener-Klasse für ActionEvent des Ok Buttons realisieren
  //...

}