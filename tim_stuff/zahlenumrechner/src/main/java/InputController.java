import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputController extends KeyAdapter {
    private InputView view;
    private IntegerModel model;

    public InputController(InputView view, IntegerModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
