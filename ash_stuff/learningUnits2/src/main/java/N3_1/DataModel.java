package N3_1;
/**
 * Die Klasse DataModel stellt eine Menge von Obejkten einer Datenklasse (hier DataClass) bereit.
 * Die Objekte sind typischwerweise in einer Collection abgelegt.
 * <p>
 * F�r die Ausgabe werden die Werte der Daten-Objekte so aufbereitet, dass �ber den MVC-Mecano von Swing
 * eine JTable bedient wird.
 * Dazu muss diese Klasse das Interface TableModel implementieren. Das wird garantiert, in dem von
 * DefaultTableModel (Komfortklasse) geerbt wird.
 * Um die Tabelle zu beschriften, werden in einem String-Array die �berschriften festgehalten.
 *
 * @author Ren� Probst
 */

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class DataModel extends AbstractTableModel {

    // Hier die ben�tigten Attribute festlegen
    private Vector<DataClass> dataVector = new Vector<>();
    private String[] title;

    //Konstruktor
    public DataModel() {
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    // Ab hier implementieren Sie bitte ALLE n�tigen Schnittstellenfunktionen f�r das Datenmodell!
    public int getColumnCount() {
        return 0;
    }

    public String getColumnName(int column){
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    // und hier f�gen Sie eine weitere Methode zu, die ein neues Objekt
    // der Klasse DataClass dem Vector zuf�gt und in der Tabelle zur
    // Anzeige bringt.

    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }

    public void setValue(Object aValue, int rowIndex, int columnIndex){

    }

    public void addRow(DataClass obj){

    }

}
