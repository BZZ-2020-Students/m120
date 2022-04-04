package n3_1;

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.Vector;

public class Model extends AbstractTableModel implements Serializable {
    @Serial
    private static final long serialVersionUID = -7020155788714133491L;
    private final Vector<DataClass> data;
    private final String[] title = {"Hobby"};

    public Model() {
        Vector<DataClass> tempData = new Vector<>();
        try (FileInputStream fis = new FileInputStream("model3_1.dat")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            tempData = (Vector<DataClass>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            tempData.add(new DataClass("Skifahren"));
            tempData.add(new DataClass("Schwimmen"));
            tempData.add(new DataClass("Fussball"));
            tempData.add(new DataClass("Segeln"));
            tempData.add(new DataClass("Cart Rennen"));
            tempData.add(new DataClass("Volleyball"));
            tempData.add(new DataClass("Biken"));
        }

        data = tempData;
        data.sort(null);
    }

    public Vector<DataClass> getData() {
        return data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return title.length;
    }

    @Override
    public String getColumnName(int column) {
        return title[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DataClass dataClass = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return dataClass.getName();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex > 0;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        DataClass dc = data.get(rowIndex);
        switch (columnIndex) {
            case 0 -> dc.setName((String) aValue);
        }
        this.fireTableDataChanged();
    }

    public void addRow(DataClass obj) {
        data.add(obj);
        data.sort(null);
        this.fireTableDataChanged();
    }
}
