import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class JavaListener extends JFrame{
 
  private JLabel         aLable;
  private JTextField     aTextField;
  private JTextArea      aTextArea;
  private JList<String>  aList;
  private JButton        buttonOne, buttonTwo;
       
  private String[]       data = {"one", "two", "three", "four"};
       
       
  public JavaListener(){
    
    super("Beispiele von Listener");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //
    initComponent();
    addListeners();
    //
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
  }
       
  private void addListeners(){
    // Schaltfläche mit ActionListener
    buttonOne.setBackground(Color.cyan);
    buttonOne.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        onClick();
      }
    });
    //
    aTextField.addFocusListener(new FocusListener(){
      public void focusGained(FocusEvent e){
        onFocusGained();
      }
      public void focusLost(FocusEvent e){
        onFocusLost();
      }
    });
    //
    aList.addListSelectionListener(new ListSelectionListener(){
      public void valueChanged(ListSelectionEvent e){
        onListSelection();
      }
    });
  }
      
  
    // Handler zu Action
  private void onClick(){
    if (buttonOne.getBackground() == Color.cyan)
      buttonOne.setBackground(Color.green);
    else
    buttonOne.setBackground(Color.cyan);  
  }
  
    // Handler zu Fokus
  private void onFocusGained(){
    System.out.println("Fokus auf Textfeld");
  }
    
  private void onFocusLost(){
    System.out.println("Fokus von Textfeld entfernt");
  }
  
  //Handler zu ListSelection
  private void onListSelection(){
    System.out.println(aList.getSelectedIndex());
  }
  
    
  public static void main(String[] args){
    new JavaListener(); 
  }
}