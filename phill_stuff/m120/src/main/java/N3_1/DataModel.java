package N3_1; /**
 * Die Klasse DataModel stellt eine Menge von Obejkten einer Datenklasse (hier DataClass) bereit.
 * Die Objekte sind typischwerweise in einer Collection abgelegt.
 * 
 * F�r die Ausgabe werden die Werte der Daten-Objekte so aufbereitet, dass �ber den MVC-Mecano von Swing
 * eine JTable bedient wird.
 * Dazu muss diese Klasse das Interface TableModel implementieren. Das wird garantiert, in dem von 
 * DefaultTableModel (Komfortklasse) geerbt wird.
 * Um die Tabelle zu beschriften, werden in einem String-Array die �berschriften festgehalten.
 * 
 * @author Ren� Probst
 *
 */
import java.util.*;

import javax.swing.table.*;

public class DataModel extends AbstractTableModel{
    // Hier die ben�tigten Attribute festlegen
    private Vector<DataClass> dataVector;
    private String[] title;
    // Konstruktor
    public DataModel(){
        DataClass dataclass = new DataClass();

    }
    // Ab hier implementieren Sie bitte ALLE n�tigen Schnittstellenfunktionen f�r das Datenmodell!


    // und hier f�gen Sie eine weitere Methdoe zu, die ein neues Objekt
    // der Klasse DataClass dem Vector zuf�gt und in der Tabelle zur
    // Anzeige bringt.
    public void addRow(DataClass obj){
        dataVector.add(obj);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return super.isCellEditable(rowIndex, columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column);
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


   

}
