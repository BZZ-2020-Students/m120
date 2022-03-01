package L3_2;

import javax.swing.*;

public class InputMask extends JFrame {
    private JLabel personTitleLabel =  new JLabel("Person:");
    private JLabel nameLabel =  new JLabel("Name");
    private JLabel vornameLabel =  new JLabel("Vorname");
    private JLabel strasseLabel =  new JLabel("Strasse");
    private JLabel plzLabel =  new JLabel("PLZ");
    private JLabel ortLabel =  new JLabel("Ort");
    private JLabel kontakteTitleLabel =  new JLabel("Kontakte:");
    private JLabel telLabel =  new JLabel("Tel");
    private JLabel mailLabel =  new JLabel("Mail");
    private JLabel imageLabel =  new JLabel(new ImageIcon("src\\main\\java\\L3_2\\  Logo.gif"));
    public InputMask(){
        super("Beispiel zu GUI-Design");
        setSize(400,300);
        add(imageLabel);
        displayContent();
        pack();
        setVisible(true);
    }

    private void displayContent() {

    }

    public static void main(String[] args) {
        new InputMask();
    }
}
