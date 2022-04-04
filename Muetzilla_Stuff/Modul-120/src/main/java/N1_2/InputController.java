package N1_2;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputController extends KeyAdapter {
    private InputView view;
    private IntegerModel model;

    public InputController(InputView v, IntegerModel m){
        view = v;
        model = m;
    }

    public void keyTyped(KeyEvent ke){
        if (ke.getKeyChar() == KeyEvent.VK_ENTER){
            String s = view.getText();
            try{
                model.setValue(Integer.valueOf(s).intValue());
            }
            catch(NumberFormatException nf){
                JOptionPane.showMessageDialog(view, "Bitte geben Sie eine korrekte Zahl ein!", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
