package L2_1;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class LayoutTest extends JFrame {
    private JButton b1 =  new JButton("Press me");
    private JButton b2 =  new JButton("Press me two");

    private JTextField f1 = new JTextField("Some Sample Text");
    private  JTextArea a1 = new JTextArea("Some Sample Text \nOn two lines");

    private JLabel l1 = new JLabel("I'm a Label");


    public LayoutTest(String title) {
        super(title);
    }

    public static void main(String[] args) {
        LayoutTest borderLayout =  new LayoutTest("With Border Layout");
        borderLayout.withBorderLayout();
        LayoutTest gridLayout = new LayoutTest("With Grid Layout");
        gridLayout.withGridlayout();
        LayoutTest flowLayout = new LayoutTest("With Flow Layout");
        flowLayout.withFlowLayout();
    }

    public void withBorderLayout(){
        setLayout(new BorderLayout());
        add(b1, BorderLayout.EAST);
        add(b2, BorderLayout.WEST);
        add(f1, BorderLayout.NORTH);
        add(a1, BorderLayout.CENTER);
        add(l1, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    public void withGridlayout(){
        setLayout(new GridLayout(0,2));
        add(b1);
        add(b2);
        add(f1);
        add(a1);
        add(l1);
        pack();
        setVisible(true);
    }
    public void withFlowLayout(){
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(f1);
        add(a1);
        add(l1);
        pack();
        setVisible(true);
    }
}
