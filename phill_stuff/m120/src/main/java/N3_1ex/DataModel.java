package N3_1ex; /**
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
import java.io.Serializable;
import java.util.*;

import javax.swing.table.*;

public class DataModel extends AbstractTableModel implements Serializable {


    // Hier die benötigten Attribute festlegen
    protected Vector<DataClass> dataVector;
    private String[] title = {"Hersteller", "Hubraum", "Leistung"};
  
  //Konstruktor

    public DataModel() {
        dataVector = new Vector<DataClass>();

        dataVector.add(new DataClass("VW", 2.4f, 155));
        dataVector.add(new DataClass("Opel", 1.3f, 90));
        dataVector.add(new DataClass("Toyota", 2.0f, 130));
        dataVector.add(new DataClass("Fiat", 1.2f, 75));
    }

    // Ab hier implementieren Sie bitte ALLE nötigen Schnittstellenfunktionen für das Datenmodell!

    @Override
    public int getColumnCount() {
        return title.length;
    }

    @Override
    public int getRowCount() {
        return dataVector.size();
    }

    @Override
    public String getColumnName(int column) {
        return title[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DataClass dc = dataVector.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return dc.getHersteller();
            case 1:
                return dc.getHubraum();
            case 2:
                return dc.getLeistung();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex ){
        if (columnIndex > 0)
            return true;
        else
            return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        DataClass dc = dataVector.get(rowIndex);
        switch(columnIndex){
            case 0: dc.setHersteller((String) aValue); break;
            case 1: dc.setHubraum(new Float((String) aValue).floatValue()); break;
            case 2: dc.setLeistung(new Integer((String) aValue).intValue()); break;
        }
        this.fireTableDataChanged();
    }

    // und hier fügen Sie eine weitere Methdoe zu, die ein neues Objekt
  // der Klasse DataClass dem Vector zufügt und in der Tabelle zur
  // Anzeige bringt.
    public void addRow(DataClass obj){
        dataVector.add(obj);
        this.fireTableDataChanged();
    }
   

}
