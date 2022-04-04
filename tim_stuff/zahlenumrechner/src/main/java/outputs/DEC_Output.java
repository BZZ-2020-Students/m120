package outputs;

import java.awt.*;
import java.util.Observable;

public class DEC_Output extends OutputView {
    public DEC_Output(Observable observable) throws HeadlessException {
        super(observable, "DEC");
    }

    @Override
    public void update(Observable o, Object arg) {
        outValue.setText("DEC: " + arg);

        repaint();
    }
}
