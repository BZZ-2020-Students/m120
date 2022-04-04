package N3_1;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ColorTable extends DefaultTableCellRenderer {

    private static final Color STRIPE = new Color(0.929f, 0.953f, 0.996f);
    private static final Color WHITE = UIManager.getColor("Table.background");


    public ColorTable() {
        setOpaque(true); //MUST do this for background to show up.
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent c = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (!isSelected) {
            if (row % 2 == 0) {
                c.setBackground(WHITE);
            } else {
                c.setBackground(STRIPE);
            }
        }

        return c;
    }
}
