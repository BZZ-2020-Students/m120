package KlickPrototyp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    public int timer = 0;
    public int anzeige = 2;

    JLabel benutzertext = new JLabel("Benutzername: ");
    JLabel passwordtext = new JLabel("Passwort: ");

    JLabel errormsg = new JLabel(" ");

     JTextField benutzername = new JTextField(20);
     JTextField password = new JTextField(20);

     JButton loginbtn = new JButton("Login");

     // Panels
     JPanel centerpanel = new JPanel(new GridLayout(3,1));
     JPanel loginpanel = new JPanel(new GridLayout(2,2,10,3));
     JPanel buttonpanel = new JPanel();

    Login(){
        super("Login Page");
        this.setSize(400,230);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        getContentPane().setLayout(new BorderLayout());

        // Loginpanel
       loginpanel.add(benutzertext);
       loginpanel.add(benutzername);
       loginpanel.add(passwordtext);
       loginpanel.add(password);
       centerpanel.setBorder(BorderFactory.createEmptyBorder(30,20,0,20));

       // Loginbutton/panel
       loginbtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               timer++;
               if (timer == 3){
                   System.exit(0);
               }
               checkLogin();
           }
       });
       buttonpanel.add(loginbtn);


        //Error MSG
        errormsg.setVisible(true);
        errormsg.setHorizontalAlignment(JLabel.CENTER);
        errormsg.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));

        // Centerpanel
        centerpanel.add(loginpanel);
        centerpanel.add(buttonpanel);
        centerpanel.add(errormsg);

       getContentPane().add(centerpanel, BorderLayout.CENTER);

       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
    }

    public void checkLogin(){
        String bn = benutzername.getText();
        String psw = password.getText();

        if(bn.equals("admin") && psw.equals("root")){
            new Tutorial();
            setVisible(false); // Loginfenster wird ausgeblendet
        }else{
            errormsg.setForeground(Color.RED);
            errormsg.setVisible(true);
            errormsg.setText("Der Benutzername oder das Passwort ist falsch!" ); //Noch " + anzeige--  + " Versuche
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
