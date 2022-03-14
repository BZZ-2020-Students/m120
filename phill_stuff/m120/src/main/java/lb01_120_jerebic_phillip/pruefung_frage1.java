package lb01_120_jerebic_phillip;

import javax.swing.*;
import java.awt.*;

public class pruefung_frage1 extends JFrame {

    private JButton enterbutton, abortbutton;
    private JTextField textfield;
    private JPanel buttonpanel;

    public pruefung_frage1() {
        super("Test z...");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        init();
        //
        this.pack();
        this.setVisible(true);
    }

    private void init() {
        enterbutton = new JButton("Enter");
        abortbutton = new JButton("Abort");
        textfield = new JTextField("Text der ausgegeben wird");
        buttonpanel = new JPanel();
        buttonpanel.setLayout(new GridLayout(1,2));

        buttonpanel.add(enterbutton);
        buttonpanel.add(abortbutton);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(textfield,BorderLayout.NORTH);
        this.getContentPane().add(buttonpanel);
    }

    public static void main(String[] args) {
        new pruefung_frage1();
    }
}
