package N1_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class Transmitter extends Observable{

    private JFrame theWindow;
    private JTextField theMessage;
    private JButton btnSend;

    public Transmitter(){
        theWindow = new JFrame("Transmitter");
        theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        theWindow.pack();
        theWindow.setVisible(true);
    }

    private void init(){
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Meldung: "), BorderLayout.WEST);
        theMessage = new JTextField (50);
        inputPanel.add(theMessage, BorderLayout.EAST);
        JPanel btnPanel = new JPanel(new BorderLayout());
        btnSend = new JButton("Senden");
        btnPanel.add(btnSend, BorderLayout.EAST);
        theWindow.getContentPane().add(inputPanel, BorderLayout.CENTER);
        theWindow.getContentPane().add(btnPanel, BorderLayout.SOUTH);
        btnSend.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                doSend();
            }
        });
    }

    private void doSend(){
        String message = theMessage.getText();
        setChanged();
        notifyObservers(message);
        theMessage.setText("");
    }
}
