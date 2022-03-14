package lb01_120_jerebic_phillip;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class Pruefungsframe extends JFrame {


    private JButton lbutton, rbutton;
    private JLabel label;
    private JTextField txtfield;
    private JTextArea txtarea;
    private JList<String> list;
    private final String[]  listdata = {"1", "2", "3", "4"};


    public Pruefungsframe(){
        super("Prüfungsframe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        init();
        //
        this.setSize(500,300);
        this.setVisible(true);
    }
    JRadioButton r1=new JRadioButton("A) Male");
    JRadioButton r2=new JRadioButton("B) Female");

    private void init(){
        JPanel btnPanel = new JPanel(new BorderLayout());
        JPanel upperpanel = new JPanel(new BorderLayout());
        this.getContentPane().setLayout(new BorderLayout());
        lbutton   = new JButton("toggle color");
        rbutton   = new JButton("mouse over color");
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

        rbutton.setBackground(Color.LIGHT_GRAY);
        rbutton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                rbutton.setBackground(Color.WHITE);
            }
            public void mouseExited(MouseEvent e){
                rbutton.setBackground(Color.LIGHT_GRAY);
            }
        });

        txtfield.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    txtarea.append(txtfield.getText()+"\n");
                    txtfield.setText("");
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

        JScrollPane txtareascrollpn = new JScrollPane(txtarea);

        btnPanel.add(lbutton,BorderLayout.WEST);
        btnPanel.add(rbutton,BorderLayout.EAST);

        upperpanel.add(label,BorderLayout.WEST);
        upperpanel.add(txtfield,BorderLayout.EAST);

        this.getContentPane().add(btnPanel,BorderLayout.SOUTH);
        this.getContentPane().add(upperpanel,BorderLayout.NORTH);
        this.getContentPane().add(txtareascrollpn,BorderLayout.CENTER);
        this.getContentPane().add(list,BorderLayout.EAST);
    }

    public static void main(String[] args) {
        new Pruefungsframe();
    }
}
