package L1_2;

import javax.swing.*;
import java.awt.*;

public class ChildWindow extends JDialog {
    JLabel info = new JLabel("ein modales Fenster");
    JTextArea parentInfo = new JTextArea(5, 50);

    ChildWindow(JFrame parent){
        super(parent, "Modales Fenster", true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        parentInfo.setLineWrap(true);
        parentInfo.setText(parent.toString());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(info, BorderLayout.NORTH);
        getContentPane().add(parentInfo, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }
}
