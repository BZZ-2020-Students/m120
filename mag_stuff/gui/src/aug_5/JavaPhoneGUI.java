package aug_5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
  JButton key0 = new JButton("0");
  JButton keyA = new JButton("+");
  JButton keyB = new JButton("*");
  JButton hook = new JButton("Hook off");
  // ...
  
  //
  // Deklarieren Sie hier die weiteren Elemente gem�ss den Ausf�hrungen
  // in Quelle 2
  JTextField display = new JTextField();
  // ...
  JLabel     state   = new JLabel("ready");
  // Deklarieren Sie hier alle ben�tigten Panels, so wie in Auftrag 1
  // eingef�hrt.
  JPanel keyPanel        = new JPanel();
  JPanel keyDisplayPanel = new JPanel();
  // ...
  JPanel hookStatePanel  = new JPanel();
    
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
    // ...
    keyDisplayPanel.setLayout(new BorderLayout(20, 20));
    hookStatePanel.setLayout(new BorderLayout(20,20));
    
    // Aufbau des keyPanel mit allen Tasten des Telefons
    // Wenn SIe unsicher sind, was auf das keyPanel geh�rt, schauen Sie
    // sich nochmals das Ergebnis von Auftrag 1 an.
    key1.addActionListener(new KeyListener());
    key2.addActionListener(new KeyListener());
    key3.addActionListener(new KeyListener());
    key4.addActionListener(new KeyListener());
    key5.addActionListener(new KeyListener());
    key6.addActionListener(new KeyListener());
    key7.addActionListener(new KeyListener());
    key8.addActionListener(new KeyListener());
    key9.addActionListener(new KeyListener());
    key0.addActionListener(new KeyListener());
    keyA.addActionListener(new KeyListener());
    keyB.addActionListener(new KeyListener());
    keyPanel.add(key1);
    // ...
    keyPanel.add(key2);
    keyPanel.add(key3);
    keyPanel.add(key4);
    keyPanel.add(key5);
    keyPanel.add(key6);
    keyPanel.add(key7);
    keyPanel.add(key8);
    keyPanel.add(key9);
    keyPanel.add(keyA);
    keyPanel.add(key0);
    keyPanel.add(keyB);
    
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
    hookStatePanel.add(state, BorderLayout.NORTH);
    hookStatePanel.add(hook, BorderLayout.CENTER);
    
    // Fast fertig. Nun muss noch alles an der richtigen Position aufs
    // Fenster gelegt werden.
    getContentPane().add(keyDisplayPanel, BorderLayout.CENTER);
    //...
    getContentPane().add(hookStatePanel, BorderLayout.WEST);
    
    
    // Nachdem das GUI zusammengestellt ist, m�ssen nun noch die Listener
    // zugef�gt werden
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    hook.addActionListener(new HookListener());
    // ...
    
  
    // Und nun darf das Fenster angezeigt werden.
    setVisible(true); 
  }
  
  
  /* Die Listener-Klassen werden als innere Klassen deklariert.
     Dadurch sind die Attribute der Klasse JavaPhneGUI hier auch
  sichtbar.
  */
    // Die Listener-Klasse f�r den Hoook-Button
      class HookListener implements ActionListener {
      // Die Methode wird aufgerufen, wenn der Hook-Button geklickt wird.
        public void actionPerformed(ActionEvent e) {
        // �ndere den Text des Labels beim Hook-Button
        if (e.getActionCommand().equals("Hook off")) {
        // Set label of hook button to "Hook on"
      // Set state label to "connected")
        hook.setText("Hook on");
        state.setText("connected");
        } else {
        // Set label of hook button to "Hook off"
      // Set state label to "ready"
    // Delete number in display text field
  // ...
          hook.setText("Hook off");
          state.setText("ready");
          display.setText("");
      }
    }
  }

  // Die Listener-Klasse f�r die key-Buttons
  // F�r Detilas ist auf Quelle 4 verwiesen.
  class KeyListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      display.setText(display.getText() + e.getActionCommand());
    }
  }
}




