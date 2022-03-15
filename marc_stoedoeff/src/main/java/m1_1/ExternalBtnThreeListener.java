package m1_1;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExternalBtnThreeListener implements java.awt.event.ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(((JButton) e.getSource()).getText());
    }
}
