package l3_2;

import javax.swing.*;
import java.awt.*;

public class Contakt extends JFrame {
    JLabel logo = new JLabel(new ImageIcon("./src/l3_2/Logo.gif"));
    JLabel informatik = new JLabel("Informatik/Technik");
    JPanel oben = new JPanel(new BorderLayout());

    JLabel person = new JLabel("Person:");
    JLabel name = new JLabel("Name");
    JLabel vorname = new JLabel("Vorname");
    JLabel strasse = new JLabel("Strasse");
    JLabel plz = new JLabel("PlZ");
    JLabel ort = new JLabel("Ort");
    JLabel kontakte = new JLabel("Kontakte:");
    JLabel tel = new JLabel("Tel");
    JLabel mail = new JLabel("Mail");
    JLabel nothing = new JLabel();
    JLabel nothing2 = new JLabel();
    JTextField person2 = new JTextField();
    JTextField person3 = new JTextField();
    JTextField person4 = new JTextField();
    JTextField person5 = new JTextField();
    JTextField person6 = new JTextField();
    JTextField person7 = new JTextField();
    JTextField person8 = new JTextField();
    JPanel mitte = new JPanel(new GridLayout(2,4));
    JPanel links = new JPanel(new GridLayout(5,1));
    JPanel mitteLinks = new JPanel(new GridLayout(5,1));
    JPanel mitteRechts = new JPanel(new GridLayout(5,1));
    JPanel rechts = new JPanel(new GridLayout(5,1));

    JLabel klasse = new JLabel("Klasse");
    JComboBox<String> comboKlasse;
    JCheckBox bms = new JCheckBox("BMS");
    JLabel bemerkung = new JLabel("Bemerkung");
    JTextArea area = new JTextArea();
    JButton neu = new JButton("Neu");
    JButton erfassen = new JButton("Erfassen");
    JButton verwerfen = new JButton("Verwerfen");
    JButton schliessen = new JButton("Schliessen");
    JPanel unten = new JPanel(new BorderLayout());
    JPanel untenOben = new JPanel(new GridLayout(1,6));
    JPanel untenUnten = new JPanel(new GridLayout(1,4));
    JPanel untenMitte = new JPanel(new BorderLayout());

    JSeparator seperator = new JSeparator();




    public Contakt(){
        super("Beispiel zu Gui-Design");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oben.add(logo, BorderLayout.EAST);
        oben.add(informatik, BorderLayout.WEST);
        add(oben, BorderLayout.NORTH);
//        add(new JSeparator(SwingConstants.VERTICAL));
        String[] combo = {"IA20b", "IA20a"};
        comboKlasse = new JComboBox<>(combo);

        mitte.add(person);
        mitte.add(nothing);
        mitte.add(kontakte);
        mitte.add(nothing2);
        links.add(name);
        links.add(vorname);
        links.add(strasse);
        links.add(plz);
        links.add(ort);
        mitte.add(links);
        mitteLinks.add(person2);
        mitteLinks.add(person3);
        mitteLinks.add(person4);
        mitteLinks.add(person5);
        mitteLinks.add(person6);
        mitte.add(mitteLinks);
        mitteRechts.add(tel);
        mitteRechts.add(mail);
        mitte.add(mitteRechts);
        rechts.add(person7);
        rechts.add(person8);
        mitte.add(rechts);
        add(mitte, BorderLayout.CENTER);
//        add(new JSeparator(SwingConstants.VERTICAL));

        untenOben.add(klasse);
        untenOben.add(comboKlasse);
        untenOben.add(bms);
        unten.add(untenOben, BorderLayout.NORTH);
        untenMitte.add(bemerkung, BorderLayout.WEST);
        untenMitte.add(area, BorderLayout.CENTER);
        unten.add(untenMitte, BorderLayout.CENTER);
        untenUnten.add(schliessen);
        untenUnten.add(verwerfen);
        untenUnten.add(erfassen);
        untenUnten.add(neu);
        unten.add(untenUnten, BorderLayout.SOUTH);
        add(unten, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        Contakt c = new Contakt();
//        c.setSize(600,500);
    }
}

