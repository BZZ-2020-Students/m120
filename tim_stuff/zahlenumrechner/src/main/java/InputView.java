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
        inputPanel.add(inputField, BorderLayout.CENTER);

        JButton button = new JButton("Send");
        button.addActionListener(e -> {
            String text = inputField.getText();
            if (text.length() > 0) {
                model.setValue(Integer.parseInt(text));
            }
        });
        inputPanel.add(button, BorderLayout.EAST);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        info = new JTextArea();
        info.setEditable(false);
        mainPanel.add(new JScrollPane(info), BorderLayout.CENTER);

        add(mainPanel);
    }

    public String getText() {
        return inputField.getText();
    }
}
