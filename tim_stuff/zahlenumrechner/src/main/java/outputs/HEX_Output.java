package outputs;

import java.awt.*;
import java.util.Observable;

public class HEX_Output extends OutputView {
    public HEX_Output(Observable observable) throws HeadlessException {
        super(observable, "HEX");
    }

    @Override
    public void update(Observable o, Object arg) {
        outValue.setText("HEX: " + Integer.toHexString((int) arg));

        repaint();
    }
}
