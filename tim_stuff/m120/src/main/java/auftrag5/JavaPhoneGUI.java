package auftrag5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**********************************************************
 *
 *  This class implements a simple phone GUI.
 *  When creating a new object of this class
 *  the GUI components, such as buttons, labels, etc. are
 *  just displayed. They do not yet react on user actions,
 *  such as pressing a button, etc.
 *
 * @author H. Diethelm, HTA Luzern
 * @version 1.0  12-06-2000
 * @version 2.0  01-02-2007 (R. Probst) change to swing
 * @version 2.1  17-02-2016 (R. Probst) kleinere Anpassungen
 *
 **********************************************************/
public class JavaPhoneGUI extends JFrame {
    // Hier die Schaltflächen (Buttons) deklarieren und gleich auch erzeugen.
    // Sie sehen das Beispiel für die Taste [0]. Ergänzen Sie nun die
    // restlichen Tasten 1...9 sowie + und #.
    // Vergessen Sie nicht die Schaltfläche für den Telefonhörer (hook)
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
    // Deklarieren Sie hier die weiteren Elemente gemäss den Ausführungen
    // in Quelle 2
    JTextField display = new JTextField();
    // ...
    JLabel state = new JLabel("ready");
    // Deklarieren Sie hier alle benötigten Panels, so wie in Auftrag 1
    // eingeführt.
    JPanel keyPanel = new JPanel();
    JPanel keyDisplayPanel = new JPanel();
    // ...
    JPanel hookStatePanel = new JPanel();
    private boolean connected = false;

    // Der Konstruktor fügt alle Elemente zum GUI zusammen
    JavaPhoneGUI() {
        // Das Fenster (JFrame) initialisieren. Es werden diverse Eigenschaften
        // festgelegt. Mehr dazu finden Sie in der API der Klasse JFrame.
        setTitle("JavaPhone");
        setBackground(Color.lightGray);
        setResizable(false);
        // Hier die Komponenten wenn nötig noch parametrieren.
        // Infos dazu finden Sie in der API der jeweiligen Klasse
        display.setEditable(false);

        // Die Layout-Manager für das JFrame und die JPanel festlegen.
        // Nähere Angaben dazu finden wich in Quelle 2
        getContentPane().setLayout(new BorderLayout(20, 20));
        keyPanel.setLayout(new GridLayout(4, 3, 20, 20));
        // ...
        keyDisplayPanel.setLayout(new BorderLayout(20, 20));
        hookStatePanel.setLayout(new BorderLayout(20, 20));

        // Aufbau des keyPanel mit allen Tasten des Telefons
        // Wenn SIe unsicher sind, was auf das keyPanel gehört, schauen Sie
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
        keyPanel.add(keyA);
        keyPanel.add(key0);
        keyPanel.add(keyB);

        // Und nun das displayPanel noch bestücken
        //...

        // Die beiden Panels korrekt positioniert auf ein weiteres Panel
        // keyDisplayPanel legen.
        keyDisplayPanel.add(display, BorderLayout.NORTH);
        keyDisplayPanel.add(keyPanel, BorderLayout.CENTER);

        // Verfahren Sie nun gleich wie oben gezeigt für den hook-Button und
        // das ready-Label.
        // Studieren sie wenn nötig nochmals Quelle 2.
        // ...
        hookStatePanel.add(state, BorderLayout.NORTH);
        hookStatePanel.add(hook, BorderLayout.CENTER);

        // Fast fertig. Nun muss noch alles an der richtigen Position aufs
        // Fenster gelegt werden.
        getContentPane().add(keyDisplayPanel, BorderLayout.CENTER);
        //...
        getContentPane().add(hookStatePanel, BorderLayout.WEST);


        // Nachdem das GUI zusammengestellt ist, müssen nun noch die Listener
        // zugefügt werden
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hook.addActionListener(new HookListener());
        key1.addActionListener(new NumberKeyListener());
        key2.addActionListener(new NumberKeyListener());
        key3.addActionListener(new NumberKeyListener());
        key4.addActionListener(new NumberKeyListener());
        key5.addActionListener(new NumberKeyListener());
        key6.addActionListener(new NumberKeyListener());
        key7.addActionListener(new NumberKeyListener());
        key8.addActionListener(new NumberKeyListener());
        key9.addActionListener(new NumberKeyListener());
        key0.addActionListener(new NumberKeyListener());
        keyA.addActionListener(new NumberKeyListener());
        keyB.addActionListener(new NumberKeyListener());


        // Und nun darf das Fenster angezeigt werden.
        setVisible(true);
    }


    /* Die Listener-Klassen werden als innere Klassen deklariert.
       Dadurch sind die Attribute der Klasse JavaPhneGUI hier auch
    sichtbar.
    */
    // Die Listener-Klasse für den Hoook-Button
    class HookListener implements ActionListener {
        // Die Methode wird aufgerufen, wenn der Hook-Button geklickt wird.
        public void actionPerformed(ActionEvent e) {
            // ändere den Text des Labels beim Hook-Button
            if (e.getActionCommand().equals("Hook off")) {
                // Set label of hook button to "Hook on"
                // Set state label to "connected")
                hook.setText("Hook on");
                state.setText("connected");
                connected = true;
            } else {
                // Set label of hook button to "Hook off"
                hook.setText("Hook off");
                // Set state label to "ready"
                state.setText("ready");
                // Delete number in display text field
                display.setText("");

                connected = false;
            }
        }
    }

    // Die Listener-Klasse für die key-Buttons
    // Für Details ist auf Quelle 4 verwiesen.
    class NumberKeyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!connected) {
                String ziffer = e.getActionCommand();
                display.setText(display.getText() + ziffer);
            }
        }
    }
}




