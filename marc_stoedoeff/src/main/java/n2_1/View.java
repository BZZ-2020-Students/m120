package n2_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Die Klasse n2_1.View stellt eine Graphik-Komponente gem?ss MVC-Pattern bereit.
 * Es handelt sich um eine JList. Die Daten f?r die Liste werden aus der n2_1.Model-Klasse
 * n2_1.Model gelesen. Dazu implementiert die n2_1.Model-Klasse das Interface ListModel bzw.
 * die Komfort-Klasse DefaultListModel.
 * Hier wird auf ein entsprechendes Objekt referenziert.
 * 
 * Die JList kann zur Laufzeit um weitere Eintr?ge (Item) erweitert werden. Dazu 
 * dient eine Schaltfl?che [add Item]. Diese blendet dann oberhalb der Liste
 * ein Textfeld ein, in welchem die Eingabe vorgenommen und mit der ENTER-Taste
 * best?tigt wird.
 * Der Eintrag wird dann dem n2_1.Model ?bergeben (?ber die definierte Schnittstelle von
 * DefaultListModel). 
 * Danach wird die Eingabe wieder ausgeblendet.
 * 
 * Mittels MVC-Mechanismus wird dann die Liste um den neuen Wert erweitert.
 * Die Contoll-Komponenten sind hier als anonyme Klassen in der n2_1.View integriert.
 * Der ActionListener steuert dabei die Kommunikation mit der n2_1.View, w?hrend
 * der KeyListener das n2_1.Model mit neuen Daten versorgt.
 * 
 * @author Ren? Probst
 *
 */
public class View extends JFrame{

  /* deklarieren Sie hier alle ben?tigten Graphik-Komponenten
  * - Liste        (muss viewComponent heissen)
  * - Schaltfl?che (beliebiger Name)
  * - Textfeld     (muss inputValue heissen)
  * sowie die Referenz (muss model heissen) zum Daten-n2_1.Model.
  *
  * do it
  */
  private DefaultListModel<String> model;
  private JList<String> list;
  private JButton addItemButton;
  private JTextField inputValue;

  /**
  * Konstruktor
  */
  public View(DefaultListModel<String> m){
    super("n2_1.View-Komponente");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //
    model = m;
    //
    init();
    //
    pack();
    setVisible(true);
  }
  
  
  private void init() {
    list = new JList<>(model);
    addItemButton = new JButton("add Item");
    inputValue = new JTextField();

    inputValue.setVisible(false);
    inputValue.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
       onEnter(e);
      }
    });

    addItemButton.addActionListener(e -> onAddItem());

    add(inputValue, BorderLayout.NORTH);
    add(list, BorderLayout.CENTER);
    add(addItemButton, BorderLayout.SOUTH);
  }
  
  
  /**
  * Die Methode wird beim Klicken auf die Schaltfl?che [add Item] aufgerufen.
  * Sie blendet das Textfeld ein und setzt den Fokus f?r die Werteingabe im 
  * Textfeld.
  */
  private void onAddItem(){
    inputValue.setVisible(true);
    pack();
    this.repaint();
    inputValue.requestFocus();
  }
  
  
  /**
  * Die Methode pr?ft das eingegeben Zeichen auf ENTER.
  * Bei ENTER wird das Textfeld wieder ausgeblendet und der Fokus auf die Liste gesetzt.
  * Nun wird dem Datenmodel der neue Wert ?bermittelt und danach der Wert gel?scht.
  * @param event
  */
  private void onEnter(KeyEvent event){
    if (event.getKeyChar() == KeyEvent.VK_ENTER){
      inputValue.setVisible(false);
      model.addElement(inputValue.getText());
      pack();
      this.repaint();
      // Hier dem Daten-n2_1.Model den Wert des Textfeldes ?bergeben
      // do it
      //
      inputValue.setText("");
      list.requestFocus();
    }
  }
  
  /**
  * Main erzeugt zuerst ein Objekt des Daten-n2_1.Model und
  * danach die n2_1.View.
  * @param args
  */
  public static void main(String[] args){
    DefaultListModel<String> model = new DefaultListModel<>();
    new View(model);
  }
}
