package N1_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Die Klasse Transmitter ermöglicht
 * a) das Versenden einer Mitteliung an beliebig viele Empfänger
 * b) das an- und abmelden von Empfänger
 * <p>
 * Die Kommunikation erfolgt anhand des Observer-Pattern. Dieses wird
 * in Java mit der Klasse Observable (für das Subject) und dem Interface
 * Observer (für den Observer) realisiert. Mehr Infos finden sich in der API.
 * <p>
 * Bis auf die Ereignisverarbeitung beim [Senden] ist die Klasse vollständig
 * implementiert.
 */

public class Transmitter extends Observable {

    private JFrame theWindow;
    private JTextField theMessage;
    private JButton btnSend;

    public Transmitter() {
        theWindow = new JFrame("Transmitter");
        theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        init();
        //
        theWindow.pack();
        theWindow.setVisible(true);
    }

    private void init() {
        /*
         * Einrichten des Benutzerfensters mit einem Textfeld für die Eingabe der Meldung
         * und der Senden-Schaltfläche.
         */
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Meldung: "), BorderLayout.WEST);
        theMessage = new JTextField(50);
        inputPanel.add(theMessage, BorderLayout.EAST);
        //
        JPanel btnPanel = new JPanel(new BorderLayout());
        btnSend = new JButton("Senden");
        btnPanel.add(btnSend, BorderLayout.EAST);
        //
        theWindow.getContentPane().add(inputPanel, BorderLayout.CENTER);
        theWindow.getContentPane().add(btnPanel, BorderLayout.SOUTH);
        // Einrichten der Controllers
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                doSend();
            }
        });
    }

    private void doSend() {
        setChanged();
        super.notifyObservers(theMessage.getText());
        theMessage.setText("");
    }


    /**
     * die main-Methode erzeugt ein Transmitter-Objekt und
     * beliebig viele Receive-Objekte.
     * Die Kommunikation wird durch die Benutzereingabe gesteuert.
     *
     * @param args
     */
    public static void main(String[] args) {
        Transmitter tx = new Transmitter();
        //
        // hier folgen die Empfänger-Objekte
    }
}
