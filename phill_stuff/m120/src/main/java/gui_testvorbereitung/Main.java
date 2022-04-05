package gui_testvorbereitung;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {


    public Main() {

        setTitle("Testvorbereitung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        this.setLayout(new BorderLayout());
        new Tutorial();

        // Add your code here

        JPanel searchpanel = new JPanel();
        searchpanel.setLayout(new GridLayout(1,2));
        JTextField searchfield = new JTextField(20);
        JButton searchbutton = new JButton("Suchen");

        searchpanel.add(searchfield);
        searchpanel.add(searchbutton);

        Tab anzeigen = new Tab();
        anzeigen.add(new Label("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."), BorderLayout.CENTER);
        Tab erfassen = new Tab();
        erfassen.add(new TextArea(20,20), BorderLayout.CENTER);
        Tab zuordnen = new Tab();
        zuordnen.add(new Label("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."), BorderLayout.CENTER);

        this.add(searchpanel, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Anzeigen", anzeigen);
        tabbedPane.addTab("Erfassen", erfassen);
        tabbedPane.addTab("Zuordnen", zuordnen);

        this.add(tabbedPane, BorderLayout.CENTER);
    }
}
