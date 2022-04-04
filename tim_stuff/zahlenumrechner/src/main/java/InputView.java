import javax.swing.*;
import java.awt.*;

public class InputView extends JFrame {
    private JTextField inputField;
    private JTextArea info;
    private IntegerModel model;

    public InputView(IntegerModel model) throws HeadlessException {
        this.model = model;

        init();
    }

    private void init() {
        setTitle("Input View");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        inputField = new JTextField(10);
        inputField.addKeyListener(new InputController(this, model));
        inputPanel.add(inputField, BorderLayout.CENTER);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        info = new JTextArea();
        info.setEditable(false);
        info.setLineWrap(true);
        info.setText("Geben Sie hier eine Zahl ein. Sie wird in den Ausgabefenstern \nin Hex, Bin und Dec ausgegeben.\nBestätigen Sie die Eingabe mit ENTER");
        mainPanel.add(new JScrollPane(info), BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    public String getText() {
        return inputField.getText();
    }

    public void setText(String text) {
        inputField.setText(text);
    }
}
