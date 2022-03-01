package L3_2;

import javax.swing.*;
import java.awt.*;

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
    private JLabel imageLabel =  new JLabel(new ImageIcon("src\\main\\java\\L3_2\\Logo.gif"));
    private JLabel title = new JLabel("Informatik/Technik");
    private JPanel titlePanel =  new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel buttonSoutPanel = new JPanel();
    private JButton neuButton =  new JButton("Neu");
    private JButton erfassenButton =  new JButton("Erfassen");
    private JButton verwerfenButton =  new JButton("Verwerfen");
    private JButton schliessenButton =  new JButton("Schliessen");
    private JPanel centerPanel = new JPanel();
    private JPanel topCenterPanel = new JPanel();
    private JPanel bottomCenterPanel = new JPanel();
    private JSeparator topSeparator = new JSeparator();
    private JSeparator bottomSeparator = new JSeparator();
    public InputMask(){
        super("Beispiel zu GUI-Design");

        displayContent();
        pack();
        setVisible(true);
    }

    private void displayContent() {
        //Title Panel
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title, BorderLayout.WEST);
        titlePanel.add(imageLabel, BorderLayout.EAST);
        //Center Panel
        centerPanel.setLayout(new GridLayout(0,1));
        centerPanel.add(topSeparator);
        centerPanel.add(topCenterPanel);
        centerPanel.add(bottomSeparator);
        centerPanel.add(bottomCenterPanel);


        //Button Panel
        buttonPanel.setLayout(new GridLayout(1,0));
        buttonPanel.add(neuButton);
        buttonPanel.add(erfassenButton);
        buttonPanel.add(verwerfenButton);
        buttonPanel.add(schliessenButton);
        buttonSoutPanel.setLayout(new BorderLayout());
        buttonSoutPanel.add(buttonPanel, BorderLayout.EAST);
        //Add Panels to main scene
        add(titlePanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(buttonSoutPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
      InputMask im = new InputMask();
      im.setSize(400,300);
    }
}
