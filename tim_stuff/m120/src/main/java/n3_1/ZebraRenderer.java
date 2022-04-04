package n3_1;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ZebraRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Zebra-striping
        if (row % 2 == 0) {
            table.setBackground(Color.WHITE);
        } else {
            table.setBackground(Color.LIGHT_GRAY);
        }

        return new JLabel(value.toString());
    }
}
