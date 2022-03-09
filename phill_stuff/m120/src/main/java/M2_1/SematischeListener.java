package M2_1;

import M1_1.ListenerDemo;
import M1_1.NewListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SematischeListener extends JFrame {

    /**
     *
     */
    private JButton lbutton, rbutton;
    private JLabel label;
    private JTextField txtfield;
    private JTextArea txtarea;
    private JList<String> list;
    private String[]  listdata = {"1", "2", "3", "4"};


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
        JPanel btnPanel = new JPanel(new BorderLayout());
        JPanel upperpanel = new JPanel(new BorderLayout());
        this.getContentPane().setLayout(new BorderLayout());
        lbutton   = new JButton("toggle color");
        rbutton   = new JButton("RButton");
        txtfield = new JTextField();
        label = new JLabel("label");
        list = new JList<String>(listdata);
        txtarea = new JTextArea();

        lbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if (lbutton.getBackground() == Color.GREEN){
//                    System.out.println("change to cyan");
                    lbutton.setBackground(Color.CYAN);
                }else {
                    lbutton.setBackground(Color.GREEN);
//                    System.out.println("change to green");
                }

            }
        });

        txtfield.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("Testfield Focused");
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("Testfield UnFocused");
            }
        });

        list.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                System.out.println(list.getSelectedIndex());
            }
        });

        btnPanel.add(lbutton,BorderLayout.WEST);
        btnPanel.add(rbutton,BorderLayout.EAST);

        upperpanel.add(label,BorderLayout.WEST);
        upperpanel.add(txtfield,BorderLayout.EAST);

        this.getContentPane().add(btnPanel,BorderLayout.SOUTH);
        this.getContentPane().add(upperpanel,BorderLayout.NORTH);
        this.getContentPane().add(txtarea,BorderLayout.CENTER);
        this.getContentPane().add(list,BorderLayout.EAST);
    }

    public static void main(String[] args) {
        new SematischeListener();
    }
}
