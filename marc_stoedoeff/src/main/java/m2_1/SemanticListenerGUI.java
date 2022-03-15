package m2_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Color.CYAN;
import static java.awt.Color.green;

public class SemanticListenerGUI extends JFrame {
    public SemanticListenerGUI() {
        initComponents();

        setTitle("Semantic Listener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        var textAreaCenter = new JTextArea();
        var scrollField = new JScrollPane(textAreaCenter);

        var listRight = new JList<String>();
        listRight.addListSelectionListener(e -> System.out.println(listRight.getSelectedIndex()));
        listRight.setListData(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"});

        var topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        var topLeftLabel = new JLabel();

        var topRightField = new JTextField();
        topRightField.setPreferredSize(new Dimension(200, 20));
        topRightField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("Focus gained");
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("Focus lost");
            }
        });
        topRightField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    var text = topRightField.getText();

                    textAreaCenter.append("\n" + text);

                    topRightField.setText("");
                }
            }
        });


        topPanel.add(topLeftLabel, BorderLayout.WEST);
        topPanel.add(topRightField, BorderLayout.EAST);

        var bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        var bottomLeftButton = new JButton("toggle color");
        bottomLeftButton.addActionListener(e ->
                bottomLeftButton.setBackground(bottomLeftButton.getBackground() == CYAN ? green : CYAN)
        );

        var bottomRightButton = new JButton();
        bottomRightButton.setText("mouse over color");
        bottomRightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bottomRightButton.setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bottomRightButton.setBackground(null);
            }
        });


        bottomPanel.add(bottomLeftButton, BorderLayout.WEST);
        bottomPanel.add(bottomRightButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
        add(scrollField, BorderLayout.CENTER);
        add(listRight, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        var frame = new SemanticListenerGUI();
    }
}
