package aLdreizwei;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DesignGUI extends JFrame {

    // Komponenten "header"
    JTextArea ta = new JTextArea("Informatik/Technik");
    BufferedImage img = ImageIO.read(new File("src/aLdreieins/Logo.gif"));
    JLabel timage = new JLabel(new ImageIcon(img));

    // Person (links)
    JTextArea person = new JTextArea("Person");
    JTextArea name = new JTextArea("Name");
    JTextArea vorname = new JTextArea("Vorname");
    JTextArea strasse = new JTextArea("Strasse");
    JTextArea ort = new JTextArea("Ort");

    JTextField taname = new JTextField();
    JTextField tavorname = new JTextField();
    JTextField tastrasse = new JTextField();
    JTextField taplz = new JTextField();
    JTextField taort = new JTextField();

    // Kontakt (rechts)
    JTextArea kontakte = new JTextArea("Kontakte");
    JTextArea tel = new JTextArea("Tel");
    JTextArea mail = new JTextArea("Mail");

    JTextField tatel = new JTextField();
    JTextField tamail = new JTextField();

    // Footer
    JTextArea klasse = new JTextArea("Klasse");

    String[] klassen = new String[]{"IABM03 A", "IA20a", "IA20b"};
    JComboBox cb = new JComboBox(klassen);

    // Panels
    JPanel titlepanel = new JPanel();
    JPanel personpanel = new JPanel();
    JPanel upperfooter = new JPanel();

    public DesignGUI() throws IOException {
        super("Beispiel zu GUI-Design");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        getContentPane().setLayout(new BorderLayout());

        // Header
        titlepanel.setLayout(new GridLayout(1,2));
        titlepanel.add(ta);
        titlepanel.add(timage, BorderLayout.SOUTH);

        // Person
        personpanel.setLayout(new SpringLayout());
        personpanel.add(name);
        personpanel.add(taname);

        // Footer
        upperfooter.setLayout(new FlowLayout());
        upperfooter.add(klasse);

        getContentPane().add(titlepanel, BorderLayout.NORTH);
        getContentPane().add(personpanel, BorderLayout.CENTER);
        getContentPane().add(upperfooter, BorderLayout.SOUTH);
    }

    public static void main(String[] args) throws IOException {
        DesignGUI gui = new DesignGUI();
        gui.pack();
    }
}
