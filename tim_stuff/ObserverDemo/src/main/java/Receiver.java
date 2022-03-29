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

public class Receiver { // ab hier implementieren Sie bitte die Klasse

}
