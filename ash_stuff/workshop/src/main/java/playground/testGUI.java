package playground;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Objects;
import java.util.Random;

public class testGUI extends JFrame {
    class TitleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setTitle(input.getText());
        }
    }

    class CountListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int currentNum = Integer.parseInt(number.getText());
            currentNum++;
            number.setText(String.valueOf(currentNum));
        }
    }

    class resetListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            number.setText("0");
        }
    }

    class setSizeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(width.getText().equals("")||height.getText().equals("")){
                warning.setText("Please enter a number in both fields!");
                warning.setForeground(Color.RED);
            }else{
                warning.setText("");
                int widthInt = Integer.parseInt(width.getText());
                int heightInt = Integer.parseInt(height.getText());
                setSize(widthInt, heightInt);
            }

        }
    }

    class uploadImageListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String url = imageUrl.getText();
            try {
                img = ImageIO.read(new URL(url));
                ImageIcon icon = new ImageIcon(img);
                lbl.setIcon(icon);
                imagePanel.add(lbl);
                repaint();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class changeBackgroundListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Color initialBackground = chooseColor.getBackground();
            Color background = JColorChooser.showDialog(null, "JColorChooser Sample", initialBackground);
            if (background != null) {
                colorChoosePanel.setBackground(background);
            }
        }
    }

    //Tabs
    JPanel setTitlePanel = new JPanel(new BorderLayout(20, 20));
    JPanel counterPanel = new JPanel();
    JPanel setSizePanel = new JPanel(new BorderLayout(20,20));
    JPanel imagePanel = new JPanel();
    JPanel colorChoosePanel = new JPanel();
    JPanel ticTacToePanel = new JPanel(new BorderLayout());

    //SetTitle
    JButton ok = new JButton("Ok");
    JTextField input = new JTextField();


    //counter
    JButton count = new JButton("Count");
    JButton reset = new JButton("Reset");
    JLabel number = new JLabel("0");

    //size
    JLabel warning = new JLabel("");
    JLabel widthText = new JLabel("Width: ");
    JLabel heightText = new JLabel("Height: ");
    JTextField width = new JTextField(5);
    JTextField height = new JTextField(5);
    JButton setSize = new JButton("Set Size");
    JPanel warningPanel = new JPanel();
    JPanel mainPanel = new JPanel();

    //image
    JLabel imageLabel = new JLabel("Online image url (no local path)");
    JTextField imageUrl = new JTextField(10);
    JButton submitUrl = new JButton("Submit Url");
    BufferedImage img;
    JLabel lbl = new JLabel();

    //change color
    JButton chooseColor = new JButton("Pick to Change Background");

    //TicTacToe
    JPanel t_panel = new JPanel();// Pannel for text
    JPanel bt_panel = new JPanel();// Pannel for buttons
    JLabel textfield = new JLabel();// Label object to display text
    JButton[] bton = new JButton[9];// creating an array of button's because in tic tac toe game there are 9 position's
    int chance_flag = 0;
    Random random = new Random();
    boolean pl1_chance;


    JTabbedPane tabpane = new JTabbedPane
            (JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

    public testGUI() {



        //setTitle
        setTitlePanel.add(input, BorderLayout.NORTH);
        setTitlePanel.add(ok, BorderLayout.SOUTH);
        ok.addActionListener(new TitleListener());

        //counter
        count.addActionListener(new CountListener());
        reset.addActionListener(new resetListener());
        reset.setBackground(Color.RED);
        counterPanel.add(number);
        counterPanel.add(count);
        counterPanel.add(reset);

        //Set size
        setSize.addActionListener(new setSizeListener());
        warningPanel.add(warning);
        setSizePanel.add(warningPanel, BorderLayout.NORTH);
        mainPanel.add(widthText);
        mainPanel.add(width);
        mainPanel.add(heightText);
        mainPanel.add(height);
        setSizePanel.add(mainPanel, BorderLayout.CENTER);
        setSizePanel.add(setSize, BorderLayout.SOUTH);

        //Image set
        submitUrl.addActionListener(new uploadImageListener());
        imagePanel.add(imageLabel);
        imagePanel.add(imageUrl);
        imagePanel.add(submitUrl);

        //change color
        chooseColor.addActionListener(new changeBackgroundListener());
        colorChoosePanel.add(chooseColor);



        textfield.setBackground(new Color(120, 20, 124));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.PLAIN , 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 800, 100);

        bt_panel.setLayout(new GridLayout(3, 3));// setting layout of bt_pannel as gridlayout
        bt_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            bton[i] = new JButton();// creating object for each button element of array
            bt_panel.add(bton[i]);// adding each button to the pannel for buttons
            bton[i].setFont(new Font("Ink Free", Font.BOLD, 120));
            bton[i].setFocusable(false);
            bton[i].addActionListener(this::actionPerformed);
        }

        t_panel.add(textfield);
        ticTacToePanel.add(t_panel,BorderLayout.NORTH);
        ticTacToePanel.add(bt_panel);

        startGame();// To start Game





        tabpane.addTab("Set title", setTitlePanel);
        tabpane.addTab("Counter", counterPanel);
        tabpane.addTab("Set Size", setSizePanel);
        tabpane.addTab("Image", imagePanel);
        tabpane.addTab("Color Picker", colorChoosePanel);
        tabpane.addTab("TicTacToe", ticTacToePanel);

        getContentPane().add(tabpane);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setSize(500, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == bton[i]) {
                if (pl1_chance) {
                    if (Objects.equals(bton[i].getText(), "")) {
                        bton[i].setForeground(new Color(255, 0, 0));
                        bton[i].setText("X");
                        pl1_chance = false;
                        textfield.setText("O turn");
                        chance_flag++;
                        matchCheck();
                    }
                } else {
                    if (Objects.equals(bton[i].getText(), "")) {
                        bton[i].setForeground(new Color(0, 0, 255));
                        bton[i].setText("O");
                        pl1_chance = true;
                        textfield.setText("X turn");
                        chance_flag++;
                        matchCheck();
                    }
                }
            }
        }
    }


    public void startGame() {
        try {
            textfield.setText("Loading....");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int chance=random.nextInt(100);
        if (chance%2 == 0) {
            pl1_chance = true;
            textfield.setText("X turn");
        } else {
            pl1_chance = false;
            textfield.setText("O turn");
        }
    }
    public void gameOver(String s){
        chance_flag = 0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(ticTacToePanel, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        repaint();
        if(n==0){
            startGame();
        }

    }
    public void matchCheck() {// In this function we are checking wining condition's using conditional statments
        if ((Objects.equals(bton[0].getText(), "X")) && (Objects.equals(bton[1].getText(), "X")) && (Objects.equals(bton[2].getText(), "X"))) {
            xWins(0, 1, 2);
        }
        else if ((Objects.equals(bton[0].getText(), "X")) && (bton[4].getText().equals("X")) && (Objects.equals(bton[8].getText(), "X"))) {
            xWins(0, 4, 8);
        }
        else if ((Objects.equals(bton[0].getText(), "X")) && (Objects.equals(bton[3].getText(), "X")) && (Objects.equals(bton[6].getText(), "X"))) {
            xWins(0, 3, 6);
        }
        else if ((Objects.equals(bton[1].getText(), "X")) && (Objects.equals(bton[4].getText(), "X")) && (bton[7].getText().equals("X"))) {
            xWins(1, 4, 7);
        }
        else if ((Objects.equals(bton[2].getText(), "X")) && (Objects.equals(bton[4].getText(), "X")) && (Objects.equals(bton[6].getText(), "X"))) {
            xWins(2, 4, 6);
        }
        else if ((Objects.equals(bton[2].getText(), "X")) && (Objects.equals(bton[5].getText(), "X")) && (Objects.equals(bton[8].getText(), "X"))) {
            xWins(2, 5, 8);
        }
        else if ((Objects.equals(bton[3].getText(), "X")) && (Objects.equals(bton[4].getText(), "X")) && (Objects.equals(bton[5].getText(), "X"))) {
            xWins(3, 4, 5);
        }
        else if ((Objects.equals(bton[6].getText(), "X")) && (Objects.equals(bton[7].getText(), "X")) && (Objects.equals(bton[8].getText(), "X"))) {
            xWins(6, 7, 8);
        }

        else if ((Objects.equals(bton[0].getText(), "O")) && (Objects.equals(bton[1].getText(), "O")) && (Objects.equals(bton[2].getText(), "O"))) {
            oWins(0, 1, 2);
        }
        else if ((Objects.equals(bton[0].getText(), "O")) && (Objects.equals(bton[3].getText(), "O")) && (Objects.equals(bton[6].getText(), "O"))) {
            oWins(0, 3, 6);
        }
        else if ((Objects.equals(bton[0].getText(), "O")) && (Objects.equals(bton[4].getText(), "O")) && (Objects.equals(bton[8].getText(), "O"))) {
            oWins(0, 4, 8);
        }
        else if ((Objects.equals(bton[1].getText(), "O")) && (Objects.equals(bton[4].getText(), "O")) && (Objects.equals(bton[7].getText(), "O"))) {
            oWins(1, 4, 7);
        }
        else if ((Objects.equals(bton[2].getText(), "O")) && (Objects.equals(bton[4].getText(), "O")) && (Objects.equals(bton[6].getText(), "O"))) {
            oWins(2, 4, 6);
        }
        else if ((Objects.equals(bton[2].getText(), "O")) && (Objects.equals(bton[5].getText(), "O")) && (Objects.equals(bton[8].getText(), "O"))) {
            oWins(2, 5, 8);
        }
        else if ((Objects.equals(bton[3].getText(), "O")) && (Objects.equals(bton[4].getText(), "O")) && (Objects.equals(bton[5].getText(), "O"))) {
            oWins(3, 4, 5);
        } else if ((Objects.equals(bton[6].getText(), "O")) && (Objects.equals(bton[7].getText(), "O")) && (Objects.equals(bton[8].getText(), "O"))) {
            oWins(6, 7, 8);
        }
        else if(chance_flag==9) {
            textfield.setText("Match Tie");
            gameOver("Match Tie");
        }
    }
    public void xWins(int x1, int x2, int x3) {
        bton[x1].setBackground(Color.RED);
        bton[x2].setBackground(Color.RED);
        bton[x3].setBackground(Color.RED);
        for (int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
        }
        textfield.setText("X wins");
        gameOver("X Wins");
    }
    public void oWins(int x1, int x2, int x3) {
        bton[x1].setBackground(Color.RED);
        bton[x2].setBackground(Color.RED);
        bton[x3].setBackground(Color.RED);
        for (int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
        }
        textfield.setText("O Wins");
        gameOver("O Wins");
    }



    public static void main(String[] args){
      new testGUI();
    }
}
