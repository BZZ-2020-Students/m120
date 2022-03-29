package N2_1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Die Klasse View stellt eine Grafik-Komponente gem�ss MVC-Pattern bereit.
 * Es handelt sich um eine JList. Die Daten für die Liste werden aus der Model-Klasse
 * Model gelesen. Dazu implementiert die Model-Klasse das Interface ListModel bzw.
 * die Komfort-Klasse DefaultListModel.
 * Hier wird auf ein entsprechendes Objekt referenziert.
 * 
 * Die JList kann zur Laufzeit um weitere Eintr�ge (Item) erweitert werden. Dazu 
 * dient eine Schaltfläche [add Item]. Diese blendet dann oberhalb der Liste
 * ein Textfeld ein, in welchem die Eingabe vorgenommen und mit der ENTER-Taste
 * bestätigt wird.
 * Der Eintrag wird dann dem Model übergeben (�ber die definierte Schnittstelle von
 * DefaultListModel). 
 * Danach wird die Eingabe wieder ausgeblendet.
 * 
 * Mittels MVC-Mechanismus wird dann die Liste um den neuen Wert erweitert.
 * Die Control-Komponenten sind hier als anonyme Klassen in der View integriert.
 * Der ActionListener steuert dabei die Kommunikation mit der View, während
 * der KeyListener das Model mit neuen Daten versorgt.
 * 
 * @author Ren� Probst
 *
 */
public class View extends JFrame{

  JList<String> viewComponent = new JList<>();
  JButton addItem = new JButton("Add item");
  JTextField inputValue;
  DefaultListModel<String> model;
  JPanel buttonPanel = new JPanel(new BorderLayout());
  /* deklarieren Sie hier alle benötigten Grafik-Komponenten
  * - Liste        (muss viewComponent heissen)
  * - Schaltfläche (beliebiger Name)
  * - Textfeld (muss inputValue heissen)
  * sowie die Referenz (muss model heissen) zum Daten-Model.
  *
  * do it
  */
  
  
  /**
  * Konstruktor
  */
  public View(DefaultListModel<String> m){
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
    setLayout(new BorderLayout());
    viewComponent = new JList<>(model);
    JScrollPane scrollPane = new JScrollPane(viewComponent);
    add(scrollPane, BorderLayout.CENTER);
    /*
    * Erstellen Sie die Schaltfläche [add Item]. Legen Sie diese in einem
    * JPanel im Osten ab. Dieses Panel legen Sie dann im S�den des Frames ab.
    * Fügen Sie einen ActionListener als anonyme Klasse zu.
    * Er ruft die onAddItem()-Methode auf.
    *
    * do it
    */

    addItem.addActionListener(e -> {
        onAddItem();
    });
    buttonPanel.add(addItem, BorderLayout.EAST);
    add(buttonPanel, BorderLayout.SOUTH);
    
    /*
    * Erstellen Sie ein Textfeld f�r die Eingabe neuer Items.
    * Das Textfeld ist zu Beginn unsichtbar. Es wird erst �ber [add Item] eingeblendet.
    * Das Textfeld legen Sie im Norden des Frames ab.
    * F�gen Sie einen KeyAdapter als anonyme Klasse zu.
    * Er ruft die onEnter()-Methode auf.
    * 
    * do it
    */
    inputValue =  new JTextField(5);
    inputValue.setVisible(false);
    add(inputValue, BorderLayout.NORTH);

    inputValue.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
          onEnter(e);
      }
    });

  }
  
  
  /**
  * Die Methode wird beim Klicken auf die Schaltfläche [add Item] aufgerufen.
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
  * Die Methode pr�ft die eingegebenen Zeichen auf ENTER.
  * Bei ENTER wird das Textfeld wieder ausgeblendet und der Fokus auf die Liste gesetzt.
  * Nun wird dem Datenmodel der neue Wert übermittelt und danach der Wert gelöscht.
  * @param event
  */
  private void onEnter(KeyEvent event){
    if (event.getKeyChar() == KeyEvent.VK_ENTER){
      inputValue.setVisible(false);
      pack();
      this.repaint();
      // Hier dem Daten-Model den Wert des Textfeldes übergeben
      // do it
      model.addElement(inputValue.getText());
      //
      inputValue.setText("");
      viewComponent.requestFocus();
    }
  }
  
  /**
  * Main erzeugt zuerst ein Objekt des Daten-Models und
  * danach die View.
  * @param args
  */
  public static void main(String[] args){
    // do it
    new View(new Model());
  }
}
