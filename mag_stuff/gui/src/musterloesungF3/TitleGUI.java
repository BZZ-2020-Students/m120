package musterloesungF3; /**********************************************************
 *
 * @author  H. Diethelm, HTA Luzern
 * @version 1.0  12-06-2000
 * @version 2.0  19-09-2007, Anapssung an Swing
 *
 **********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TitleGUI extends JFrame {
    // Listener für ActionEvent des Ok Buttons
    class OkListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String title = input.getText();
            setTitle(title);
        }
    }
    
    // GUI Elemente erzeugen
    JButton ok       = new JButton("Ok");
    JTextField input = new JTextField();
    
    
    TitleGUI() {
        // Frame initialisieren
        setTitle("Enter title");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 100);
        setResizable(false);
        
        // Layouts setzen
        setLayout(new BorderLayout(20, 20));
        
        // Listener registrieren
//        ok.addActionListener(new OkListener());

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTitle(input.getText());
            }
        });
        
        // GUI zusammensetzen
        getContentPane().add(input, BorderLayout.NORTH);
        getContentPane().add(ok, BorderLayout.CENTER);
        
        // Frame sichtbar machen
        setVisible(true);
    }
}