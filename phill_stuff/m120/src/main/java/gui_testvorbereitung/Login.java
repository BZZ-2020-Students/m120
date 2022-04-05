package gui_testvorbereitung;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Login extends JFrame {
    private int loginFails = 0;
    public static void main(String[] args) {
        new Login();
    }

    public Login() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        var title = new JLabel("Login");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        var panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        var username = new JLabel("Username: ");
        var password = new JLabel("Password: ");
        var usernameField = new JTextField(20);
        var passwordField = new JPasswordField(20);
        panel.add(username);
        panel.add(usernameField);
        panel.add(password);
        panel.add(passwordField);

        add(panel, BorderLayout.CENTER);

        var bottom = new JPanel();
        var login = new JButton("Login");
        bottom.setLayout(new GridLayout(1, 4));
        for (int i = 0; i < 3; i++) {
            bottom.add(new JLabel(""));
        }

        login.addActionListener(e -> {  // ActionListener
            if (usernameField.getText().equals("admin") && new String(passwordField.getPassword()).equals("admin")) {
                new Main();
                setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(this, "Login fehlgeschlagen!");
                loginFails++;
            }
            if (loginFails == 3) {
                JOptionPane.showMessageDialog(this, "Zu viele Login-Versuche!");
                try {
                    Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=2942BB1JXFk"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });

        bottom.add(login);

        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }
}