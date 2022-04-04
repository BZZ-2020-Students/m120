package N3_1; /**
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
    // Hier die benötigten Attribute festlegen
    private Vector<DataClass> dataVector;
    private String[] title;
    // Konstruktor
    public DataModel(Vector<DataClass> data){
        this.dataVector = data;
    }


    // Ab hier implementieren Sie bitte ALLE nötigen Schnittstellenfunktionen für das Datenmodell!


    // und hier fügen Sie eine weitere Methdoe zu, die ein neues Objekt
    // der Klasse DataClass dem Vector zufügt und in der Tabelle zur
    // Anzeige bringt.
    public void addRow(DataClass obj){
        dataVector.add(obj);
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var obj = dataVector.get(rowIndex);

        switch (columnIndex) {
            case 0 -> obj.setHersteller((String) aValue);
            case 1 -> obj.setHubraum((Float) aValue);
            case 2 -> obj.setLeistung((Integer) aValue);

            default -> throw new IllegalArgumentException("Illegal Column Index : " + columnIndex);
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Hersteller";
            case 1 -> "Hubraum";
            case 2 -> "Leistung";

            default -> throw new IllegalArgumentException("Illegal Column Index : " + column);
        };
    }

    @Override
    public int getRowCount() {
        return dataVector.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var obj = dataVector.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> obj.getHersteller();
            case 1 -> obj.getHubraum();
            case 2 -> obj.getLeistung();

            default -> throw new IllegalArgumentException("Illegal Column Index : " + columnIndex);
        };
    }


   

}
