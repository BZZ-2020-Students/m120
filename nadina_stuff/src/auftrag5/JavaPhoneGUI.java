package auftrag5;

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
  JButton keyA = new JButton("#");
  JButton keyB = new JButton("*");
  JButton hook = new JButton("Hook off");

  JTextField display = new JTextField();
  JLabel     state   = new JLabel("ready");

  JPanel keyPanel        = new JPanel();
  JPanel keyDisplayPanel = new JPanel();
  JPanel hookStatePanel  = new JPanel();
    
  // Der Konstruktor fügt alle Elemente zum GUI zusammen
  JavaPhoneGUI() {
    setTitle("JavaPhone");
    setBackground(Color.lightGray);
    setResizable(false);

    display.setEditable(false);

    getContentPane().setLayout(new BorderLayout(20, 20));
    keyPanel.setLayout(new GridLayout(4, 3, 20, 20));

    keyDisplayPanel.setLayout(new BorderLayout(20, 20));
    hookStatePanel.setLayout(new BorderLayout(20,20));

    keyPanel.add(key1);
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

    keyDisplayPanel.add(display, BorderLayout.NORTH);
    keyDisplayPanel.add(keyPanel, BorderLayout.CENTER);

    hookStatePanel.add(state, BorderLayout.NORTH);
    hookStatePanel.add(hook, BorderLayout.CENTER);

    getContentPane().add(keyDisplayPanel, BorderLayout.CENTER);
    getContentPane().add(hookStatePanel, BorderLayout.WEST);
    
    
    // Nachdem das GUI zusammengestellt ist, müssen nun noch die Listener  zugefügt werden
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    hook.addActionListener(new HookListener());

    key1.addActionListener(new KeyListener());
    key2.addActionListener(new KeyListener());
    key3.addActionListener(new KeyListener());
    key4.addActionListener(new KeyListener());
    key5.addActionListener(new KeyListener());
    key6.addActionListener(new KeyListener());
    key7.addActionListener(new KeyListener());
    key8.addActionListener(new KeyListener());
    key9.addActionListener(new KeyListener());
    keyA.addActionListener(new KeyListener());
    key0.addActionListener(new KeyListener());
    keyB.addActionListener(new KeyListener());


    // Und nun darf das Fenster angezeigt werden.
    setVisible(true); 
  }
  
  /* Die Listener-Klassen werden als innere Klassen deklariert.
     Dadurch sind die Attribute der Klasse JavaPhneGUI hier auch
  sichtbar.
  */
    // Die Listener-Klasse für den Hoook-Button
      class HookListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Hook off")) {
        hook.setText("Hook on");
        state.setForeground(Color.red);
        state.setText("connected");
        } else {
          hook.setText("Hook off");
          state.setForeground(Color.green);
          state.setText("ready");
          display.setText("");
      }
    }
  }

  // Die Listener-Klasse für die key-Buttons
  // Für Detailas ist auf Quelle 4 verwiesen.

  class KeyListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
       String num = e.getActionCommand();
       display.setText(display.getText() + num);
    }
  }
}




