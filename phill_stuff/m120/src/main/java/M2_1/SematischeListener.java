package M2_1;

import M1_1.ListenerDemo;
import M1_1.NewListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SematischeListener extends JFrame {

    /**
     *
     */
    private JButton lbutton, rbutton;
    private String actionBtnThree = "Schaltfläche 3";

    public SematischeListener(){
        super("Beispiele für Sematische Listner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        init();
        //
        this.pack();
        this.setVisible(true);
    }

    private void init(){
        JPanel btnPanel = new JPanel(new GridLayout(3,1));
        btnOne   = new JButton("Schatlfläche 1");
        btnTwo   = new JButton("Schaltfläche 2");
        btnThree = new JButton(actionBtnThree);
        //
        btnPanel.add(btnOne);
        btnPanel.add(btnTwo);
        btnPanel.add(btnThree);
        this.getContentPane().add(btnPanel, BorderLayout.CENTER);
        //
        /*
         * Listener 1
         * Ist als externe Klasse zu erstellen und der Schaltfläche btnOne zuzuordnen.
         * Es ist der Text der Beschriftung im StdOut auszugeben.
         *
         */


    }
}
