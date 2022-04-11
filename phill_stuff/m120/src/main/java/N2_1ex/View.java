package N2_1ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Die Klasse View stellt eine Graphik-Komponente gemäss MVC-Pattern bereit.
 * Es handelt sich um eine JList. Die Daten für die Liste werden aus der Model-Klasse
 * Model gelesen. Dazu implementiert die Model-Klasse das Interface ListModel bzw.
 * die Komfort-Klasse DefaultListModel.
 * Hier wird auf ein entsprechendes Objekt referenziert.
 * 
 * Die JList kann zur Laufzeit um weitere Einträge (Item) erweitert werden. Dazu 
 * dient eine Schaltfläche [add Item]. Diese blendet dann oberhalb der Liste
 * ein Textfeld ein, in welchem die Eingabe vorgenommen und mit der ENTER-Taste
 * bestätigt wird.
 * Der Eintrag wird dann dem Model übergeben (über die definierte Schnittstelle von
 * DefaultListModel). 
 * Danach wird die Eingabe wieder ausgeblendet.
 * 
 * Mittels MVC-Mechanismus wird dann die Liste um den neuen Wert erweitert.
 * Die Contoll-Komponenten sind hier als anonyme Klassen in der View integriert.
 * Der ActionListener steuert dabei die Kommunikation mit der View, während 
 * der KeyListener das Model mit neuen Daten versorgt.
 * 
 * @author René Probst
 *
 */
public class View extends JFrame{
  

  private JList viewComponent;
  private JButton addItem;
  private JButton savelist;
  private JButton readlist;
  private JTextField inputValue;
  private Model model;
  private String filename = "list.ser";
  
  /**
  * Konstruktor
  */
  public View(Model m){
    super("View-Komponente");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //
    model = m;
    if (!model.checkifFileExists(filename)) {
      model.createFile(filename);
    }
    model.loadList(filename);

    //
    init();
    //
    pack();
    setVisible(true);
  }
  
  
  private void init(){

    viewComponent = new JList<String>(model);
    JScrollPane scroll = new JScrollPane(viewComponent);

    this.add(scroll,BorderLayout.CENTER);

    addItem = new JButton("Add Item");
    addItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        onAddItem();
      }
    });

    addWindowListener(
      new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
          super.windowClosing(e);
          model.saveList(filename);
        }
      }
    );

//    savelist = new JButton("Save List");
//    savelist.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        onSaveList();
//
//      }
//    });
//    readlist = new JButton("Read List");
//    readlist.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        onReadList();
//
//      }
//    });

    JPanel eastPanel = new JPanel();
//    eastPanel.add(readlist,BorderLayout.WEST);
//    eastPanel.add(savelist,BorderLayout.CENTER);
    eastPanel.add(addItem,BorderLayout.EAST);


    this.add(eastPanel,BorderLayout.SOUTH);

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
  * Die Methode wird beim Klicken auf die Schaltfläche [add Item] aufgerufen.
  * Sie blendet das Textfeld ein und setzt den Fokus für die Werteingabe im 
  * Textfeld.
  */
  private void onAddItem(){
    inputValue.setVisible(true);
    pack();
    this.repaint();
    inputValue.requestFocus();
    model.saveList(filename);
  }

  private void onSaveList(){


    System.out.println("Save List");
    model.saveList(filename);
  }

  private void onReadList(){
    System.out.println("Read List");
    model.loadList(filename);
  }
  
  
  /**
  * Die Methode prüft das eingegeben Zeichen auf ENTER.
  * Bei ENTER wird das Textfeld wieder ausgeblendet und der Fokus auf die Liste gesetzt.
  * Nun wird dem Datenmodel der neue Wert übermittelt und danach der Wert gelöscht.
  * @param event
  */
  private void onEnter(KeyEvent event){
    if (event.getKeyChar() == KeyEvent.VK_ENTER){
      inputValue.setVisible(false);
      pack();
      this.repaint();
      model.addElement(inputValue.getText());
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
    // do it

    Model model = new Model();

    View view = new View(model);


  }
}
