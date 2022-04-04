import java.util.Observable;

public class IntegerModel extends Observable {
    private int value = 0;

    public IntegerModel() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;

        setChanged();
        notifyObservers(value);
    }
}
