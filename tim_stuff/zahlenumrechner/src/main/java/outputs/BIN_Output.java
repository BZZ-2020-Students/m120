package outputs;

import java.util.Observable;

public class BIN_Output extends OutputView {
    public BIN_Output(Observable observable) {
        super(observable, "BIN");
    }

    @Override
    public void update(Observable o, Object arg) {
        outValue.setText(Integer.toBinaryString((Integer) arg));

        repaint();
    }
}
