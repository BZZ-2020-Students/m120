package ueben.N2_1;

import ueben.N2_1.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Die Klasse View stellt eine Graphik-Komponente gem�ss MVC-Pattern bereit.
 * Es handelt sich um eine JList. Die Daten f�r die Liste werden aus der Model-Klasse
 * Model gelesen. Dazu implementiert die Model-Klasse das Interface ListModel bzw.
 * die Komfort-Klasse DefaultListModel.
 * Hier wird auf ein entsprechendes Objekt referenziert.
 * 
 * Die JList kann zur Laufzeit um weitere Eintr�ge (Item) erweitert werden. Dazu 
 * dient eine Schaltfl�che [add Item]. Diese blendet dann oberhalb der Liste
 * ein Textfeld ein, in welchem die Eingabe vorgenommen und mit der ENTER-Taste
 * best�tigt wird.
 * Der Eintrag wird dann dem Model �bergeben (�ber die definierte Schnittstelle von
 * DefaultListModel). 
 * Danach wird die Eingabe wieder ausgeblendet.
 * 
 * Mittels MVC-Mechanismus wird dann die Liste um den neuen Wert erweitert.
 * Die Contoll-Komponenten sind hier als anonyme Klassen in der View integriert.
 * Der ActionListener steuert dabei die Kommunikation mit der View, w�hrend 
 * der KeyListener das Model mit neuen Daten versorgt.
 * 
 * @author Ren� Probst
 *
 */
public class View extends JFrame{
  
  /* deklarieren Sie hier alle ben�tigten Graphik-Komponenten
  * - Liste        (muss viewComponent heissen)
  * - Schaltfl�che (beliebiger Name)
  * - Textfeld     (muss inputValue heissen)
  * sowie die Referenz (muss model heissen) zum Daten-Model.
  *
  * do it
  */
  private JList viewComponent;
  private JButton button;
  private JTextField inputValue;
  private Model model;

  /**
  * Konstruktor
  */
  public View(Model m){
    super("View-Komponente");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //
    model = m;
    //
    init();
    //
    pack();
    setVisible(true);
  }
  
  
  private void init(){
    /*
    * Erstellen Sie die Liste. Legen Sie diese in einer JScrollPane ab. 
    * Diese platzieren Sie dann im Zentrum des Frames.
    *
    * do it
    */
    viewComponent = new JList<String>(model);
    JScrollPane scrollPane = new JScrollPane(viewComponent);

    this.add(scrollPane,BorderLayout.CENTER);
    
    /*
    * Erstellen Sie die Schaltfl�che [add Item]. Legen Sie diese in einem 
    * JPanel im Osten ab. Dieses Panel legen Sie dann im S�den des Frames ab.
    * F�gen Sie einen ActionListener als anonyme Klasse zu. 
    * Er ruft die onAddItem()-Methode auf.
    *
    * do it
    */
    JPanel leftpanel = new JPanel();
    button = new JButton("add Item");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        onAddItem();
      }
    });


    leftpanel.add(button,BorderLayout.EAST);

    this.add(leftpanel,BorderLayout.SOUTH);



    
    /*
    * Erstellen Sie ein Textfeld f�r die Eingabe neuer Items.
    * Das Textfeld ist zu Beginn unsichtbar. Es wird erst �ber [add Item] eingeblendet.
    * Das Textfeld legen Sie im Norden des Frames ab.
    * F�gen Sie einen KeyAdapter als anonyme Klasse  zu. 
    * Er ruft die onEnter()-Methode auf.
    * 
    * do it
    */
    inputValue = new JTextField();
    inputValue.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        onEnter(e);
      }


    });
    inputValue.setVisible(false);

    this.add(inputValue,BorderLayout.NORTH);

  }
  
  
  /**
  * Die Methode wird beim Klicken auf die Schaltfl�che [add Item] aufgerufen.
  * Sie blendet das Textfeld ein und setzt den Fokus f�r die Werteingabe im 
  * Textfeld.
  */
  private void onAddItem(){
    inputValue.setVisible(true);
    pack();
    this.repaint();
    inputValue.requestFocus();
  }
  
  
  /**
  * Die Methode pr�ft das eingegeben Zeichen auf ENTER.
  * Bei ENTER wird das Textfeld wieder ausgeblendet und der Fokus auf die Liste gesetzt.
  * Nun wird dem Datenmodel der neue Wert �bermittelt und danach der Wert gel�scht.
  * @param event
  */
  private void onEnter(KeyEvent event){
    if (event.getKeyChar() == KeyEvent.VK_ENTER){
      inputValue.setVisible(false);
      pack();
      this.repaint();
      // Hier dem Daten-Model den Wert des Textfeldes �bergeben
      // do it
      model.addElement(inputValue.getText());
      //
      inputValue.setText("");
      viewComponent.requestFocus();
    }
  }
  
  /**
  * Main erzeugt zuerst ein Objekt des Daten-Model und 
  * danach die View.
  * @param args
  */
  public static void main(String[] args){
    Model model = new Model();
    View view = new View(model);
    
  }
}
