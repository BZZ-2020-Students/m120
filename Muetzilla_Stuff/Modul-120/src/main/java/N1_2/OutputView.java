package N1_2;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public abstract class OutputView implements Observer {
    protected JLabel outValue;
    public static int xPos = 50;
    public static int yPos = 50;
    public static int xDelta = 100;
    public static int yDelta = 75;

    public OutputView(Observable o){

    }

    public void init(){

    }
}
