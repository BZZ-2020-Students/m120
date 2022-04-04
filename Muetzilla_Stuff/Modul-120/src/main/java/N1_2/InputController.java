package N1_2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputController extends KeyAdapter {
    private InputView view;
    private IntegerModel model;

    public InputController(InputView view, IntegerModel model){
        this.view =  view;
        this.model = model;
    }

    public void keyTyped(KeyEvent event){
        boolean correctInput = true;
        if(event.getKeyCode() == KeyEvent.VK_ENTER){
//            try {
//                int intInput = Integer.parseInt(event.getKeyCode())
//            }
        }
    }
}
