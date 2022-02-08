package aufgabe3;

import java.awt.*;
import javax.swing.*;

/**********************************************************
*
*  This class implements a simple phone GUI.
*  When creating a new object of this class
*  the GUI components, such as buttons, labels, etc. are
*  just displayed. They do not yet react on user actions,
*  such as pressing a button, etc.
*
* @author  H. Diethelm, HTA Luzern
* @version 1.0  12-06-2000
* @version 2.0  01-02-2007 (R. Probst) change to swing
* @version 2.1  17-02-2016 (R. Probst) kleinere Anpassungen
* 
**********************************************************/
public class JavaPhoneGUI extends JFrame {
  private final JButton[] inputButtons = {new JButton("1"), new JButton("2"), new JButton("3"), new JButton("4"), new JButton("5"), new JButton("6"), new JButton("7"), new JButton("8"), new JButton("9"), new JButton("#"), new JButton("0"), new JButton("*")};
    JButton hookButton = new JButton("Hook up");
    JTextField display = new JTextField("");
    JLabel status = new JLabel("ready");
    JPanel keyPanel = new JPanel();
    JPanel keyDisplayPanel = new JPanel();
    JPanel hookPanel = new JPanel();

  JavaPhoneGUI() {

    setTitle("JavaPhone");
    setBackground(Color.lightGray);
    setResizable(false);

    display.setEditable(false);

    getContentPane().setLayout(new BorderLayout(20, 20));
    keyPanel.setLayout(new GridLayout(0, 3, 20, 20));

   for(JButton jb : inputButtons){
     keyPanel.add(jb);
   }


      keyDisplayPanel.setLayout(new BorderLayout());
      keyDisplayPanel.add(display, BorderLayout.NORTH);
      keyDisplayPanel.add(keyPanel, BorderLayout.CENTER);
      status.setForeground(Color.GREEN);
      hookPanel.setLayout(new BorderLayout());
      hookPanel.add(status,BorderLayout.NORTH);
      hookPanel.add(hookButton,BorderLayout.CENTER);


    getContentPane().add(keyDisplayPanel, BorderLayout.CENTER);
    getContentPane().add(hookPanel, BorderLayout.WEST);

    setVisible(true);
  }
}