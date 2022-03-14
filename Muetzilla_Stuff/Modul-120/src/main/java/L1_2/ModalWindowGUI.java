package L1_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   Diese Klasse dient der Bereitstellung einer Schaltfl�che, um �ber diese
   Aktion ein neues, modales Fenster (einen Dialog) zu �ffnen.
   
   Es soll bewusst nicht die M�glichkeit des JOptionPane genutzt werden!
  */
public class ModalWindowGUI extends JFrame{
  
  private JButton aButton;
  
  public ModalWindowGUI(){
    super("Modales Fenster");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //
    JPanel infoPanel = new JPanel(new BorderLayout());
    JLabel info = new JLabel();
    info.setText("�ber die Schaltfl�che \"Open Window\" wird ein neues modales Fenster ge�ffnet");
    infoPanel.add(info, BorderLayout.NORTH);
    infoPanel.add(new JSeparator(), BorderLayout.SOUTH);
    getContentPane().add(infoPanel, BorderLayout.NORTH);
    //
    JPanel btnPanel = new JPanel(new BorderLayout());
    aButton= new JButton("Open Window");
    btnPanel.add(aButton, BorderLayout.EAST);
    getContentPane().add(btnPanel, BorderLayout.SOUTH);
    //
    aButton.addActionListener(
         new ActionListener(){
             public void actionPerformed(ActionEvent ae){
               onOpenWindow();
             }
         });
    //
    pack();
    setVisible(true);
  }
  
  private void onOpenWindow(){
    System.out.println("Button pressed");
    ChildWindow dialog = new ChildWindow(this);
    dialog.pack();
    dialog.setVisible(true);
  }
  
  public static void main(String[] args){
    new ModalWindowGUI();
  }
}