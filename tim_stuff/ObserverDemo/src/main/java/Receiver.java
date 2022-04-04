import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Die Klasse Receiver stellt ein Fenster zur Verfügung, in welchem
 * eine Meldung angezeigt werden kann.
 * Die Meldung wird durch ein Transmitter-Objekt erzeugt und an alle
 * angemeldeten Empfänger gesendet.
 * <p>
 * Die Kommunikation erfolgt anhand des Observer-Pattern. Dieses wird
 * in Java mit der Klasse Observable (für das Subject) und dem Interface
 * Observer (für den Observer) realisiert. Mehr Infos finden sich in der API.
 * <p>
 * Jedes Receiver-Objekt kann sich beim Transmitter an- bzw. abmelden.
 * Je nach Status (an/abgemeldet) ist die entsprechende Schaltfläche inaktiv
 * bzw. aktiv. Somit ist für den Benutzer auch direkt ersichtlich, ob der
 * Empfänger angemeldet ist.
 * <p>
 * Für die Ausgabe der Meldungen wir eine JTextArea verwendet. Die Meldungen
 * werden mittels der append()-Methode zugefügt.
 * <p>
 * Jeder Receiver erhält eine Überschrift der Form "Empfänger 99", wobei die
 * Nummer mit 1 beginnt und für jeden neuen Receiver um eines erhöht wird.
 * (Hinweis: statische Variable verwenden)
 */

public class Receiver extends JFrame implements Observer {
    private final int recNumber;
    private JTextArea messageOut;
    private JButton addObserver;
    private JButton removeObserver;
    private final Observable theTransmitter;

    public Receiver(Observable tx, int recNumber) throws HeadlessException {
        this.theTransmitter = tx;
        this.recNumber = recNumber;

        init();
    }

    private void init() {
        setTitle("Empfänger " + recNumber);
        setLayout(new BorderLayout());

        messageOut = new JTextArea();
        messageOut.setEditable(false);
        add(new JScrollPane(messageOut), BorderLayout.CENTER);

        addObserver = new JButton("Anmelden");
        addObserver.addActionListener(e -> onAdd());
        add(addObserver, BorderLayout.NORTH);

        removeObserver = new JButton("Abmelden");
        removeObserver.addActionListener(e -> onRemove());
        add(removeObserver, BorderLayout.SOUTH);

        setSize(200, 200);
        setVisible(true);

        onAdd();
    }

    private void onAdd() {
        theTransmitter.addObserver(this);
        addObserver.setEnabled(false);
        removeObserver.setEnabled(true);
    }

    private void onRemove() {
        theTransmitter.deleteObserver(this);
        addObserver.setEnabled(true);
        removeObserver.setEnabled(false);
    }

    @Override
    public void update(Observable o, Object arg) {
        messageOut.append(arg.toString() + "\n");
    }

}
