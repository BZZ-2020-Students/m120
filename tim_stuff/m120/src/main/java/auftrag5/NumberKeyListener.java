package auftrag5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberKeyListener implements ActionListener {
    private final JTextField display;

    public NumberKeyListener(JTextField display) {
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ziffer = e.getActionCommand();
        display.setText(display.getText() + ziffer);
    }
}
