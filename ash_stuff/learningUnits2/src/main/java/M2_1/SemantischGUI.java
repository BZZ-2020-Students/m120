package M2_1;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SemantischGUI extends JFrame {
    JPanel topPanel = new JPanel(new BorderLayout());
    JPanel bottomPanel = new JPanel(new BorderLayout());

    JLabel topLabel = new JLabel("JLabel");
    JTextField topTextField = new JTextField("JTextField");
    JTextArea centerText = new JTextArea(5, 20);
    private final String[] list = {"a", "b", "c", "d"};
    JList<String> centerList = new JList<>(list);
    JButton bottomRightBtn = new JButton("JButton1");
    JButton bottomLeftBtn = new JButton("JButton2");

    public SemantischGUI(){
        super("M2_1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        topTextField.addFocusListener(new focusText());
        centerList.addListSelectionListener(new listListener());

        topPanel.add(topLabel, BorderLayout.WEST);
        topPanel.add(topTextField, BorderLayout.EAST);
        bottomPanel.add(bottomLeftBtn, BorderLayout.WEST);
        bottomPanel.add(bottomRightBtn, BorderLayout.EAST);
        setLayout(new BorderLayout());

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        getContentPane().add(centerText, BorderLayout.CENTER);
        getContentPane().add(centerList, BorderLayout.EAST);



        pack();
        setVisible(true);
    }

    public class focusText implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            System.out.println(topTextField.getText());
        }

        @Override
        public void focusLost(FocusEvent e) {
            System.out.println("Focus Lost!");
        }
    }

    public class listListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println(centerList.getSelectedIndex());
        }
    }

    public static void main(String[] args) {
        new SemantischGUI();
    }
}
