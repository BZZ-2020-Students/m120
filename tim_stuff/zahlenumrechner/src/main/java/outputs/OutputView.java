package outputs;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public abstract class OutputView extends JFrame implements Observer {
    private JLabel outValue;
    private final int xPos = 50;
    private final int yPos = 50;
    private final int xDelta = 100;
    private final int yDelta = 75;

    public OutputView() throws HeadlessException {
        init();
    }

    private void init() {
        setLayout(new FlowLayout());
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Output");
        outValue = new JLabel("Output");
        add(outValue);
    }
}
