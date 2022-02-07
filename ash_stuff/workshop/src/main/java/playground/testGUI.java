package playground;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

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
    JPanel panelBlack = new JPanel();

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

    JTabbedPane tabpane = new JTabbedPane
            (JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

    public testGUI() throws IOException {



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

        panelBlack.setBackground(Color.BLACK);


        tabpane.addTab("Set title", setTitlePanel);
        tabpane.addTab("Counter", counterPanel);
        tabpane.addTab("Set Size", setSizePanel);
        tabpane.addTab("Image", imagePanel);
        tabpane.addTab("Color Picker", colorChoosePanel);
        tabpane.addTab("Ich bin schwarz", panelBlack);

        getContentPane().add(tabpane);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setSize(500, 500);
        setVisible(true);

    }



    public static void main(String[] args) throws IOException {
        testGUI tg = new testGUI();
    }
}
