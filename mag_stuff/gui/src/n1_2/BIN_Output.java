package n1_2;

import java.util.Observable;

public class BIN_Output extends OutputView{
    public BIN_Output(Observable o) {
        super(o);
    }

    @Override
    public void update(Observable o, Object arg) {
        outValue.setText(arg.toString());
        repaint();
    }
}
