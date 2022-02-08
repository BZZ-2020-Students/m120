package l1_2;

import javax.swing.*;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

public class ChildWindow extends JDialog {
    public ChildWindow(JFrame parent) {
        super(parent, "Child Window", true);
        JLabel lbl = new JLabel("Ein Modales Fenster");
        add(lbl, NORTH);

        JTextArea ta = new JTextArea(5, 50);
        ta.setLineWrap(true);
        ta.setText(parent.toString());
        add(ta, SOUTH);

        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
