package n1_2;

import javax.swing.*;

public class InputView extends JFrame{
    private JTextField inputField = new JTextField();
    private JTextArea info = new JTextArea();
    private IntegerModel model;

    public InputView(IntegerModel m){
        model = m;
        init();
        new InputController(this,model);
    }

    public String getText(){
        return inputField.getText();
    }

    private void init(){

    }
}
