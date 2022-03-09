package L2_1;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class LayoutTest extends JFrame {

    private JButton button;
    private JTextArea txtarea;
    private JTextField txtfield;
    private JLabel label;

    public LayoutTest(String layout){
        super("Java GUI L1-1");

        String txtaretext = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum\n" +
                "numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium";

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new JButton("I'm a button");
        txtarea = new JTextArea(txtaretext);
        txtarea.setLineWrap(true);
        txtfield = new JTextField("I'm a textfield");
        label = new JLabel("I'm a label");



        if (layout.equalsIgnoreCase("b")){
            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(button,BorderLayout.SOUTH);
            getContentPane().add(txtarea,BorderLayout.CENTER);
            getContentPane().add(label,BorderLayout.WEST);
            getContentPane().add(txtfield,BorderLayout.NORTH);

        }else if (layout.equalsIgnoreCase("f")){
            getContentPane().setLayout(new FlowLayout());
            getContentPane().add(button);
            getContentPane().add(txtarea);
            getContentPane().add(label);
            getContentPane().add(txtfield);
        } else if (layout.equalsIgnoreCase("g")){
            getContentPane().setLayout(new GridLayout(0,2));
            getContentPane().add(button);
            getContentPane().add(txtarea);
            getContentPane().add(label);
            getContentPane().add(txtfield);
        }else{
            System.out.println("Falsche eingabe");
        }

        pack();
        setVisible(true);



    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("B = Borderlayout | F = FlowLayout | G = GridLayout");
        String result = scanner.next();
        new LayoutTest(result);

    }
}
