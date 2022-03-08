package Maufgabe1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerClass implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
