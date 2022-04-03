package N1_1;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Die Klasse Receiver stellt ein Fenster zur Verf�gung, in welchem
 * eine Meldung angezeigt werden kann.
 * Die Meldung wird durch ein Transmitter-Objekt erzeugt und an alle
 * angemeldeten Empf�nger gesendet.
 * <p>
 * Die Kommunikation erfolgt anhand des Observer-Pattern. Dieses wird
 * in Java mit der Klasse Observable (f�r das Subject) und dem Interface
 * Observer (f�r den Observer) realisiert. Mehr Infos finden sich in der API.
 * <p>
 * Jedes Receiver-Objekt kann sich beim Transmitter an- bzw. abmelden.
 * Je nach Status (an/abgemeldet) ist die entsprechende Schaltfl�che inaktiv
 * bzw. aktiv. Somit ist f�r den Benutzer auch direkt ersichtlich, ob der
 * Empf�nger angemeldet ist.
 * <p>
 * F�r die Ausgabe der Meldungen wir eine JTextArea verwendet. Die Meldungen
 * werden mittels der append()-Methode zugef�gt.
 * <p>
 * Jeder Receiver erh�lt eine �berschrift der Form "Empf�nger 99", wobei die
 * Nummer mit 1 beginnt und f�r jeden neuen Receiver um eines erh�ht wird.
 * (Hinweis: statische Variable verwenden)
 */

public class Receiver extends JFrame implements Observer {
    static int recNumber = 0;
    private JTextArea messageOut;
    private JButton btnAddObserver, btnRemoveObserver;
    private Observable theTransmitter;


    JPanel btnPanel = new JPanel(new GridLayout(1, 2));
    JPanel bottomPanel = new JPanel(new BorderLayout());

    public Receiver(Observable tx) {
        recNumber++;
        this.setTitle("Empfänger " + recNumber);
        theTransmitter = tx;
        setLayout(new BorderLayout());
        //
        init();
        //
        pack();
        setVisible(true);
    }


    private void init() {
        messageOut = new JTextArea(10, 20);
        add(new JScrollPane(messageOut), BorderLayout.CENTER);
        btnAddObserver = new JButton("Anmelden");
        btnRemoveObserver = new JButton("Abmelden");
        btnPanel.add(btnRemoveObserver);
        btnPanel.add(btnAddObserver);
        bottomPanel.add(btnPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        btnAddObserver.addActionListener(e ->{
            onAdd();
        });

        btnRemoveObserver.addActionListener(e ->{
            onRemove();
        });

    }

    private void onAdd() {
        theTransmitter.addObserver(this);
        btnRemoveObserver.setEnabled(true);
        btnAddObserver.setEnabled(false);
    }

    private void onRemove() {
        theTransmitter.deleteObserver(this);
        btnRemoveObserver.setEnabled(false);
        btnAddObserver.setEnabled(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        messageOut.append(arg + "\n");
    }// ab hier implementieren Sie bitte die Klasse
}
