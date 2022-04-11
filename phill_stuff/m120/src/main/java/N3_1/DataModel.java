package N3_1;
/**
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
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class DataModel extends AbstractTableModel {

	// Hier die ben�tigten Attribute festlegen
	protected Vector<DataClass> dataVector;
	private String[] title;

	// Konstruktor
	public DataModel() {
		dataVector = new Vector<>();
		dataVector.add(new DataClass("ABC", 10f, 5));
		dataVector.add(new DataClass("E", 6.10f, 25));
		dataVector.add(new DataClass("sdfeadas", 66.99f, 753));
		title = new String[] { "Herstellter", "Hubraum", "Leistung" };
	}

	// Ab hier implementieren Sie bitte ALLE n�tigen Schnittstellenfunktionen f�r
	// das Datenmodell!
	@Override
	public int getRowCount() {
		return dataVector.size();
	}

	@Override
	public int getColumnCount() {
		return title.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return dataVector.get(rowIndex).getHersteller();
		case 1:
			return dataVector.get(rowIndex).getHubraum();
		case 2:
			return dataVector.get(rowIndex).getLeistung();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return title[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex > 0 ? true : false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			dataVector.get(rowIndex).setHersteller((String) aValue);
			break;
		case 1:
			dataVector.get(rowIndex).setHubraum(Float.parseFloat("" + aValue));
			break;
		case 2:
			dataVector.get(rowIndex).setLeistung(Integer.parseInt("" + aValue));
			break;
		}
	}

	// und hier f�gen Sie eine weitere Methdoe zu, die ein neues Objekt
	// der Klasse DataClass dem Vector zuf�gt und in der Tabelle zur
	// Anzeige bringt.
	public void addRow(DataClass obj) {
		dataVector.add(obj);
		this.fireTableRowsInserted(dataVector.size() - 1, dataVector.size());
	}

}
