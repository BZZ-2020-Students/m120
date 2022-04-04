package N1_2;

import java.awt.image.ImageObserver;
import java.util.Observable;

public class HEX_Output extends OutputView{

    public HEX_Output(Observable observer) {
        super(observer);
    }

    @Override
    public void update(Observable o, Object arg) {
        outValue.setText("HEX: "+Integer.toHexString((Integer) arg));
        repaint();
    }
}
