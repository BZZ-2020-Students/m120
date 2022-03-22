package K3_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPersonDialog extends JDialog {
    private PersonOverview personOverview;

    private JPanel inputPanel;
    private JButton applyButton;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel emailLabel;
    private JLabel addressLabel;
    private JTextField firstnameTextField;
    private JTextField lastnameTextField;
    private JTextField emailTextField;
    private JTextField addressTextField;

    /**
     * Mit diesem Konstruktor kann das Verhalten des Dialoges gesetzt werden
     *
     * @param parent         bestimmt, von welchem JFrame dieser Dialog aufgerufen wurde.
     * @param titel          ist wie auch beim JFrame der Titel, welchen der Dialog tragen wird.
     * @param modal          bestimmt, ob der Dialog modal ist oder nicht. Modal heisst, dass dieser Dialog zuerst geschlossen werden muss bevor man die Applikation weiter nutzen kann.
     *                       Wird "True" übergeben so ist es nicht möglich das Programm zunutzen oder mehrere dieser Dialoge zuöffne.
     *                       Wird hingegen "False" übergeben so öffnet sich einfach der Dialog, das Programm kann aber weiter normal verwendet werden. Es können mehrere dieser Dialoge geöffnet sein.
     * @param personOverview Referenz zur PersonOverview um Daten zu erneuern.
     */
    public EditPersonDialog(JFrame parent, String titel, boolean modal, PersonOverview personOverview) {
        super(parent, titel, modal);
        this.personOverview = personOverview;
        init();
        pack();
        setVisible(true);
    }

    public void init() {
        inputPanel = new JPanel();
        //Edit area
        inputPanel.setLayout(new GridLayout(0, 2));
        firstnameLabel = new JLabel("Firstname: ");
        lastnameLabel = new JLabel("Lastname: ");
        emailLabel = new JLabel("Email: ");
        addressLabel = new JLabel("Address: ");
        firstnameTextField = new JTextField(personOverview.getFirstname());
        lastnameTextField = new JTextField(personOverview.getLastname());
        emailTextField = new JTextField(personOverview.getEmail());
        addressTextField = new JTextField(personOverview.getAddress());
        inputPanel.add(firstnameLabel);
        inputPanel.add(firstnameTextField);
        inputPanel.add(lastnameLabel);
        inputPanel.add(lastnameTextField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailTextField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressTextField);

        //Apply area
        applyButton = new JButton("Apply changes");
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set values without validation
                personOverview.updateValues(firstnameTextField.getText(), lastnameTextField.getText(), emailTextField.getText(), addressTextField.getText());
                dispose();
            }
        });

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.CENTER);
        add(applyButton, BorderLayout.SOUTH);

    }
}
