package lb_01;

import javax.swing.*;
import java.awt.*;

public class TestGUIWerkstattDesign extends JFrame {
    private JRadioButton upload;
    private JButton go;
    private JLabel verzeichnisLabel;
    private JTextField verzeichnisTextField;
    private JPanel centerPanel;

    public TestGUIWerkstattDesign(){
        super("Test zu GUI-Werkstatt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponent();
        pack();
        setVisible(true);
    }

    private void initComponent() {
        setLayout(new BorderLayout());
        //Top
        upload = new JRadioButton("upload", true);
        add(upload, BorderLayout.NORTH);
        //Center
        centerPanel =  new JPanel();
        centerPanel.setLayout(new GridLayout(0,2));
        verzeichnisLabel =  new JLabel("Verzeichnis:");
        verzeichnisTextField =  new JTextField(30);
        centerPanel.add(verzeichnisLabel);
        centerPanel.add(verzeichnisTextField);
        add(centerPanel, BorderLayout.CENTER);
        //Bottom
        go = new JButton("GO");
        add(go, BorderLayout.SOUTH);


    }

    public static void main(String[] args) {
        new TestGUIWerkstattDesign();
    }
}
