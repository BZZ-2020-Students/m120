package n1_1;

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
    private final Label receiverLabel;
    private final JButton subscribeButton;
    private final JButton unsubscribeButton;

    public Receiver(Transmitter trans) {
        super("Empfänger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        receiverLabel = new Label("Empfänger");
        add(receiverLabel, BorderLayout.CENTER);

        subscribeButton = new JButton("Anmelden");
        unsubscribeButton = new JButton("Abmelden");
        subscribeButton.addActionListener(e -> {
            trans.addObserver(this);
            subscribeButton.setEnabled(false);
            unsubscribeButton.setEnabled(true);
        });

        unsubscribeButton.addActionListener(e -> {
                    trans.deleteObserver(this);
                    subscribeButton.setEnabled(true);
                    unsubscribeButton.setEnabled(false);
                }
        );

        add(subscribeButton, BorderLayout.NORTH);
        add(unsubscribeButton, BorderLayout.SOUTH);

        setSize(400, 400);
        setVisible(true);
    }


    @Override
    public void update(Observable o, Object arg) {
        String message = (String) arg;
        receiverLabel.setText(message);
    }

    public static void main(String[] args) {
        Transmitter transmitter = new Transmitter();
        for (int i = 0; i < 1000; i++) {
            new Receiver(transmitter);
        }
//        Receiver receiver = new Receiver(transmitter);
    }
}
