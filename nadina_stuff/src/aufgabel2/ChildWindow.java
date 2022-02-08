package aufgabel2;

import javax.swing.*;
import java.awt.*;
// import javax.swing.JDialog;

public class ChildWindow extends JDialog{
    private JLabel info;
    private JTextArea parentInfo;

    public ChildWindow(JFrame parent) {
        super(parent, "Ein modales Fenster", true);

        // Schliessen-Schaltfläche
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // JLabel
        info = new JLabel("Ein modales Fenster");
        getContentPane().add(info, BorderLayout.NORTH);

        parentInfo = new JTextArea(parent.toString());
        getContentPane().add(parentInfo, BorderLayout.SOUTH);
        parentInfo.setLineWrap(true);

        pack();
        setVisible(true);

    }

}
