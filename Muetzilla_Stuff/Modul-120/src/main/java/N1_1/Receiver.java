package N1_1;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Receiver extends JFrame implements Observer {
    public static int recNumber = 1;
    private JTextArea receiverArea;
    private JButton subscribeButton;
    private JButton unsubscribeButton;

    public Receiver(Transmitter trans) {
        super("Empfaenger " + recNumber);
        recNumber++;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        receiverArea = new JTextArea();
        receiverArea.setEditable(false);
        add(receiverArea, BorderLayout.CENTER);


        subscribeButton = new JButton("Anmelden");
        unsubscribeButton = new JButton("Abmelden");
        unsubscribeButton.setEnabled(false);
        subscribeButton.addActionListener(e -> {
            trans.addObserver(this);
            subscribeButton.setEnabled(false);
            unsubscribeButton.setEnabled(true);
        });

        unsubscribeButton.addActionListener(e -> {
                    trans.deleteObserver(this);
                    subscribeButton.setEnabled(true);
                    unsubscribeButton.setEnabled(false);
                }
        );
        JPanel southpanel = new JPanel();
        southpanel.setLayout(new GridLayout(0,2));

        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new BorderLayout());

        southpanel.add(subscribeButton);
        southpanel.add(unsubscribeButton);

        outerPanel.add(southpanel, BorderLayout.EAST);

        add(outerPanel, BorderLayout.SOUTH);

        setSize(400, 400);
        setVisible(true);
    }


    @Override
    public void update(Observable o, Object arg) {
        String message = (String) arg;
        receiverArea.append("\n" + message);
    }

}
