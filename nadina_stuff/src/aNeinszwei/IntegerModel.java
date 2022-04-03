package aNeinszwei;

import java.util.Observable;

public class IntegerModel extends Observable {

    private int value;

    public IntegerModel(){
        value = 0;
    }

    public void setValue(int value) {
        this.value = value;
        setChanged();
        notifyObservers(this.value);
    }
}
