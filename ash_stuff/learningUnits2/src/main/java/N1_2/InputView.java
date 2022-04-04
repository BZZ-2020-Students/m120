package N1_2;

import javax.swing.*;

public class InputView extends JFrame {
    private JTextField inputField;
    private JTextArea info;
    private IntegerModel model;


    public InputView(IntegerModel m) {
        model = m;
        init();

    }

    public String getText() {
        String s = inputField.getText();
        inputField.setText("");
        return s;
    }

    private void init() {
        info = new JTextArea(3,35);
        info.setEditable(false);
        info.setLineWrap(true);
        inputField = new JTextField(10);
        info.setText("Geben Sie hier eine Zahl ein. Sie wird in den Ausgabefenstern \n in Hex, Bin und Dec ausgegeben. \n Bestätigen Sie die Eingabe mit ENTER");

        JPanel panel = new JPanel();
        panel.add(inputField);
        panel.add(info);
        add(panel);
        pack();
        setVisible(true);
        inputField.addKeyListener(new InputController(this, model));
    }
}
