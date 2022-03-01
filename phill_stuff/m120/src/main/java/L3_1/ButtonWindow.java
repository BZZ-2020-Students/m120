package L3_1;

import javax.swing.*;
import java.awt.*;

class ButtonWindow extends JFrame {
    JButton save       = new JButton("Speichern");
    JPanel panel = new JPanel();


    ButtonWindow() {
        // Frame initialisieren
        setTitle("Demo L3-1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 100);
//        setResizable(false);

        // Layouts setzen
        setLayout(new BorderLayout(20, 20));
        panel.setLayout(new BorderLayout(20,20));
        panel.add(save,BorderLayout.EAST);
        // GUI zusammensetzen
        getContentPane().add(panel, BorderLayout.SOUTH);

        // Listener registrieren
        //...

        // Frame sichtbar machen
        setVisible(true);
    }
}
