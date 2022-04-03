package aNeinszwei;

import java.util.Observable;

public class HEX_Output extends OutputView{

    public HEX_Output(Observable o) {
        super(o);
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
