package lb01_120_jerebic_phillip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pruefung_frage2 extends JFrame {

    private JButton enterbutton, abortbutton;
    private JTextField textfield;
    private JPanel buttonpanel;

    public pruefung_frage2() {
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
 
        enterbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.out.println(textfield.getText());
                enterbutton.setEnabled(false);
            }
        });

        abortbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                textfield.setText("");
                enterbutton.setEnabled(true);
            }
        });


        buttonpanel.add(enterbutton);
        buttonpanel.add(abortbutton);



        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(textfield,BorderLayout.NORTH);
        this.getContentPane().add(buttonpanel);
    }

    public static void main(String[] args) {
        new pruefung_frage2();
    }
}

