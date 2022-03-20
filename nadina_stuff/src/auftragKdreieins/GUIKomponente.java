package auftragKdreieins;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author Nadina Amsler (shirin197)
 * @date 20.03.2022
 * @beschreibung : Klasse welche sich mit dem JTable beschäftigt.
 *                 kleines Beispiel 
 * */


public class GUIKomponente extends JFrame{
  JTable table;

  private void init(){
    // Tabellenkopf, immer gleich viele haben wie Spalten
      String[] header = {"Name", "Nachname", "Verfügbar", "Zimmer"};

      // Tabelleninhalt
      Object[][] tabledata = {
              {"Nadina", "Amsler", Boolean.TRUE, 5.20},
              {"Thruka", "Rajkumar", Boolean.TRUE, 5.22},
              {"Sara", "Isejni", Boolean.FALSE, 4.99},
      };

      // DefaultTableModel
    DefaultTableModel dm =  new DefaultTableModel(tabledata, header);
    table = new JTable(dm){
      public Class getColumnClass(int column){
        return getValueAt(0, column).getClass();
      }
    };

    // JScrollPane notwenig damit es die Tabellennamen anzeigt
    JScrollPane sp = new JScrollPane(table);
    table.setFillsViewportHeight(true);

    this.getContentPane().add(sp, BorderLayout.CENTER);
  }

  public GUIKomponente(){
    super("Beispiel zu GUI-Komponente");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //
    init();
    //
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args){
    new GUIKomponente();
  }
}