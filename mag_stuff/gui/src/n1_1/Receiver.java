package n1_1;

import javax.swing.*;

import java.awt.*;
import java.util.*;
/**
  * Die Klasse Receiver stellt ein Fenster zur Verfügung, in welchem
  * eine Meldung angezeigt werden kann.
  * Die Meldung wird durch ein Transmitter-Objekt erzeugt und an alle
  * angemeldeten Empfänger gesendet.
  *
  * Die Kommunikation erfolgt anhand des Observer-Pattern. Dieses wird
  * in Java mit der Klasse Observable (für das Subject) und dem Interface
  * Observer (für den Observer) realisiert. Mehr Infos finden sich in der API.
  *
  * Jedes Receiver-Objekt kann sich beim Transmitter an- bzw. abmelden.
  * Je nach Status (an/abgemeldet) ist die entsprechende Schaltfläche inaktiv
  * bzw. aktiv. Somit ist für den Benutzer auch direkt ersichtlich, ob der 
  * Empfänger angemeldet ist.
  *
  * Für die Ausgabe der Meldungen wir eine JTextArea verwendet. Die Meldungen
  * werden mittels der append()-Methode zugefügt.
  *
  * Jeder Receiver erhält eine Überschrift der Form "Empfänger 99", wobei die
  * Nummer mit 1 beginnt und für jeden neuen Receiver um eines erhöht wird.
  * (Hinweis: statische Variable verwenden)
  */

public class Receiver extends JFrame implements Observer{// ab hier implementieren Sie bitte die Klasse
    private TextArea label = new TextArea("Empfänger");
    private JButton anmelden = new JButton("Anmelden");
    private JButton abmelden = new JButton("Abmelden");

    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel grid = new JPanel(new GridLayout(1,2));

    public Receiver(Observable trans) {
        setTitle("Empfänger");
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
