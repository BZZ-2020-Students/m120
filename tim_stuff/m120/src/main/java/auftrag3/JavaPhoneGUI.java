package auftrag3;

import javax.swing.*;
import java.awt.*;

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
    JButton key0 = new JButton("0");
    JButton key1 = new JButton("1");
    JButton key2 = new JButton("2");
    JButton key3 = new JButton("3");
    JButton key4 = new JButton("4");
    JButton key5 = new JButton("5");
    JButton key6 = new JButton("6");
    JButton key7 = new JButton("7");
    JButton key8 = new JButton("8");
    JButton key9 = new JButton("9");

    JButton keyHash = new JButton("#");
    JButton keyStar = new JButton("*");
    JButton hookButton = new JButton("Hook off");

    //
    // Deklarieren Sie hier die weiteren Elemente gemäss den Ausführungen
    // in Quelle 2
    JTextField display = new JTextField();
    JLabel state = new JLabel("ready");

    // Deklarieren Sie hier alle benötigten Panels, so wie in Auftrag 1
    // eingeführt.
    JPanel keyPanel = new JPanel();
    JPanel keyDisplayPanel = new JPanel();
    JPanel hookStatePanel = new JPanel();

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
        hookStatePanel.setLayout(new BorderLayout());
        keyDisplayPanel.setLayout(new BorderLayout());

        // Aufbau des keyPanel mit allen Tasten des Telefons
        // Wenn Sie unsicher sind, was auf das keyPanel gehört, schauen Sie
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
        keyPanel.add(keyHash);
        keyPanel.add(key0);
        keyPanel.add(keyStar);

        // Und nun das displayPanel noch bestücken


        // Die beiden Panels korrekt positioniert auf ein weiteres Panel
        // keyDisplayPanel legen.
        keyDisplayPanel.add(display, BorderLayout.NORTH);
        keyDisplayPanel.add(keyPanel, BorderLayout.CENTER);

        // Verfahren Sie nun gleich wie oben gezeigt für den hook-Button und
        // das ready-Label.
        // Studieren Sie, wenn nötig nochmals Quelle 2.
        hookStatePanel.add(state, BorderLayout.NORTH);
        hookStatePanel.add(hookButton, BorderLayout.CENTER);

        // Fast fertig. Nun muss noch alles an der richtigen Position aufs Fenster gelegt werden.
        getContentPane().add(keyDisplayPanel, BorderLayout.CENTER);
        getContentPane().add(hookStatePanel, BorderLayout.WEST);
        setVisible(true);
    }
}