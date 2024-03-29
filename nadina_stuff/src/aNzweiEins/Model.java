package aNzweieins;

import java.util.*;

import javax.swing.*;

/**
 * Das Daten-Model representiert eine Vielzahl von Strings (z.B. Hobbies)
 * Die Datenwerte werden in einem Vector gehalten.
 * 
 * F�r die Kommunikation mit der View werden die notwendigen Methoden aus
 * DefaultListModel �berschrieben.
 * 
 * @author Ren� Probst
 *
 */
public class Model extends DefaultListModel<String>{

  
  private Vector<String> data;
  
  public Model(){
    data = new Vector<String>();
    data.add("Skifahren");
    data.add("Schwimmen");
    data.add("Fussball");
    data.add("Segeln");
    data.add("Cart Rennen");
    data.add("Volleyball");
    data.add("Biken");
    Collections.sort(data);  //das sieht einfach sch�ner aus//
  }

  @Override
  /**
   * Liefert das Element, das durch arg0 indiziert wird.
   */
  public String getElementAt(int arg0) {
    return data.get(arg0);
  }

  @Override
  /**
   * Liefert die Anzahl der vorhandenen Datenwerte
   */
  public int getSize() {
    return data.size();
  }
  
  @Override
  /**
   * F�gt den neuen Wert dem Vector zu und sortiert die Liste.
   * Danach muss die View-Komponente �ber die �nderung der Daten
   * informiert werden --> siehe dazu die API von DefaultListModel
   */
  public void addElement(String value){
    data.add(value);
    Collections.sort(data);
    this.fireIntervalAdded(this,0, data.size());
    
  }
}
