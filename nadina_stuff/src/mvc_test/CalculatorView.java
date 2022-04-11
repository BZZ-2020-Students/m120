package mvc_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    private JTextField firstNbr = new JTextField(10);
    private JLabel additonLable = new JLabel();
    private JTextField secondNbr = new JTextField(10);
    private JButton calcBtn = new JButton("=");
    private JTextField calcSolution = new JTextField(10);

    private JTextField fNbrn = new JTextField(10);
    private JLabel minusLable = new JLabel();
    private JTextField sNbr = new JTextField(10);
    private JButton calBtn = new JButton("=");
    private JTextField calcSol = new JTextField(10);

    CalculatorView(){
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,200);

        getContentPane().setLayout(new BorderLayout());

        JPanel calPanel = new JPanel();
        calPanel.add(firstNbr);
        calPanel.add(additonLable);
        calPanel.add(secondNbr);
        calPanel.add(calcBtn);
        calPanel.add(calcSolution);

        JPanel minusPanel = new JPanel();
        minusPanel.add(fNbrn);
        minusPanel.add(minusLable);
        minusPanel.add(sNbr);
        minusPanel.add(calBtn);
        minusPanel.add(calcSol);

        getContentPane().add(calPanel, BorderLayout.NORTH);
        getContentPane().add(minusPanel, BorderLayout.CENTER);
    }

    public int getFirstNbr(){
        return Integer.parseInt(firstNbr.getText());
    }

    public int getSecondNbr(){
        return Integer.parseInt(secondNbr.getText());
    }

    public int getCalcSolution(){
        return Integer.parseInt(calcSolution.getText());
    }

    public void setCalcSolution(int solution){
        calcSolution.setText(Integer.toString(solution));
    }

    void addCalculationsListener(ActionListener listenForCalcBtn){
        calcBtn.addActionListener(listenForCalcBtn);
    }
    
    void displayErrorMsg(){
        JOptionPane.showMessageDialog(this, "Schreibe zwei natürliche Zahlen");
    }


}
