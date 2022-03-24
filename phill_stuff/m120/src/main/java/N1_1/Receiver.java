package N1_1;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Receiver extends JFrame implements Observer{
    private JPanel bpanel;
    private JPanel spanel;
    private TextArea text;
    private JButton anmeldebutton;
    private JButton abmeldebutton;

    public Receiver(Transmitter trm){
        super("Empfänger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        text = new TextArea("Text");
        add(text, BorderLayout.NORTH);

        bpanel = new JPanel(new GridLayout(1,2));
        spanel = new JPanel(new BorderLayout());


        anmeldebutton = new JButton("Anmelden");
        abmeldebutton = new JButton("Abmelden");
        anmeldebutton.addActionListener(e -> {
            trm.addObserver(this);
            anmeldebutton.setEnabled(false);
            abmeldebutton.setEnabled(true);
        });

        abmeldebutton.addActionListener(e -> {
            trm.deleteObserver(this);
            anmeldebutton.setEnabled(true);
            abmeldebutton.setEnabled(false);
                }
        );
        bpanel.add(anmeldebutton);
        bpanel.add(abmeldebutton);
        spanel.add(bpanel,BorderLayout.EAST);
        add(text, BorderLayout.CENTER);
        add(spanel, BorderLayout.SOUTH);

        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        Transmitter trm = new Transmitter();
        Receiver receiver = new Receiver(trm);
    }

    @Override
    public void update(Observable o, Object object) {
        String message = text.getText() + "\n" + object;

        text.setText(message);
    }
}
