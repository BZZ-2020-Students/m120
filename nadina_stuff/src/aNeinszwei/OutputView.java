package aNeinszwei;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public abstract class OutputView extends JFrame implements Observer  {

    protected JLabel outValue;

    private static int xPosC = 50;
    private static int yPos = 50;
    private static int xDelta = 100;
    private static int yDelta = 75;

    public OutputView(Observable o){

    }

    public void init(){

    }

}
