package n3_1ex; /**
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

public class DataModel extends AbstractTableModel {
    private final List<Engine> engines;

    public DataModel(List<Engine> engines) {
        this.engines = engines;
    }

    @Override
    public int getRowCount() {
        return engines.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var obj = engines.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> obj.getHersteller();
            case 1 -> obj.getHubraum();
            case 2 -> obj.getLeistung();

            default -> throw new IllegalArgumentException("Illegal Column Index : " + columnIndex);
        };
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
    public void setValueAt(Object value, int row, int col) {
        var obj = engines.get(row);

        switch (col) {
            case 0 -> obj.setHersteller((String) value);
            case 1 -> obj.setHubraum((Float) value);
            case 2 -> obj.setLeistung((Integer) value);

            default -> throw new IllegalArgumentException("Illegal Column Index : " + col);
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> String.class;
            case 1 -> Float.class;
            case 2 -> Integer.class;

            default -> throw new IllegalArgumentException("Illegal Column Index : " + columnIndex);
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void addElement(Engine e) {
        engines.add(e);
        fireTableDataChanged();
    }
}
