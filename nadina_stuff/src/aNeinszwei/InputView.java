package aNeinszwei;

import javax.swing.*;

public class InputView extends JFrame {

    private JTextField inputField;
    private JTextArea info;
    private IntegerModel model;

    public InputView(IntegerModel m){
        model = m;
        init();
        new InputController(this, model);
    }

    public String getText(){
        return inputField.getText();
    }

    public void init(){

    }


}
