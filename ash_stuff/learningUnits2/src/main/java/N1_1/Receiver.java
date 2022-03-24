package N1_1;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
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

public class Receiver extends JFrame implements Observer {
    @Override
    public void update(Observable o, Object arg) {

    }// ab hier implementieren Sie bitte die Klasse
}
