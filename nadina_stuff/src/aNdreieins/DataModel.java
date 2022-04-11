package aNdreieins; /**
 * Die Klasse DataModel stellt eine Menge von Obejkten einer Datenklasse (hier DataClass) bereit.
 * Die Objekte sind typischwerweise in einer Collection abgelegt.
 * 
 * Für die Ausgabe werden die Werte der Daten-Objekte so aufbereitet, dass über den MVC-Mecano von Swing
 * eine JTable bedient wird.
 * Dazu muss diese Klasse das Interface TableModel implementieren. Das wird garantiert, in dem von 
 * DefaultTableModel (Komfortklasse) geerbt wird.
 * Um die Tabelle zu beschriften, werden in einem String-Array die Überschriften festgehalten.
 * 
 * @author René Probst
 *
 */
import java.util.*;

import javax.swing.table.*;

public class DataModel extends AbstractTableModel{
    // Attribute
    private Vector<DataClass> dataVector;
    private String[] title;

    //Konstruktor
    public DataModel(Vector<DataClass> data){
        this.dataVector = data;
    }

    public DataModel() {

    }

    public void addRow(DataClass obj){
        dataVector.add(obj);
        fireTableDataChanged();
    }


    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    // Hier die benötigten Attribute festlegen
  
  //Konstruktor 
  
  // Ab hier implementieren Sie bitte ALLE nötigen Schnittstellenfunktionen für das Datenmodell!
  
  
  // und hier fügen Sie eine weitere Methdoe zu, die ein neues Objekt 
  // der Klasse DataClass dem Vector zufügt und in der Tabelle zur
  // Anzeige bringt.

   

}
