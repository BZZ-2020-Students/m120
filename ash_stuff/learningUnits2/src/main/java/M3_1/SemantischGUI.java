package M3_1;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class SemantischGUI extends JFrame {
    JPanel topPanel = new JPanel(new BorderLayout());
    JPanel bottomPanel = new JPanel(new BorderLayout());

    JLabel topLabel = new JLabel("JLabel");
    JTextField topTextField = new JTextField("JTextField");
    JTextArea centerText = new JTextArea(5, 20);
    JScrollPane areaScrollPane = new JScrollPane(centerText);
    private final String[] list = {"a", "b", "c", "d"};
    JList<String> centerList = new JList<>(list);
    JButton bottomRightBtn = new JButton("mouse over color");
    JButton bottomLeftBtn = new JButton("JButton");

    public SemantischGUI(){
        super("M3_1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        topTextField.addFocusListener(new focusText());
        centerList.addListSelectionListener(new listListener());
        bottomRightBtn.addMouseListener(new mouseListener());
        topTextField.addKeyListener(new enterKeyListener());

        topPanel.add(topLabel, BorderLayout.WEST);
        topPanel.add(topTextField, BorderLayout.EAST);
        bottomPanel.add(bottomLeftBtn, BorderLayout.WEST);
        bottomPanel.add(bottomRightBtn, BorderLayout.EAST);
        setLayout(new BorderLayout());

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        getContentPane().add(areaScrollPane, BorderLayout.CENTER);
        getContentPane().add(centerList, BorderLayout.EAST);



        pack();
        setVisible(true);
    }

    public class focusText implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("Focus gained!");
        }

        @Override
        public void focusLost(FocusEvent e) {
            System.out.println("Focus lost!");
        }
    }

    public class listListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println(centerList.getSelectedIndex());
        }
    }

    public class mouseListener extends MouseAdapter {
        public void mouseEntered(MouseEvent e){
            bottomRightBtn.setBackground(Color.WHITE);
        }
        public void mouseExited(MouseEvent e){
            bottomRightBtn.setBackground(bottomLeftBtn.getBackground());
        }
    }

    public class enterKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyChar());
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                centerText.append(topTextField.getText()+"\n");
                topTextField.setText("");
            }
        }

    }
    public static void main(String[] args) {
        new SemantischGUI();
    }
}
