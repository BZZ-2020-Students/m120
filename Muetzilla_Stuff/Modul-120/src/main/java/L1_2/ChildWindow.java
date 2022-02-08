package L1_2;

import javax.swing.*;
import java.awt.*;

public class ChildWindow extends JDialog {
    private JLabel info =  new JLabel("Ein modales Fenster");
    private JTextArea parentInfo = new JTextArea(5,50);
    public ChildWindow(JFrame parent){
        setModal(true);
        this.getContentPane().setLayout(new BorderLayout());
        add(info, BorderLayout.NORTH);
        parentInfo.setText(parent.toString());
        parentInfo.setEditable(false);
        parentInfo.setLineWrap(true);
        add(parentInfo, BorderLayout.NORTH);
    }
}
