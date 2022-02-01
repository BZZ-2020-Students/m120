package selbsttestA.frage2;

import javax.swing.*;
import java.awt.*;

class TranslatorGUI extends JFrame {
    public static void main(String[] args) {
        new TranslatorGUI();
    }

    // GUI Elemente erzeugen
    JLabel dLabel = new JLabel("Deutsch:");
    JLabel eLabel = new JLabel("English:");
    JButton e2d = new JButton("E --> D");
    JButton d2e = new JButton("D --> E");
    JTextField dField = new JTextField();
    JTextField eField = new JTextField();

    // Panels erzeugen
    JPanel buttonPanel = new JPanel();
    JPanel translatorPanel = new JPanel();
    JPanel labelPanel = new JPanel();

    TranslatorGUI() {
        // Frame initialisieren
        setTitle("Translator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 130);
        setResizable(false);

        // Layouts setzen
        setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(1, 2));
        translatorPanel.setLayout(new BorderLayout(15, 15));
        labelPanel.setLayout(new BorderLayout(15, 15));

        // GUI zusammensetzen
        buttonPanel.add(d2e);
        buttonPanel.add(e2d);

        translatorPanel.add(dField, BorderLayout.NORTH);
        translatorPanel.add(buttonPanel, BorderLayout.CENTER);
        translatorPanel.add(eField, BorderLayout.SOUTH);

        labelPanel.add(dLabel, BorderLayout.NORTH);
        labelPanel.add(eLabel, BorderLayout.SOUTH);

        getContentPane().add(labelPanel, BorderLayout.WEST);
        getContentPane().add(translatorPanel, BorderLayout.CENTER);

        // Frame sichtbar machen
        setVisible(true);
    }
}
