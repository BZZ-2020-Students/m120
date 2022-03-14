package M2_1;

import L1_1.JavaGUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class M2_1Demo extends JFrame {
    private JButton aButton;
    private JLabel aLable;
    private JTextField aTextField;
    private JTextArea aTextArea;
    private JList<String>  aList;
    private JButton buttonOne;
    private JButton buttonTwo;

    private String[]       data = {"First", "Sescond", "Third", "Fourth"};

    public M2_1Demo(){
        super("JavaGUI Exit on close");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponent();
        pack();
        setVisible(true);
    }


        private void initComponent(){
            // TOP Panel mit Lable und Textfeld
            JPanel topPanel = new JPanel(new BorderLayout(20,20));
            aLable     = new JLabel("ein Lable");
            aTextField = new JTextField(20);
            topPanel.add(aLable, BorderLayout.WEST);
            topPanel.add(aTextField, BorderLayout.EAST);
            getContentPane().add(topPanel, BorderLayout.NORTH);
            // MID Panel mit Textarea und Liste
            aTextArea = new JTextArea(5, 20);
            aList     = new JList<String>(data);
            getContentPane().add(aTextArea, BorderLayout.CENTER);
            getContentPane().add(aList, BorderLayout.EAST);
            // BOTTOM Panel mit 2 Schaltflächen
            JPanel bottomPanel = new JPanel(new BorderLayout(20, 20));
            buttonOne = new JButton("toggle color");
            buttonTwo = new JButton("mouse over color");
            bottomPanel.add(buttonOne, BorderLayout.WEST);
            bottomPanel.add(buttonTwo, BorderLayout.EAST);
            getContentPane().add(bottomPanel, BorderLayout.SOUTH);
            buttonOne.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(buttonOne.getForeground().equals(Color.green)){
                        buttonOne.setForeground(Color.cyan);
                    }else{
                        buttonOne.setForeground(Color.green);
                    }
                }
            });
            aTextField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    System.out.println(aTextField.getText());
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });
            aList.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    System.out.println(aList.getSelectedValue());
                }
            });
    }

    public static void main(String[] args){
        new M2_1Demo();
    }
}
