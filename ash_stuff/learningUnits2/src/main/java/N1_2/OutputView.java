package N1_2;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public abstract class OutputView extends JFrame implements Observer {
    protected JLabel outValue;
    static int xPos = 50;
    static int yPos = 50;
    static int xDelta = 100;
    static int yDelta = 75;

    public OutputView(Observable o) throws HeadlessException {
        o.addObserver(this);
        init();
    }
    private void init(){
        outValue = new JLabel("Value");
        add(outValue);
        pack();
        setLocation(xPos, yPos);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        xPos += xDelta;
        yPos += yDelta;
    }

}
