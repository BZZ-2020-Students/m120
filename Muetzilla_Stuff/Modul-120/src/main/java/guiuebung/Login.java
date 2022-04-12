package guiuebung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private final String password;
    private final String username;
    private int failedAttemptsCounter = 0;
    private JButton login;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JPasswordField passwordInput;
    private JTextField usernameInput;
    private JPanel southPanel;
    private JPanel centerPanel;

    public Login(String password, String username){
        super("Login");
        this.password = password;
        this.username = username;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        pack();
        setVisible(true);
    }
    public void init(){
        passwordLabel = new JLabel("Password");
        usernameLabel = new JLabel("Username");
        passwordInput =  new JPasswordField();
        usernameInput =  new JTextField();
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,2));
        centerPanel.add(usernameLabel);
        centerPanel.add(usernameInput);
        centerPanel.add(passwordLabel);
        centerPanel.add(passwordInput);

        setLayout(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);

        southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredPw = passwordInput.getText();
                String enteredUsername = usernameInput.getText();
                passwordInput.setText("");
                usernameInput.setText("");
                if(checkCorrectPassword(enteredUsername, enteredPw)){
                    new MainView();
                    new Tip();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(Login.this, "Login fehlgeschlagen! \nFalscher Username oder falsches Passwort");
                    failedAttemptsCounter++;
                }
                if(failedAttemptsCounter == 3){
                    JOptionPane.showMessageDialog(Login.this, "Zu viele falsche Login versuche, bitte versuchen Sie es nachher erneut!");
                    System.exit(0);
                }

            }
        });
        southPanel.add(login, BorderLayout.EAST);

        add(southPanel, BorderLayout.SOUTH);
    }

    private boolean checkCorrectPassword(String enterdUsername, String enteredPw) {
        return enterdUsername.equals(username) && enteredPw.equals(password);
    }
}
