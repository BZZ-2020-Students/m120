package aufgab3_firstgui;

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
 * @author H. Diethelm, HTA Luzern
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

    JButton[] keys = new JButton[12];
    // ...

    //
    // Deklarieren Sie hier die weiteren Elemente gem�ss den Ausf�hrungen
    // in Quelle 2
    JTextField display = new JTextField("");
    JLabel state = new JLabel("ready");
    // ...
    JButton hookupkey = new JButton("Hook up");
    // Deklarieren Sie hier alle ben�tigten Panels, so wie in Auftrag 1
    // eingef�hrt.
    JPanel keyPanel = new JPanel();
    JPanel keyDisplayPanel = new JPanel();
    JPanel keyLeftDisplayPanel = new JPanel();
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
        // ...


        // Aufbau des keyPanel mit allen Tasten des Telefons
        // Wenn SIe unsicher sind, was auf das keyPanel geh�rt, schauen Sie
        // sich nochmals das Ergebnis von Auftrag 1 an.

        for (int i = 0; i < keys.length; i++) {
           if (i < 9){
               keys[i] = new JButton(i+1+"");
           }else if(i == 9){
               keys[i] = new JButton("#");
           } else if (i == 10){
               keys[i] = new JButton("0");
           }else if (i == 11){
               keys[i] = new JButton("*");
           }

            keyPanel.add(keys[i]);
        }

        // ...
        // Und nun das displayPanel noch best�cken
        //...

        // Die beiden Panels korrekt positioniert auf ein weiteres Panel
        // keyDisplayPanel legen.
        keyDisplayPanel.setLayout(new BorderLayout());
        keyDisplayPanel.add(display, BorderLayout.NORTH);
        keyDisplayPanel.add(keyPanel, BorderLayout.CENTER);
        keyLeftDisplayPanel.setLayout(new BorderLayout());
        keyLeftDisplayPanel.add(state,BorderLayout.NORTH);
        keyLeftDisplayPanel.add(hookupkey,BorderLayout.CENTER);


        // Verfahren Sie nun gleich wie oben gezeigt f�r den hook-Button und
        // das ready-Label.
        // Studieren sie wenn n�tig nochmals Quelle 2.
        // ...

        // Fast fertig. Nun muss noch alles an der richtigen Position aufs
        // Fenster gelegt werden.
        getContentPane().add(keyDisplayPanel, BorderLayout.CENTER);
        getContentPane().add(keyLeftDisplayPanel,BorderLayout.WEST);
        //...

        // Und nun darf das Fenster angezeigt werden.
        setVisible(true);
    }
}