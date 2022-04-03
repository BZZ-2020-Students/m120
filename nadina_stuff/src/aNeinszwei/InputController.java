package aNeinszwei;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class InputController extends KeyAdapter {

    private InputView view;
    private IntegerModel model;

    public  InputController(InputView v, IntegerModel m){
        view = v;
        model = m;
    }
        @Override
        public void keyTyped (KeyEvent event){
        if(event.getKeyCode() == KeyEvent.VK_ENTER)
        try {
            String srtVal = view.getText();
            model.setValue(Integer.parseInt(srtVal));
        }catch(Exception e)
            {
                JOptionPane.showMessageDialog(view, "Error");
            }
        }
}
