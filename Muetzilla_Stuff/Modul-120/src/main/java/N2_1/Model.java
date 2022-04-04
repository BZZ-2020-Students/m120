package N2_1;

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
  
  public Model(Vector<String> hobbys){
    this.data = hobbys;
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
    fireIntervalAdded(this,0,data.size());
  }

  public Vector<String> getData() {
    return data;
  }

}
