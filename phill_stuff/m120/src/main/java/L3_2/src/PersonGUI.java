package L3_2.src;

import javax.swing.*;
import java.awt.*;

public class PersonGUI extends JFrame {
    JTextField toplabel = new JTextField("Informatik/Technik");
    JPanel northpanel = new JPanel();
    JPanel centerpanel = new JPanel();
    JPanel leftcentergrid = new JPanel();
    JPanel rightcentergrid = new JPanel();
    JPanel southpanel = new JPanel();
    JPanel southnorthpanel = new JPanel();
    JPanel southcenterpanel = new JPanel();
    JPanel southsouthpanel = new JPanel();
    JPanel namepanel = new JPanel();
    JPanel firstnamepanel = new JPanel();
    JPanel streetpanel = new JPanel();
    JPanel plzpanel = new JPanel();
    JPanel placepanel = new JPanel();
    JPanel telpanel = new JPanel();
    JPanel mailpanel = new JPanel();
    JLabel gif = new JLabel(new ImageIcon("src\\main\\java\\L3_2\\bin\\Logo.gif"));
    JLabel perslable = new JLabel("Person:");
    JLabel namelable = new JLabel("Name");
    JLabel firstnamelable = new JLabel("Vorname");
    JLabel streetlable = new JLabel("Strasse");
    JLabel plzlable = new JLabel("PLZ");
    JLabel placelable = new JLabel("Ort");
    JLabel contactlable = new JLabel("Kontakte:");
    JLabel phonelable = new JLabel("Tel");
    JLabel maillable = new JLabel("Mail");
    JTextField nametxtfield = new JTextField();
    JTextField firstnametxtfield = new JTextField();
    JTextField streettxtfield = new JTextField();
    JTextField plztxtfield = new JTextField();
    JTextField placetxtfield = new JTextField();
    JTextField phonetxtfield = new JTextField();
    JTextField mailtxtfield = new JTextField();

    JPanel bmspanel = new JPanel();
    JPanel southbutton = new JPanel();
    JLabel classlabel = new JLabel("Klasse");
    JLabel bemerkunglabel = new JLabel("Bemerkung");
    JLabel bmslabel = new JLabel("BMS");
    JButton neubutton = new JButton("Neu");
    JButton erfassenbutton = new JButton("Erfassen");
    JButton verwerfenbutton = new JButton("Verwerfen");
    JButton schliessenbutton = new JButton("Schliessen");
    JCheckBox bmscheckbutton = new JCheckBox();
    JTextArea bemerkungstxtarea = new JTextArea();
    JComboBox dropdowns = new JComboBox();


    PersonGUI() {
        // Frame initialisieren
        setTitle("Beispiel zu GUI-Design");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
//        setResizable(false);


        setLayout(new BorderLayout(20, 20));
        northpanel.setLayout(new GridLayout(1,2));
        northpanel.add(toplabel);
        northpanel.add(gif);

        namepanel.setLayout(new GridLayout(1,2));
        namepanel.add(namelable);
        namepanel.add(nametxtfield);
        firstnamepanel.setLayout(new GridLayout(1,2));
        firstnamepanel.add(firstnamelable);
        firstnamepanel.add(firstnametxtfield);
        streetpanel.setLayout(new GridLayout(1,2));
        streetpanel.add(streetlable);
        streetpanel.add(streettxtfield);
        plzpanel.setLayout(new GridLayout(1,2));
        plzpanel.add(plzlable);
        plzpanel.add(plztxtfield);
        placepanel.setLayout(new GridLayout(1,2));
        placepanel.add(placelable);
        placepanel.add(placetxtfield);
        telpanel.setLayout(new GridLayout(1,2));
        telpanel.add(phonelable);
        telpanel.add(phonetxtfield);
        mailpanel.setLayout(new GridLayout(1,2));
        mailpanel.add(maillable);
        mailpanel.add(mailtxtfield);

        leftcentergrid.setLayout(new GridLayout(6,1));
        leftcentergrid.add(perslable);
        leftcentergrid.add(namepanel);
        leftcentergrid.add(firstnamepanel);
        leftcentergrid.add(streetpanel);
        leftcentergrid.add(plzpanel);
        leftcentergrid.add(placepanel);

        rightcentergrid.setLayout(new GridLayout(6,1));
        rightcentergrid.add(contactlable);
        rightcentergrid.add(telpanel);
        rightcentergrid.add(mailpanel);

        centerpanel.setLayout(new GridLayout(1,2));
        centerpanel.add(leftcentergrid);
        centerpanel.add(rightcentergrid);

        bmspanel.setLayout(new GridLayout(1,2));
        bmspanel.add(bmslabel);
        bmspanel.add(bmscheckbutton);

        southnorthpanel.setLayout(new BorderLayout());
        southnorthpanel.add(classlabel,BorderLayout.WEST);
        southnorthpanel.add(dropdowns,BorderLayout.CENTER);
        southnorthpanel.add(bmspanel,BorderLayout.EAST);

        southcenterpanel.setLayout(new BorderLayout());
        southcenterpanel.add(bemerkunglabel);
        southcenterpanel.add(bemerkungstxtarea);

        southbutton.setLayout(new GridLayout(1,4));
        southbutton.add(neubutton);
        southbutton.add(erfassenbutton);
        southbutton.add(verwerfenbutton);
        southbutton.add(schliessenbutton);

        southsouthpanel.setLayout(new BorderLayout());
        southsouthpanel.add(southbutton,BorderLayout.EAST);

        southpanel.setLayout(new BorderLayout());
        southpanel.add(southnorthpanel,BorderLayout.NORTH);
        southpanel.add(southcenterpanel,BorderLayout.CENTER);
        southpanel.add(southsouthpanel,BorderLayout.SOUTH);




        getContentPane().add(northpanel, BorderLayout.NORTH);
        getContentPane().add(centerpanel, BorderLayout.CENTER);
        getContentPane().add(southpanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
