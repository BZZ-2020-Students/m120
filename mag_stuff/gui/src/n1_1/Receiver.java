package n1_1;

import javax.swing.*;

import java.awt.*;
import java.util.*;
/**
  * Die Klasse Receiver stellt ein Fenster zur Verf�gung, in welchem
  * eine Meldung angezeigt werden kann.
  * Die Meldung wird durch ein Transmitter-Objekt erzeugt und an alle
  * angemeldeten Empf�nger gesendet.
  *
  * Die Kommunikation erfolgt anhand des Observer-Pattern. Dieses wird
  * in Java mit der Klasse Observable (f�r das Subject) und dem Interface
  * Observer (f�r den Observer) realisiert. Mehr Infos finden sich in der API.
  *
  * Jedes Receiver-Objekt kann sich beim Transmitter an- bzw. abmelden.
  * Je nach Status (an/abgemeldet) ist die entsprechende Schaltfl�che inaktiv
  * bzw. aktiv. Somit ist f�r den Benutzer auch direkt ersichtlich, ob der 
  * Empf�nger angemeldet ist.
  *
  * F�r die Ausgabe der Meldungen wir eine JTextArea verwendet. Die Meldungen
  * werden mittels der append()-Methode zugef�gt.
  *
  * Jeder Receiver erh�lt eine �berschrift der Form "Empf�nger 99", wobei die
  * Nummer mit 1 beginnt und f�r jeden neuen Receiver um eines erh�ht wird.
  * (Hinweis: statische Variable verwenden)
  */

public class Receiver extends JFrame implements Observer{// ab hier implementieren Sie bitte die Klasse
    private TextArea label = new TextArea("Empf�nger");
    private JButton anmelden = new JButton("Anmelden");
    private JButton abmelden = new JButton("Abmelden");

    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel grid = new JPanel(new GridLayout(1,2));

    public Receiver(Observable trans) {
        setTitle("Empf�nger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        label.setEditable(false);
        add(label, BorderLayout.NORTH);

        anmelden.addActionListener(e -> {
            trans.addObserver(this);
            anmelden.setEnabled(false);
            abmelden.setEnabled(true);
        });

        abmelden.addActionListener(e -> {
                    trans.deleteObserver(this);
                    anmelden.setEnabled(true);
                    abmelden.setEnabled(false);
                }
        );

        grid.add(abmelden);
        grid.add(anmelden);
        panel.add(grid, BorderLayout.EAST);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }


    @Override
    public void update(Observable o, Object ob) {
        String message = label.getText() + "\n" +  ob;
        label.setText(message);
    }

    public static void main(String[] args) {
        Transmitter transmitter = new Transmitter();
        Receiver receiver = new Receiver(transmitter);
    }
}
