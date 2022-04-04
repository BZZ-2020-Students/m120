package aNeinszwei;

import java.util.Observable;

public class DEC_Output extends OutputView{

    public DEC_Output(Observable o) {
        super(o);
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        outValue.setText("DEC: " + arg);
    }
}
