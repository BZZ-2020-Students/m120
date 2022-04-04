package aNeinszwei;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public abstract class OutputView extends JFrame implements Observer  {

    protected JLabel outValue;

    private static int xPos = 50;
    private static int yPos = 50;
    private static int xDelta = 100;
    private static int yDelta = 75;

    public OutputView(Observable o){
        super("Ausgabe");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(150,100);

        o.addObserver(this);

        xPos += xDelta;
        yPos += yDelta;
        this.setLocation(xPos, yPos); // Fenster werden nicht übereinander angezeigt


        init();
        setVisible(true);
    }

    public void init(){
        outValue = new JLabel("value");
        this.getContentPane().add(outValue, BorderLayout.CENTER);
    }

}
