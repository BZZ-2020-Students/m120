package outputs;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public abstract class OutputView extends JFrame implements Observer {
    private static int xPos = 50;
    private static int yPos = 50;
    private final int xDelta = 100;
    private final int yDelta = 75;
    protected JLabel outValue;

    public OutputView(Observable observable, String title) throws HeadlessException {
        observable.addObserver(this);

        init(title);
    }

    private void init(String title) {
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Output " + title);
        setLocation(xPos, yPos);
        xPos += xDelta;
        yPos += yDelta;
        outValue = new JLabel("Output " + title);
        add(outValue);
        pack();
        setVisible(true);
    }
}
