package n3_1;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MyTable extends JTable {
    public MyTable(Model model) {
        super(model);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (!c.getBackground().equals(getSelectionBackground())) {
            Color colour = (row % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
            c.setBackground(colour);
        }
        return c;
    }
}
