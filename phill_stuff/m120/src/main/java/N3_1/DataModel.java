package N3_1;

import java.util.*;

import javax.swing.table.*;

public class DataModel extends AbstractTableModel{
    private final List<DataClass> dataClasses;

    public DataModel(ArrayList<DataClass> dataClasses) {
        this.dataClasses = dataClasses;
    }

    @Override
    public int getRowCount() {
        return dataClasses.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DataClass dataClass = dataClasses.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> dataClass.getHersteller();
            case 1 -> dataClass.getHubraum();
            case 2 -> dataClass.getLeistung();

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
        DataClass dataClass = dataClasses.get(row);

        switch (col) {
            case 0 -> dataClass.setHersteller((String) value);
            case 1 -> dataClass.setHubraum((Float) value);
            case 2 -> dataClass.setLeistung((Integer) value);

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

    public void addElement(DataClass e) {
        dataClasses.add(e);
        fireTableDataChanged();
    }

}
