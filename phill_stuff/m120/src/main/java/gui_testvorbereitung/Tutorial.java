package gui_testvorbereitung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Tutorial extends JFrame {
    public static final String FILE_PATH = "src/main/java/gui_testvorbereitung/.config";
    private JLabel title;
    private JLabel text;
    public Tutorial() {
        setTitle("Tutorial");
        setSize(300, 200);
        setLocationRelativeTo(null);

        checkIfShowTutorial();

        JPanel bottom = new JPanel(new GridLayout(1, 3));
        JButton next = new JButton(">");
        next.addActionListener(e -> nextTip());
        JButton prev = new JButton("<");
        prev.addActionListener(e -> nextTip());
        JCheckBox check = new JCheckBox("Keine Tips mehr anzeigen");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    var fileWriter = new FileWriter(FILE_PATH, false);
                    fileWriter.write(String.valueOf(check.isSelected()));
                    fileWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        bottom.add(check);
        bottom.add(prev);
        bottom.add(next);

        nextTip();
        add(bottom, BorderLayout.SOUTH);
    }

    private void checkIfShowTutorial() {
        var check = false;
        try {
            var fileReader = new Scanner(new File(FILE_PATH));
            check = fileReader.nextBoolean();

        } catch (Exception e) {
            System.err.println("File not found");
        } finally {
            setVisible(!check);
        }
    }

    private void nextTip() {
        if (title == null) {
            title = new JLabel();
            add(title, BorderLayout.NORTH);
        }
        if (text == null) {
            text = new JLabel();
            add(text, BorderLayout.CENTER);
        }
        title.setText("Tipp #" + (int) (Math.random() * 100));
        text.setText("<html>" + randomString() + "</html>");
    }

    private String randomString() {
        return Arrays.toString(Arrays.stream(new int[69]).map(i -> (int) (Math.random() * 26)).mapToObj(i -> (char) (i + 'a')).toArray(Character[]::new));
    }
}
