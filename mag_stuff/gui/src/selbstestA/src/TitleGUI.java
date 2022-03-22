package selbstestA.src; /**********************************************************
 *
 * @author H. Diethelm, HTA Luzern
 * @version 1.0  12-06-2000
 * @version 2.0  19-09-2007, Anapssung an Swing
 *
 **********************************************************/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class TitleGUI extends JFrame {
    class OkListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String title = input.getText();
            setTitle(title);
        }
    }

    // GUI Elemente erzeugen
    JButton ok = new JButton("Ok");
    JTextField input = new JTextField();


    TitleGUI() {
        // Frame initialisieren
        setTitle("Enter title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 100);
        setResizable(false);

        // Layouts setzen
        setLayout(new BorderLayout(20, 20));

        // GUI zusammensetzen
        getContentPane().add(input, BorderLayout.NORTH);
        getContentPane().add(ok, BorderLayout.CENTER);

        // Listener registrieren
        //...
        ok.addActionListener(new OkListener());

        // Frame sichtbar machen
        setVisible(true);
    }
}