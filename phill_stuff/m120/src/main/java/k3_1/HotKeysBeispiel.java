package k3_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HotKeysBeispiel extends JFrame {


    public HotKeysBeispiel() {
        setTitle("Hotkeys Beispiel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);

        initComponents();
        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        var button = new JButton("Click or press ALT-C");
        button.setMnemonic('C');
        button.addActionListener(evt -> JOptionPane.showMessageDialog(null, "Button clicked or pressed"));

        var textField = new JTextField();
        setKeyBinding(textField, "control P", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField.getText());
            }
        });

        setLayout(new BorderLayout());
        add(button, BorderLayout.NORTH);
        add(textField, BorderLayout.SOUTH);
    }

    private void setKeyBinding(JComponent component, String keyStroke, Action action) {
        component.getInputMap().put(KeyStroke.getKeyStroke(keyStroke), keyStroke);
        component.getActionMap().put(keyStroke, action);
    }

    public static void main(String[] args) {
        new HotKeysBeispiel();
    }
}
