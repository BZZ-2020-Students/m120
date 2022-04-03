package aNeinszwei;

import java.util.Observable;

public class BIN_Output extends OutputView{

    private Observable o;
    private Object arg;

    public BIN_Output(Observable o){
        super(o);
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg){
        this.o = o;
        this.arg = arg;
    }
}
