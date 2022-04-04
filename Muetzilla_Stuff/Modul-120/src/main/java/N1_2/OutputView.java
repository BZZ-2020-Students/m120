package N1_2;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public abstract class OutputView extends JFrame implements Observer{

    static int xPos, yPos=50, xDelta = 100, yDelta = 75;
    protected JLabel outValue;

    public OutputView(Observable o){
        super("Ausgabe");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        o.addObserver(this);

        init();

        this.pack();
        Dimension d = this.getPreferredSize();
        this.setSize(new Dimension(300, (int)d.getHeight()));
        this.setVisible(true);

        xPos += xDelta;
        yPos += yDelta;
        this.setLocation(xPos, yPos);
    }


    private void init(){
        outValue = new JLabel("value");
        this.getContentPane().add(outValue, BorderLayout.CENTER);
    }
}
