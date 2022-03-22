package l3_2;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class BZZGui extends JFrame {
    private JPanel header;
    private JPanel body;
    private JPanel footer;

    public BZZGui() {
        setLayout(new BorderLayout());

        initHeader();
        add(header, BorderLayout.NORTH);
        initInfo();
        add(body, BorderLayout.CENTER);
        initFooter();
        add(footer, BorderLayout.SOUTH);
    }

    private void initHeader() {
        header = new JPanel();
        header.setLayout(new BorderLayout());

        header.setBackground(Color.WHITE);
        header.setSize(800, 100);

        header.setLayout(new BorderLayout());

        header.add(new JLabel("Informatik / Technik"), BorderLayout.WEST);
        header.add(new JLabel(new ImageIcon("src/main/resources/bzz.gif")), BorderLayout.EAST);
    }

    private void initInfo() {
        body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));

        var topInfo = new JPanel();
        topInfo.setLayout(new GridLayout(1, 2));

        var personInfo = new JPanel();
        personInfo.setLayout(new GridLayout(6, 2));
        personInfo.add(new JLabel("Person:"));
        personInfo.add(new JLabel(""));
        personInfo.add(new JLabel("Name"));
        personInfo.add(new JTextField());
        personInfo.add(new JLabel("Vorname"));
        personInfo.add(new JTextField());
        personInfo.add(new JLabel("Strasse"));
        personInfo.add(new JTextField());
        personInfo.add(new JLabel("PLZ"));
        personInfo.add(new JTextField());
        personInfo.add(new JLabel("Ort"));
        personInfo.add(new JTextField());

        var contactInfo = new JPanel();
        contactInfo.setLayout(new GridLayout(6, 2));
        contactInfo.add(new JLabel("Kontakte:"));
        contactInfo.add(new JLabel(""));
        contactInfo.add(new JLabel("Tel"));
        contactInfo.add(new JTextField());
        contactInfo.add(new JLabel("Mail"));
        contactInfo.add(new JTextField());

        for (int i = 0; i < 6; i++) {
            contactInfo.add(new JLabel(""));
        }

        topInfo.add(personInfo);
        topInfo.add(contactInfo);

        body.add(topInfo, BorderLayout.NORTH);

        var bottomInfo = new JPanel();
        bottomInfo.setLayout(new GridLayout(2, 2));

        bottomInfo.add(new JLabel("Klasse"));

        var klassen = new JComboBox<>(new String[]{"IA20a", "IA20b", "IA19a", "IA19b", "IA18a", "IA18b", "IA17a", "IA17b", "IA16a", "IA16b", "IA15a", "IA15b", "IA14a", "IA14b", "IA13a", "IA13b", "IA12a", "IA12b", "IA11a", "IA11b", "IA10a", "IA10b", "IA9a", "IA9b", "IA8a", "IA8b", "IA7a", "IA7b", "IA6a", "IA6b", "IA5a", "IA5b", "IA4a", "IA4b", "IA3a", "IA3b", "IA2a", "IA2b", "IA1a", "IA1b"});
        var bmsLabel = new JLabel("BMS");
        var bms = new JCheckBox();
        var klassenInfo = new JPanel();

        klassenInfo.setLayout(new GridLayout(1, 3));
        klassenInfo.add(klassen);
        klassenInfo.add(bmsLabel);
        klassenInfo.add(bms);

        bottomInfo.add(klassenInfo);

        bottomInfo.add(new JLabel("Bemerkung"));

        var bemerkung = new JTextArea();
        bemerkung.setSize(100, 200);
        bottomInfo.add(bemerkung);

        body.add(bottomInfo, BorderLayout.SOUTH);
    }

    private void initFooter() {
        footer = new JPanel();
        footer.setLayout(new GridLayout(1, 2));

        var buttonContainer = new JPanel();
        buttonContainer.setLayout(new FlowLayout());

        buttonContainer.add(new JButton("Neu"));
        buttonContainer.add(new JButton("Erfassen"));
        buttonContainer.add(new JButton("Verwerfen"));
        buttonContainer.add(new JButton("Schliessen"));

        footer.add(new JLabel(""));
        footer.add(buttonContainer);
    }

    public static void main(String[] args) {
        BZZGui gui = new BZZGui();
        gui.setSize(800, 400);
        gui.setVisible(true);
    }
}
