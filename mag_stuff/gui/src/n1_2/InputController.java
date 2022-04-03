package n1_2;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputController extends KeyAdapter {
    private InputView view;
    private IntegerModel model;

    public InputController(InputView i, IntegerModel m) {
        view = i;
        model = m;
    }

    @Override
    public void keyTyped(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_ENTER)
            try {
                String strVal = view.getText();
                model.setValue(Integer.parseInt(strVal));
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(view, "Bitte geben Sie eine korrekte Zahl ein!", "FEHLER", JOptionPane.ERROR_MESSAGE);
            }
    }
}
