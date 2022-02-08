package selbsttestB.aufgabe2;

import java.awt.*;
import javax.swing.*;

class LoginGUI extends JFrame {
    // GUI Elemente erzeugen
    JLabel message = new JLabel("Enter your name:");
    JTextField name = new JTextField();
    JButton ok = new JButton("Ok");
    JButton cancel = new JButton("Cancel");

    // Panels erzeugen
    JPanel buttonPanel = new JPanel();

    LoginGUI() {
        // Frame initialisieren
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 125);
        setResizable(false);
        // Layouts setzen
        setLayout(new BorderLayout(20, 15));
        buttonPanel.setLayout(new GridLayout(1, 2, 20, 20));

        // GUI zusammensetzen
        buttonPanel.add(cancel);
        buttonPanel.add(ok);

        getContentPane().add(message, BorderLayout.NORTH);
        getContentPane().add(name, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Frame sichtbar machen
        setVisible(true);
    }

    public static void main(String[] args) {
        LoginGUI lg = new LoginGUI();
    }
}