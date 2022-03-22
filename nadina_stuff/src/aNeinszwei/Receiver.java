package aNeinszwei;

import aLdreieins.DemoBtnGUI;

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

public class Receiver extends JFrame implements Observer {
   // ab hier implementieren Sie bitte die Klasse

    private int recNumber = 0;
    private JTextArea messageOut;
    private JButton btnAddObserver;
    private JButton btnRemoveObserver;

    private JFrame recievergui;

    private Observable theTransmitter;

    public Receiver(Observable tx){
        tx.addObserver(this);

        recievergui = new JFrame("Empfänger");
        recievergui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        recievergui.setSize(300,200);
        //
        init();
        //
        recievergui.setVisible(true);
    }

    private void init(){
        JPanel repanel = new JPanel(new BorderLayout());
        messageOut = new JTextArea();
        messageOut.setLineWrap(true);
        repanel.add(messageOut, BorderLayout.CENTER);

        JPanel btnpanel = new JPanel(new FlowLayout());
        btnAddObserver = new JButton("Anmelden");
        btnRemoveObserver = new JButton("Abmelden");

        btnpanel.add(btnAddObserver);
        btnpanel.add(btnRemoveObserver);

        recievergui.getContentPane().add(repanel, BorderLayout.CENTER);
        recievergui.getContentPane().add(btnpanel, BorderLayout.SOUTH);

    }

    private void onAdd(){

    }

    private void onRemove(){

    }

    @Override
    public void update(Observable o, Object arg) {
        messageOut.append(arg + System.lineSeparator());
    }
}
