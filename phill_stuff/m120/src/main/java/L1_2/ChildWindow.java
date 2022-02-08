package L1_2;

import javax.swing.*;
import java.awt.*;

public class ChildWindow extends JDialog {
    private JLabel info;
    private JTextArea parentinfo;

    public ChildWindow(JFrame parent){
        super(parent, "Modales Fenster", true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        info = new JLabel("Ein modales Fenster");
        parentinfo = new JTextArea(parent.toString());
        parentinfo.setLineWrap(true);
        getContentPane().add(info, BorderLayout.NORTH);
        getContentPane().add(parentinfo, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
}
