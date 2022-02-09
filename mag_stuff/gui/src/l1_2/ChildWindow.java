package l1_2;

import javax.swing.*;
import java.awt.*;

public class ChildWindow extends JDialog {
    JLabel info = new JLabel("Ein modales Fenster");
    JTextArea parentInfo = new JTextArea(5,50);

    public ChildWindow(JFrame parent){
        setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        parentInfo.setEditable(false);
        parentInfo.setText(parent.toString());
        parentInfo.setLineWrap(true);
        add(info, BorderLayout.NORTH);
        add(parentInfo, BorderLayout.SOUTH);

    }
}
