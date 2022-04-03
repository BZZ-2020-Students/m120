package aNeinszwei;

import javax.swing.*;
import java.awt.*;

public class InputView extends JFrame {

    private JTextField inputField;
    private JFrame theWindow;
    private IntegerModel model;

    public InputView(IntegerModel m){
        super("Werteingabe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,120);
        model = m;
        init();
        setVisible(true);
        inputField.requestFocusInWindow();
    }

    public String getText(){
        String str = inputField.getText();
        inputField.setText("");
        return str;
    }

    public void init(){
        JTextArea info = new JTextArea(3,30);

        info.setEditable(false); //nicht editierbar
        info.setLineWrap(true); //auto Zeilenumbruch wenn der Text zulang ist
        info.setText("Geben Sie hier eine Zahl ein. Sie wird in den Ausgabefenstern \n in Hex, Bin und Dec ausgegeben.\n Bestaetigen Sie die Eingabe mit ENTER");

        this.getContentPane().add(info, BorderLayout.NORTH);
        inputField = new JTextField(19); // "Länge"

        JPanel jp = new JPanel(new BorderLayout());
        jp.add(inputField, BorderLayout.SOUTH);
        this.getContentPane().add(jp, BorderLayout.EAST);

        inputField.addKeyListener(new InputController (this, model)); // Zuordnung von InputController als KeyListener zu, inputField

    }


}
