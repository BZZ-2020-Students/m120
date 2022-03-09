package L3_2;

import javax.swing.*;
import java.awt.*;

public class Formular extends JFrame {
    JPanel header = new JPanel(new BorderLayout(20,20));
    JPanel body  = new JPanel(new GridLayout(2,1));
    JPanel topInfoPanel = new JPanel(new BorderLayout());
    JPanel personalInfo = new JPanel(new GridLayout(6,2));
    JPanel contactInfo = new JPanel(new GridLayout(6,2));
    JPanel bottonInfoPanel = new JPanel(new GridLayout(2,1));
    JPanel classPanel = new JPanel(new GridLayout(1,4));
    JPanel bemerkung = new JPanel(new BorderLayout());
    JPanel buttonPanel = new JPanel(new FlowLayout());
    JPanel footer = new JPanel(new BorderLayout());


    JLabel logo = new JLabel(new ImageIcon("src/main/java/L3_2/Logo.gif"));
    JLabel title = new JLabel("Informatik/Technik");

    JTextField name, vorname, strasse, plz, ort, mail, tel;

    JComboBox<String> classes = new JComboBox<>();
    JCheckBox bms = new JCheckBox();

    JTextArea feedback = new JTextArea();

    JButton neu, edit, cancel, close;

    public Formular(){

        header.setBackground(Color.WHITE);
        header.add(title, BorderLayout.WEST);
        header.add(logo, BorderLayout.EAST);
        header.add(new JSeparator(), BorderLayout.SOUTH);

        name = new JTextField(20);
        vorname = new JTextField(20);
        strasse = new JTextField(20);
        plz = new JTextField(5);
        ort = new JTextField(20);
        mail = new JTextField(20);
        tel = new JTextField(10);

        personalInfo.add(new JLabel("Person:"));
        personalInfo.add(new JLabel());
        personalInfo.add(new JLabel("Name"));
        personalInfo.add(name);
        personalInfo.add(new JLabel("Vorname"));
        personalInfo.add(vorname);
        personalInfo.add(new JLabel("Strasse"));
        personalInfo.add(strasse);
        personalInfo.add(new JLabel("PLZ"));
        personalInfo.add(plz);
        personalInfo.add(new JLabel("Ort"));
        personalInfo.add(ort);

        contactInfo.add(new JLabel("Kontakte:"));
        contactInfo.add(new JLabel());
        contactInfo.add(new JLabel("Tel"));
        contactInfo.add(tel);
        contactInfo.add(new JLabel("Mail"));
        contactInfo.add(mail);
        contactInfo.add(new JLabel());
        contactInfo.add(new JLabel());
        contactInfo.add(new JLabel());


        topInfoPanel.add(personalInfo, BorderLayout.WEST);
        topInfoPanel.add(contactInfo, BorderLayout.EAST);
        topInfoPanel.add(new JSeparator(), BorderLayout.SOUTH);
        classes.addItem("IABM03 A");
        classes.addItem("IABM03 B");
        classes.addItem("IABM03 C");
        classPanel.add(new JLabel("Klasse "));
        classPanel.add(classes);
        classPanel.add(new JLabel("BMS"));
        classPanel.add(bms);

        bemerkung.add(new JLabel("Bemerkung"), BorderLayout.WEST);
        bemerkung.add(feedback, BorderLayout.CENTER);

        bottonInfoPanel.add(classPanel);
        bottonInfoPanel.add(bemerkung);

        body.add(topInfoPanel);
        body.add(bottonInfoPanel);

        neu = new JButton("Neu");
        edit = new JButton("Erfassen");
        cancel = new JButton("Verwerfen");
        close = new JButton("Schliessen");

        buttonPanel.add(neu);
        buttonPanel.add(edit);
        buttonPanel.add(cancel);
        buttonPanel.add(close);

        footer.add(buttonPanel, BorderLayout.EAST);

        setLayout(new BorderLayout());
        getContentPane().add(header, BorderLayout.NORTH);
        getContentPane().add(body, BorderLayout.CENTER);
        getContentPane().add(footer, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Formular();
    }
}
