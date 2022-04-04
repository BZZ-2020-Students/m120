package N1_2;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputController extends KeyAdapter {
   private InputView view;
    private IntegerModel model;

    public InputController(InputView v, IntegerModel m) {
        this.view = v;
        this.model = m;
    }

    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            String s = view.getText();
            try {
                model.setValue(Integer.parseInt(s));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Invalid number", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

}
