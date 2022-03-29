package N1_1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Die Klasse Transmitter erm�glicht 
 * a) das Versenden einer Mitteliung an beliebig viele Empf�nger
 * b) das an- und abmelden von Empf�nger
 *
 * Die Kommunikation erfolgt anhand des Observer-Pattern. Dieses wird
 * in Java mit der Klasse Observable (f�r das Subject) und dem Interface
 * Observer (f�r den Observer) realisiert. Mehr Infos finden sich in der API.
 *
 * Bis auf die Ereignisverarbeitung beim [Senden] ist die Klasse vollst�ndig
 * implementiert.
 */

public class Transmitter extends Observable{
  
  private JFrame theWindow;
  private JTextField theMessage;
  private JButton    btnSend;
  
  public Transmitter(){
    theWindow = new JFrame("Transmitter");
    theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //
    init();
    //
    theWindow.pack();
    theWindow.setVisible(true);
  }
  
  private void init(){
    /*
    * Einrichten des Benutzerfensters mit einem Textfeld f�r die Eingabe der Meldung
    * und der Senden-Schaltfl�che.
    */
    JPanel inputPanel = new JPanel(new BorderLayout());
    inputPanel.add(new JLabel("Meldung: "), BorderLayout.WEST);
    theMessage = new JTextField (50);
    inputPanel.add(theMessage, BorderLayout.EAST);
    //
    JPanel btnPanel = new JPanel(new BorderLayout());
    btnSend = new JButton("Senden");
    btnPanel.add(btnSend, BorderLayout.EAST);
    //
    theWindow.getContentPane().add(inputPanel, BorderLayout.CENTER);
    theWindow.getContentPane().add(btnPanel, BorderLayout.SOUTH);
    // Einrichten der Controllers
    btnSend.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
        doSend();
      }
    });
  }
  
  private void doSend(){
    this.setChanged();
    this.notifyObservers(theMessage.getText());
    theMessage.setText("");
  }

  
  /**
  * die main-Methode erzeugt ein Transmitter-Objekt und
  * beliebig viele Receive-Objekte.
  * Die Kommunikation wird durch die Benutzereingabe gesteuert.
  * @param args
  */
  public static void main(String[] args){
    Transmitter tx = new Transmitter();
    Receiver rx1 = new Receiver(tx);
    Receiver rx2 = new Receiver(tx);
    //
    // hier folgen die Empf�nger-Objekte
  }
}
