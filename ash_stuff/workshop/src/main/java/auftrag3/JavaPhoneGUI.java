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
* @author  H. Diethelm, HTA Luzern
* @version 1.0  12-06-2000
* @version 2.0  01-02-2007 (R. Probst) change to swing
* @version 2.1  17-02-2016 (R. Probst) kleinere Anpassungen
* 
**********************************************************/
public class JavaPhoneGUI extends JFrame {
  
  // Hier die Schaltf�chen (Buttons) deklarieren und gleich auch erzeugen.
  // Sie sehen das Beispiel f�r die Taste [0]. Erg�nzen Sie nun die 
  // restlichen Tasten 1...9 sowie + und #.
  // Vergessen Sie nicht die Schaltfl�che f�r den Telefonh�rer (hook)
  JButton key1 = new JButton("1");
  JButton key2 = new JButton("2");
  JButton key3 = new JButton("3");
  JButton key4 = new JButton("4");
  JButton key5 = new JButton("5");
  JButton key6 = new JButton("6");
  JButton key7 = new JButton("7");
  JButton key8 = new JButton("8");
  JButton key9 = new JButton("9");

  JButton keySharp = new JButton("#");
  JButton key0 = new JButton("0");
  JButton keyStar = new JButton("*");

  JButton hook = new JButton("Hook off");
  // ...
  
  //
  // Deklarieren Sie hier die weiteren Elemente gem�ss den Ausf�hrungen
  // in Quelle 2
  JTextField display = new JTextField();
  JLabel state = new JLabel("ready");
  // ...
    
  // Deklarieren Sie hier alle ben�tigten Panels, so wie in Auftrag 1
  // eingef�hrt.
  JPanel keyPanel        = new JPanel();
  JPanel keyDisplayPanel = new JPanel();
  JPanel stateHookPanel = new JPanel();
  // ...
    
  // Der Konstruktor f�gt alle Elemente zum GUI zusammen
  JavaPhoneGUI() {
    // Das Fenster (JFrame) initialisieren. Es werden diverse Eigenschaften
    // festgelegt. Mehr dazu finden Sie in der API der Klasse JFrame.
    setTitle("JavaPhone");
    setBackground(Color.lightGray);
    setResizable(false);
    // Hier die Komponenten wenn n�tig noch parametrieren.
    // Infos dazu finden Sie i nder API der jeweiligen Klasse
    display.setEditable(false);
    
    // Die Layout-Manager f�r das JFrame und die JPanel festlegen.
    // N�here Angaben dazu finden wich in Quelle 2
    getContentPane().setLayout(new BorderLayout(20, 20));
    keyPanel.setLayout(new GridLayout(4, 3, 20, 20));
    keyDisplayPanel.setLayout(new BorderLayout());
    stateHookPanel.setLayout(new BorderLayout());
    // ...
    
    
    // Aufbau des keyPanel mit allen Tasten des Telefons
    // Wenn SIe unsicher sind, was auf das keyPanel geh�rt, schauen Sie
    // sich nochmals das Ergebnis von Auftrag 1 an.
    keyPanel.add(key1);
    keyPanel.add(key2);
    keyPanel.add(key3);
    keyPanel.add(key4);
    keyPanel.add(key5);
    keyPanel.add(key6);
    keyPanel.add(key7);
    keyPanel.add(key8);
    keyPanel.add(key9);
    keyPanel.add(keySharp);
    keyPanel.add(key0);
    keyPanel.add(keyStar);
    // ...
    // Und nun das displayPanel noch best�cken
    //...
    
    // Die beiden Panels korrekt positioniert auf ein weiteres Panel
    // keyDisplayPanel legen.
    keyDisplayPanel.add(display, BorderLayout.NORTH);
    keyDisplayPanel.add(keyPanel, BorderLayout.CENTER);
    
    // Verfahren Sie nun gleich wie oben gezeigt f�r den hook-Button und 
    // das ready-Label.
    // Studieren sie wenn n�tig nochmals Quelle 2.
    // ...
    stateHookPanel.add(state, BorderLayout.NORTH);
    stateHookPanel.add(hook, BorderLayout.CENTER);
    // Fast fertig. Nun muss noch alles an der richtigen Position aufs
    // Fenster gelegt werden.
    getContentPane().add(stateHookPanel, BorderLayout.WEST);
    getContentPane().add(keyDisplayPanel, BorderLayout.CENTER);
    //...
    
    // Und nun darf das Fenster angezeigt werden.
    setVisible(true); 
  }
}