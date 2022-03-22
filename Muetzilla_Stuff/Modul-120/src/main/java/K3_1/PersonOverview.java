package K3_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonOverview extends JFrame {
    //Swing components
    private JPanel personOverviewPanel;
    private JButton editPersonButton;
    private EditPersonDialog editDialog;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel emailLabel;
    private JLabel addressLabel;
    private JLabel firstNameValueLabel;
    private JLabel lastnameValueLabel;
    private JLabel emailValueLabel;
    private JLabel addressValueLabel;

    //Data
    private String firstname;
    private String lastname;
    private String email;
    private String address;

    public PersonOverview(){
        super("JavaGUI Exit on close");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        pack();
        setVisible(true);
    }


    public PersonOverview(String firstname, String lastname, String email, String address){
        super("K3-1 Modale Fenster Demo");
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        pack();
        setVisible(true);
    }

    public void init(){
        // init person overview values
        personOverviewPanel = new JPanel();
        personOverviewPanel.setLayout(new GridLayout(0,2));
        firstnameLabel = new JLabel("Firstname: ");
        lastnameLabel = new JLabel("Lastname: ");
        emailLabel = new JLabel("Email: ");
        addressLabel = new JLabel("Address: ");
        firstNameValueLabel = new JLabel(firstname);
        lastnameValueLabel = new JLabel(lastname);
        emailValueLabel = new JLabel(email);
        addressValueLabel = new JLabel(address);
        personOverviewPanel.add(firstnameLabel);
        personOverviewPanel.add(firstNameValueLabel);
        personOverviewPanel.add(lastnameLabel);
        personOverviewPanel.add(lastnameValueLabel);
        personOverviewPanel.add(emailLabel);
        personOverviewPanel.add(emailValueLabel);
        personOverviewPanel.add(addressLabel);
        personOverviewPanel.add(addressValueLabel);

        //init edit button
        editPersonButton = new JButton("Edit person");
        editPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Hier wird bei Knopfdruck eine neue Instanz der Klasse EditPersonDialot erstellt, welche den Inhalt für unser Modales Fenster enthält.
                 */
                editDialog = new EditPersonDialog(PersonOverview.this, "K3-1 Modale Fenster Demo, Edit person", true, PersonOverview.this);
                editDialog.setSize(600, 300);
            }
        });

        //init whole layout
        setLayout(new BorderLayout());
        add(personOverviewPanel, BorderLayout.CENTER);
        add(editPersonButton, BorderLayout.SOUTH);



    }


    public void updateValues(String firstname, String lastname, String email, String address){
        firstNameValueLabel.setText(firstname);
        lastnameValueLabel.setText(lastname);
        emailValueLabel.setText(email);
        addressValueLabel.setText(address);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

}
