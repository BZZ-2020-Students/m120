package auftrag3;

import java.awt.*;
import javax.swing.*;

/**********************************************************
*
*  This class implements a simple phone GUI.
*  When creating a new object of this class
*  the GUI components, such as buttons, labels, etc. are
*  just displayed. They do not yet react on user actions,
*  such as pressing a button, etc.
*
* @author  Nadina Amlser (Shirin197)
**********************************************************/
public class JavaPhoneGUI extends JFrame {
  
  // Hier die Schaltfächen (Buttons) deklarieren und gleich auch erzeugen.
  // restlichen Tasten 1...9 sowie + und #.
  JButton key1 = new JButton("1");
  JButton key2 = new JButton("2");
  JButton key3 = new JButton("3");
  JButton key4 = new JButton("4");
  JButton key5 = new JButton("5");
  JButton key6 = new JButton("6");
  JButton key7 = new JButton("7");
  JButton key8 = new JButton("8");
  JButton key9 = new JButton("9");
  JButton key0 = new JButton("0");
  JButton keyhash = new JButton("#");
  JButton keystar = new JButton("*");

  // Schaltfläche für den Telefonhörer (hook)
  JButton hook = new JButton("hook");

  // Deklaration der weiteren Elemente
  JTextField display = new JTextField();
  JLabel state = new JLabel("ready");
    
  // Deklaration aller benötigten Panels (Quelle 1)
  JPanel keyPanel        = new JPanel();
  JPanel keyDisplayPanel = new JPanel();
  JPanel keyhookStatePanel = new JPanel();

    
  // Der Konstruktor fügt alle Elemente zum GUI zusammen
  JavaPhoneGUI() {
    setTitle("JavaPhone"); // Titel
    setBackground(Color.lightGray);
    setResizable(false);

    display.setEditable(false);
    
    // Die Layout-Manager für das JFrame und die JPanel festlegen.
    getContentPane().setLayout(new BorderLayout(20,20));
    keyPanel.setLayout(new GridLayout(4, 3, 20, 20));

    // Aufbau des keyPanel mit allen Tasten des Telefons
    keyPanel.add(key1);
    keyPanel.add(key2);
    keyPanel.add(key3);
    keyPanel.add(key4);
    keyPanel.add(key5);
    keyPanel.add(key6);
    keyPanel.add(key7);
    keyPanel.add(key8);
    keyPanel.add(key9);
    keyPanel.add(keyhash);
    keyPanel.add(key0);
    keyPanel.add(keystar);


    // Die beiden Panels korrekt positioniert auf ein weiteres Panel keyDisplayPanel legen.
    keyDisplayPanel.setLayout(new BorderLayout());
    keyDisplayPanel.add(display, BorderLayout.NORTH);
    keyDisplayPanel.add(keyPanel, BorderLayout.CENTER);

    // Verfahren Sie nun gleich wie oben gezeigt für den hook-Button und das ready-Label.
    keyhookStatePanel.setLayout(new BorderLayout());
    keyhookStatePanel.add(state, BorderLayout.NORTH);
    keyhookStatePanel.add(hook, BorderLayout.SOUTH);


    // Fast fertig. Nun muss noch alles an der richtigen Position aufs
    // Fenster gelegt werden.
    getContentPane().add(keyDisplayPanel, BorderLayout.CENTER);
    getContentPane().add(keyhookStatePanel, BorderLayout.WEST);

    // Und nun darf das Fenster angezeigt werden.
    setVisible(true); 
  }
}